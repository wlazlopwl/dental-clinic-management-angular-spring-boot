import {Component, Input, OnInit} from '@angular/core';
import {Patient} from "../../patients/patient";
import {Visit} from "../../visits/visit";

@Component({
  selector: 'app-patient-details-history',
  templateUrl: './patient-details-history.component.html',
  styleUrls: ['./patient-details-history.component.css']
})
export class PatientDetailsHistoryComponent implements OnInit {
  @Input() visits: Visit[]
  constructor() { }

  ngOnInit(): void {
  }

}
