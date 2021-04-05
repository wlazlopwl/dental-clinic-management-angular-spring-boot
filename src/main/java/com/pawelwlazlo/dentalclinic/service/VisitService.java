package com.pawelwlazlo.dentalclinic.service;

import com.pawelwlazlo.dentalclinic.exception.VisitNotFoundException;
import com.pawelwlazlo.dentalclinic.model.Room;
import com.pawelwlazlo.dentalclinic.model.Visit;
import com.pawelwlazlo.dentalclinic.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitService {

    private final VisitRepository visitRepository;

    @Autowired
    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public Visit addVisit(Visit visit) {
        return visitRepository.save(visit);
    }

    public Visit updateVisit(Visit visit) {
        return visitRepository.save(visit);
    }

    public List<Visit> findAllVisit() {
        return visitRepository.findAll();
    }

    public void deleteVisitById(Long id) {
        visitRepository.deleteById(id);
    }

    public Visit findVisitById(Long id) {
        return visitRepository.findVisitById(id).orElseThrow(() ->
        new VisitNotFoundException("Visit by id " + id + " was not found"));
    }

}
