package com.pawelwlazlo.dentalclinic.repository;

import com.pawelwlazlo.dentalclinic.model.Patient;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface PatientRepository extends JpaRepository<Patient, Long> {


    void deleteById(Long id);

    Optional<Patient> findPatientById(Long id);

    Optional<Patient> findPatientByPESEL(String pesel);
    Optional<Patient> findPatientByEmail(String email);


    boolean existsPatientByEmail(String email);

    boolean existsPatientByPESEL(String pesel);
}
