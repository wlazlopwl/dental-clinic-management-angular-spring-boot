package com.pawelwlazlo.dentalclinic.controller;

import com.pawelwlazlo.dentalclinic.model.Doctor;
import com.pawelwlazlo.dentalclinic.model.Patient;
import com.pawelwlazlo.dentalclinic.service.DoctorService;
import com.pawelwlazlo.dentalclinic.service.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {


    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Doctor>> getAllDoctors(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "3") int size
            )
    {

//        Page<Doctor> doctorPage = doctorService.getPaginatedDoctor(page, size);
        List<Doctor> doctors = doctorService.findAllDoctors();


        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") Long id) {
        Doctor doctor = doctorService.findDoctorById(id);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {

        Doctor newDoctor = doctorService.addDoctor(doctor);

        return new ResponseEntity<>(newDoctor, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
        Doctor updateDoctor = doctorService.updateDoctor(doctor);
        return new ResponseEntity<>(updateDoctor, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Doctor> deleteDoctor(@PathVariable("id") Long id) {
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
