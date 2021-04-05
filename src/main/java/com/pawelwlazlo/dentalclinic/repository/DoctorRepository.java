package com.pawelwlazlo.dentalclinic.repository;

import com.pawelwlazlo.dentalclinic.model.Doctor;
import com.pawelwlazlo.dentalclinic.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {


    Optional<Doctor> findDoctorById(Long id);

    Optional<Doctor> findDoctorByPESEL(String pesel);

    boolean existsDoctorByPESEL(String pesel);

    boolean existsDoctorByEmail(String email);
}
