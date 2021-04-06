import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {PatientService} from "../patient.service";
import {Patient} from "../patient";
import {HttpErrorResponse} from "@angular/common/http";
import {Router} from "@angular/router";


@Component({
    selector: 'app-patient-add',
    templateUrl: './patient-add.component.html',
    styleUrls: ['./patient-add.component.css']
})
export class PatientAddComponent implements OnInit {
    public patient: FormGroup

    firstName = new FormControl('', [
        Validators.required,
        Validators.minLength(3)
    ]);
    secondName = new FormControl('');
    lastName = new FormControl('', [
        Validators.required,
        Validators.minLength(3)]);
    pesel = new FormControl('', [
        Validators.required,
        Validators.pattern("^[0-9]*$"),
        Validators.maxLength(11),
        Validators.minLength(11)


    ]);
    email = new FormControl('', [
        Validators.required,
        Validators.email
    ]);
    phone = new FormControl('');
    otherPhone = new FormControl('');
    gender = new FormControl('', [
        Validators.required
    ]);


    constructor(private formBuilder: FormBuilder, private patientService: PatientService, private router: Router) {
    }

    ngOnInit(): void {
        this.patient = this.formBuilder.group({
            firstName: this.firstName,
            secondName: this.secondName,
            lastName: this.lastName,
            pesel: this.pesel,
            email: this.email,
            phone: this.phone,
            otherPhone: this.otherPhone,
            gender: this.gender

        })

    }


    onSubmit(patient: FormGroup) {
        this.patientService.addPatient(patient.value).subscribe(
            (response: Patient) => {
                patient.reset();
                this.router.navigate(['patient',response.id]);

            },
            (error: HttpErrorResponse) => {
                console.log(error);
                alert(error.message);
            });

    }
}



