import {Component, Input, OnInit} from '@angular/core';
import {PatientService} from "../patients/patient.service";
import {HttpErrorResponse} from "@angular/common/http";
import {Patient} from "../patients/patient";
import {ActivatedRoute} from "@angular/router";
import {AbstractControl, FormBuilder, FormControl, FormGroup} from "@angular/forms";


@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.css']
})
export class PatientDetailsComponent implements OnInit {
  _patientId: string;
  patientId: number;
  patient: Patient;



  constructor(private patientService: PatientService, private route: ActivatedRoute, private _fb: FormBuilder) {

  }


  ngOnInit(): void {
    this._patientId = this.route.snapshot.paramMap.get('id');
    this.patientId = +this._patientId
    this.getPatientById(this.patientId);


  }

  public getPatientById(patientId: number) {
    this.patientService.getPatientById(patientId).subscribe(
      (data) => {
        this.patient = data;

      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }


}
