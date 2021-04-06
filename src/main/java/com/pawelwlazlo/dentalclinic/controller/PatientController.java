package com.pawelwlazlo.dentalclinic.controller;

import com.pawelwlazlo.dentalclinic.model.Patient;
import com.pawelwlazlo.dentalclinic.service.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PatientController {


    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllPatients(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {

        Page<Patient> patientPage = patientService.getPaginatedPatient(page, size);
        List<Patient> patients = patientPage.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("patients", patients);
        response.put("currentPage", patientPage.getNumber());
        response.put("totalItems", patientPage.getTotalElements());
        response.put("totalPages", patientPage.getTotalPages());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") Long id) {
        Patient patient = patientService.findPatientById(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {

        Patient newPatient = patientService.addPatient(patient);

        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);

    }

    @PutMapping(value = "/update")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
        Patient updatePatient = patientService.updatePatient(patient);
        return new ResponseEntity<>(updatePatient, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Patient> deletePatient(@PathVariable("id") Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
