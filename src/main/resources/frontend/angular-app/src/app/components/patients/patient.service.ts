import {Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Patient} from "./patient";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class PatientService {
  private apiServerUrl = environment.apiBaseUrl ;

  constructor(private http: HttpClient) {
  }

  public getPatients(params:any): Observable<any> {
    return this.http.get<any>(`${this.apiServerUrl}/patient/all`,{params});
  }

  public addPatient(patient : Patient): Observable<Patient> {
    return this.http.post<Patient>(`${this.apiServerUrl}/patient/add`, patient);
  }
  public updatePatient(patient : Patient): Observable<Patient> {
    return this.http.put<Patient>(`${this.apiServerUrl}/patient/update`, patient);
  }
  public deletePatient(patientId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/patient/delete/${patientId}`);
  }

  public getPatientById(patientId:Number): Observable<Patient> {
    return this.http.get<Patient>(`${this.apiServerUrl}/patient/find/${patientId}`);
  }
}
