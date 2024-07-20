import { Injectable } from '@angular/core';
import {LoginRequest} from "../model/LoginRequest";
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, retry, throwError} from "rxjs";
import {SignupRequest} from "../model/SignupRequest";
import {UtenteDto} from "../model/UtenteDto";

@Injectable({
  providedIn: 'root'
})
export class UtenteService {

  constructor(private http: HttpClient) {
  }
  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      console.error('An error occured: ', error.error); //errore del client o della rete
    }
    else {
      console.error('Backend returned code ${error.status}, body was: ', error.error);
    }
    return throwError(() => new Error('Something bad happened'));
  }

  getAll(): Observable<UtenteDto[]> {
    return this.http.get<UtenteDto[]>("http://localhost:8080/api/utente/get/all").pipe(retry(3), catchError(this.handleError));
  }

  login(loginrequest: LoginRequest): Observable<LoginRequest> {
    //const body = { "email": loginrequest.email, "password": loginrequest.password };
    let headers: HttpHeaders = new HttpHeaders().set('Content-Type', 'application/json'); //
    return this.http.post<LoginRequest>("http://localhost:8080/api/utente/login", JSON.stringify(loginrequest), { headers: headers}).pipe(
      retry(3),
      catchError(this.handleError));
  }

  signup(signuprequest: SignupRequest): Observable<SignupRequest> {
    let headers: HttpHeaders = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post<SignupRequest>("http://localhost:8080/api/utente/reg", JSON.stringify(signuprequest), { headers: headers}).pipe(
      retry(3),
      catchError(this.handleError));
  }


}
