import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PatientAddComponent} from "./components/patients/patient-add/patient-add.component";
import {PatientListComponent} from "./components/patients/patient-list/patient-list.component";
import {PatientDetailsComponent} from "./components/patient-details/patient-details.component";
import {DoctorListComponent} from "./components/doctors/doctor-list/doctor-list.component";
import {VisitListComponent} from "./components/visits/visit-list/visit-list.component";

const routes: Routes = [

  //Patient

  {
    path: 'patient', component: PatientListComponent
  },

  {path: 'patient/add', component: PatientAddComponent},
  {
    path: 'patient/:id', component: PatientDetailsComponent
  },
  //DOCTOR
  {
    path: 'doctors', component: DoctorListComponent
  },

  //VISIT

  {
    path: 'visits', component: VisitListComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
