package com.pawelwlazlo.dentalclinic.controller;

import com.pawelwlazlo.dentalclinic.dto.PatientDto;
import com.pawelwlazlo.dentalclinic.dto.PatientPostDto;
import com.pawelwlazlo.dentalclinic.mappers.PatientMapper;
import com.pawelwlazlo.dentalclinic.mappers.PatientPostMapper;
import com.pawelwlazlo.dentalclinic.model.Patient;
import com.pawelwlazlo.dentalclinic.service.patient.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patient")
public class PatientController {


    private final PatientService patientService;
    private final PatientMapper patientMapper;
    private final PatientPostMapper patientPostMapper;


    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllPatients(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "") String column,
            @RequestParam(defaultValue = "false") boolean descending
    ) {
        Page<Patient> patientPage;

        if (column.isEmpty()) {
            patientPage = patientService.getPaginatedPatient(page, size);
        } else {
            patientPage = patientService.getPaginatedAndSortingPatient(page, size, column, descending);
        }


        List<Patient> patients = patientPage.getContent();
        List<PatientDto> patientDtos = new ArrayList<>();

        for (Patient patient: patients){
            patientDtos.add(patientMapper.toDTO(patient));
        }

        Map<String, Object> response = new HashMap<>();
        response.put("patients", patientDtos);
        response.put("currentPage", patientPage.getNumber());
        response.put("totalItems", patientPage.getTotalElements());
        response.put("totalPages", patientPage.getTotalPages());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable("id") Long id) {
        Patient patient = patientService.findPatientById(id);
        return new ResponseEntity<>(patientMapper.toDTO(patient), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PatientDto> addPatient(@RequestBody PatientDto patientDto) {

         patientService.addPatient(patientMapper.fromDTO(patientDto));

        return new ResponseEntity<>(patientDto, HttpStatus.CREATED);

    }

    @PutMapping(value = "/update")
    public ResponseEntity<PatientPostDto> updatePatient(@RequestBody PatientPostDto patientPostDto ) {
        patientService.updatePatient(patientPostMapper.fromDTO(patientPostDto));
        return new ResponseEntity<>(patientPostDto, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PatientDto> deletePatient(@PathVariable("id") Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
