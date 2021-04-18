import {Component, Input, OnInit} from '@angular/core';
import {Patient} from "../../patients/patient";
import {NgForm} from "@angular/forms";
import {PatientService} from "../../patients/patient.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-patient-details-general',
  templateUrl: './patient-details-general.component.html',
  styleUrls: ['./patient-details-general.component.css']
})
export class PatientDetailsGeneralComponent implements OnInit {

  constructor(private patientService: PatientService) { }
  @Input() patient:Patient;
  public editPatient:Patient;


  ngOnInit(): void {


  }

  openModal(patient: Patient, mode: string) {
    if (mode==='edit'){
        this.editPatient=patient;

    }
  }

  updatePatient(patient: Patient) {

  this.patientService.updatePatient(patient).subscribe(
    (response :Patient) => {
      console.log(patient);
      window.location.reload();

    },
    (error: HttpErrorResponse) => {
      console.log(patient.visits);

      alert(error.message);
    }
  );

  }
}
