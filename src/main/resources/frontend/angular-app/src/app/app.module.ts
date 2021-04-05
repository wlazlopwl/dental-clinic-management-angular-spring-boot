import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PatientListComponent } from './components/patients/patient-list/patient-list.component';
import {PatientService} from "./components/patients/patient.service";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { PatientDetailsComponent } from './components/patient-details/patient-details.component';
import { PatientDetailsGeneralComponent } from './components/patient-details/patient-details-general/patient-details-general.component';
import { PatientDetailsAdditionalComponent } from './components/patient-details/patient-details-additional/patient-details-additional.component';
import { PatientDetailsHistoryComponent } from './components/patient-details/patient-details-history/patient-details-history.component';
import {PaginationModule} from "ngx-bootstrap/pagination";
import {NgxPaginationModule} from "ngx-pagination";
import { VisitListComponent } from './components/visits/visit-list/visit-list.component';
import {PatientAddComponent} from "./components/patients/patient-add/patient-add.component";
import { DoctorListComponent } from './components/doctors/doctor-list/doctor-list.component';
import { RoomListComponent } from './components/rooms/room-list/room-list.component';



@NgModule({
  declarations: [
    AppComponent,
    PatientListComponent,
    PatientAddComponent,
    PatientDetailsComponent,
    PatientDetailsGeneralComponent,
    PatientDetailsAdditionalComponent,
    PatientDetailsHistoryComponent,
    VisitListComponent,
    DoctorListComponent,
    RoomListComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        ReactiveFormsModule,
        NgbModule,
        PaginationModule,
        NgxPaginationModule,
        FormsModule


    ],
  providers: [PatientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
