import { Component, OnInit } from '@angular/core';
import {PatientService} from "../patient.service";
import {Patient} from "../patient";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {

  patients: Patient[]
  public deletePatient: Patient;

  page =1;
  count=10;
  pageSize=3;
  pageSizes=[5,10,15,20];
  constructor( private patientService: PatientService ) { }

  ngOnInit(): void {
  this.getPatients();

}

  public getPatients(){

    this.patientService.getPatients().subscribe(
      (data) => {
        this.patients=data;
        console.log(this.patients)
      },
      (error :HttpErrorResponse) =>{
        alert(error.message);
      }
    );
  }

  public openModal(patient: Patient, mode: string) :void {
    if (mode === "delete")
      this.deletePatient = patient

      }
  public onDeletePatient(patientId: number):void{
    this.patientService.deletePatient(patientId).subscribe(
      (response)=>{
      this.getPatients();
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
    }
    )
  }







}
