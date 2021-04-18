package com.pawelwlazlo.dentalclinic.controller;

import com.pawelwlazlo.dentalclinic.dto.VisitDto;
import com.pawelwlazlo.dentalclinic.mappers.VisitMapper;
import com.pawelwlazlo.dentalclinic.model.Visit;
import com.pawelwlazlo.dentalclinic.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/visit")
public class VisitController {


    private final VisitService visitService;
    private final VisitMapper visitMapper;

    @GetMapping("/all")
    public ResponseEntity<List<Visit>> getAllVisit() {
        List<Visit> visitList = visitService.findAllVisit();


        return new ResponseEntity<>(visitList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<VisitDto> getVisitById(@PathVariable("id") Long id) {
        Visit visit = visitService.findVisitById(id);
        return new ResponseEntity<>(visitMapper.toDTO(visit), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Visit> addVisit(@RequestBody Visit visit) {

        Visit newVisit = visitService.addVisit(visit);

        return new ResponseEntity<>(newVisit, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Visit> updateVisit(@RequestBody Visit visit) {
        Visit updateVisit = visitService.updateVisit(visit);
        return new ResponseEntity<>(updateVisit, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<VisitDto> deleteVisit(@PathVariable("id") Long id) {
        visitService.deleteVisitById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
