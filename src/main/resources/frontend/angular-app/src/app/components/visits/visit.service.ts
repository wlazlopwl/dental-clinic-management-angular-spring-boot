import { Injectable } from '@angular/core';

import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Visit} from "./visit";
import {environment} from "../../../environments/environment";


@Injectable({
  providedIn: 'root'
})
export class VisitService {
  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) { }

  public getVisits(): Observable<Visit[]>{
    return this.http.get<Visit[]>(`${this.apiServerUrl}/visit/all`);
  }
  public addVisit(visit : Visit): Observable<Visit> {
    return this.http.post<Visit>(`${this.apiServerUrl}/visit/add`, visit);
  }
  public updateVisit(visit : Visit): Observable<Visit> {
    return this.http.put<Visit>(`${this.apiServerUrl}/visit/update`, visit);
  }
  public deleteVisit(visitId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/visit/delete/${visitId}`);
  }

  public getVisitById(visitId:Number): Observable<Visit> {
    return this.http.get<Visit>(`${this.apiServerUrl}/visit/find/${visitId}`);
  }
}
