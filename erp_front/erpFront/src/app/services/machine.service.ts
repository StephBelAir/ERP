import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {IMachine} from "../interfaces/imachine";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MachineService {
  apiUrl = environment.apiUrl;

  constructor(private httpClient : HttpClient) { }

  postMachine(machine : any){
    return this.httpClient.post<any>(`${this.apiUrl}/machines/add`,machine);
  }

  getMachine(): Observable<IMachine[]>{
    return this.httpClient.get <IMachine[]>(`${this.apiUrl}/machines`);
  }
}
