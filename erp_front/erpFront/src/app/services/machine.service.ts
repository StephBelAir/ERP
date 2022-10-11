import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class MachineService {
  apiUrl = environment.apiUrl;

  constructor(private httpClient : HttpClient) { }

  postMachine(machine : any){
    return this.httpClient.post<any>(`${this.apiUrl}/machines/add`,machine);
  }

  getMachine(){
    return this.httpClient.get<any>(`${this.apiUrl}/machines`);
  }
}
