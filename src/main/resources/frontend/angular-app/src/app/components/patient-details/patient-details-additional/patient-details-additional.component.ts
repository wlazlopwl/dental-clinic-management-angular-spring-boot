import {Component, Input, OnInit} from '@angular/core';
import {Patient} from "../../patients/patient";

@Component({
  selector: 'app-patient-details-additional',
  templateUrl: './patient-details-additional.component.html',
  styleUrls: ['./patient-details-additional.component.css']
})
export class PatientDetailsAdditionalComponent implements OnInit {
@Input() patient: Patient
  constructor() { }

  ngOnInit(): void {
  }

}
