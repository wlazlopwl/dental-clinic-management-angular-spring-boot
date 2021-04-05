package com.pawelwlazlo.dentalclinic.service;

import com.pawelwlazlo.dentalclinic.exception.doctor.DoctorEmailExistException;
import com.pawelwlazlo.dentalclinic.exception.doctor.DoctorNotFoundException;
import com.pawelwlazlo.dentalclinic.exception.doctor.DoctorPESELExistException;
import com.pawelwlazlo.dentalclinic.model.Doctor;
import com.pawelwlazlo.dentalclinic.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor addDoctor(Doctor doctor) {
        int currentYear = new Date().getYear();
        int yearOfBirth = Integer.parseInt(doctor.getPESEL().substring(0, 2));
        int doctorAge = currentYear - yearOfBirth;
        //TODO age must be calculate with month

//        doctor.setDoctorCode(UUID.randomUUID().toString());
        doctor.setAge(doctorAge);

        if (doctorRepository.existsDoctorByEmail(doctor.getEmail())) {
            throw new DoctorEmailExistException("Email " + doctor.getEmail() + " already exist");
        } else if (doctorRepository.existsDoctorByPESEL(doctor.getPESEL())) {
            throw new DoctorPESELExistException("Pesel " + doctor.getPESEL() + " already exist");
        }


        return doctorRepository.save(doctor);
    }

    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor updateDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    public Doctor findDoctorById(Long id) {
        return doctorRepository.findDoctorById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor by id " + id + " was not found"));
    }

    public Doctor findDoctorByPesel(String pesel) {
        return doctorRepository.findDoctorByPESEL(pesel)
                .orElseThrow(() -> new DoctorNotFoundException("Pesel " + pesel + " was not found"));
    }

    public Page<Doctor> getPaginatedDoctor(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return doctorRepository.findAll(pageable);
    }
}
