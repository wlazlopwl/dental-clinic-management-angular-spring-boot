package com.pawelwlazlo.dentalclinic.controller;

import com.pawelwlazlo.dentalclinic.model.Room;
import com.pawelwlazlo.dentalclinic.model.Visit;
import com.pawelwlazlo.dentalclinic.service.VisitService;
import com.pawelwlazlo.dentalclinic.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visit")
public class VisitController {


    private final VisitService visitService;

    @Autowired
    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Visit>> getAllVisit(){
        List<Visit> visitList = visitService.findAllVisit();


        return new ResponseEntity<>(visitList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Visit> getVisitById(@PathVariable("id") Long id) {
        Visit visit = visitService.findVisitById(id);
        return new ResponseEntity<>(visit, HttpStatus.OK);
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
    public ResponseEntity<Visit> deleteVisit(@PathVariable("id") Long id) {
        visitService.deleteVisitById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
