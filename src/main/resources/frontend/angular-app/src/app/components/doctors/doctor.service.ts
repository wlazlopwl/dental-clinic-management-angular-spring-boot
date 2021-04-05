import {Injectable} from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Doctor} from "./doctor";

@Injectable({
  providedIn: 'root'
})
export class DoctorService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  }

  public getDoctors(): Observable<Doctor[]> {
    return this.http.get<Doctor[]>(`${this.apiServerUrl}/doctor/all`);
  }

  public addDoctor(doctor: Doctor): Observable<Doctor> {
    return this.http.post<Doctor>(`${this.apiServerUrl}/doctor/add`, doctor);
  }

  public updateDoctor(doctor: Doctor): Observable<Doctor> {
    return this.http.put<Doctor>(`${this.apiServerUrl}/doctor/update`, doctor);
  }

  public deleteDoctor(doctorId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/doctor/delete/${doctorId}`);
  }

  public getDoctorById(doctorId: Number): Observable<Doctor> {
    return this.http.get<Doctor>(`${this.apiServerUrl}/doctor/find/${doctorId}`);
  }

}
