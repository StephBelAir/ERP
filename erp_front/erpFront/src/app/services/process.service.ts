import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {IProcess} from "../interfaces/iprocess";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProcessService {
  apiUrl = environment.apiUrl;


  constructor(private httpClient : HttpClient) { }

  postProcess(process : any){
    return this.httpClient.post<any>(`${this.apiUrl}/processes/add`,process);
  }

  getProcess(): Observable<IProcess[]>{
    return this.httpClient.get <IProcess[]>(`${this.apiUrl}/processes`);
  }

  patchProcess(machines:any){
    return this.httpClient.patch<any>(`${this.apiUrl}/processes/addMachines`,machines)
  }
}
