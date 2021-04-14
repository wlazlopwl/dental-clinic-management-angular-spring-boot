import {Component, OnInit} from '@angular/core';
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

    page = 1;
    count = -1;
    pageSize = 5;
    columnToSort = '';
    sortDescending = false;
    pageSizes = [5, 10, 15, 20, 25, 30];

    constructor(private patientService: PatientService) {
    }

    ngOnInit(): void {
        this.getPatients();

    }

    public getPatients() {
        const params = this.setParams(this.page, this.pageSize, this.columnToSort, this.sortDescending);
        this.patientService.getPatients(params).subscribe(
            response => {
                const {patients, totalItems} = response;
                this.patients = patients;
                this.count = totalItems;

            }
        )


    }

    setParams(page: number, pageSize: number, columnToSort: string, sortDescending: boolean): any {
        let params: any = {};
        if (page) {
            params[`page`] = page - 1;
        }
        if (pageSize) {
            params[`size`] = pageSize;
        }
        params[`column`] = columnToSort;
        params[`descending`] = sortDescending;

        return params;
    }

    public openModal(patient: Patient, mode: string): void {
        if (mode === "delete")
            this.deletePatient = patient

    }

    public onDeletePatient(patientId: number): void {
        this.patientService.deletePatient(patientId).subscribe(
            (response) => {
                this.getPatients();
            },
            (error: HttpErrorResponse) => {
                alert(error.message);
            }
        )
    }


    pageSizeChange(event: any): void {
        this.pageSize = event.target.value;
        this.page = 1;
        this.getPatients();
    }

    changePage(event: number) {
        this.page = event;
        this.getPatients();

    }

    changeGenderSort() {
        this.columnToSort = 'gender';
        this.sortDescending = !this.sortDescending;
        this.getPatients();
    }

    sortByPESEL() {
        this.columnToSort = 'PESEL';
        this.sortDescending = !this.sortDescending;
        this.getPatients();
    }


    sortByLastName() {
        this.columnToSort = 'lastName';
        this.sortDescending = !this.sortDescending;
        this.getPatients();
    }
}
