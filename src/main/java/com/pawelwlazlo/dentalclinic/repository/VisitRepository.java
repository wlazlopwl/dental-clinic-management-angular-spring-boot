package com.pawelwlazlo.dentalclinic.repository;

import com.pawelwlazlo.dentalclinic.model.Room;
import com.pawelwlazlo.dentalclinic.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    Optional<Visit> findVisitById(Long id);
}
