import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProcessService {
  apiUrl = environment.apiUrl;


  constructor(private httpClient : HttpClient) { }

  postProcess(process : any){
    return this.httpClient.post<any>(`${this.apiUrl}/processes/add`,process);
  }

  getProcess(){
    return this.httpClient.get <any>(`${this.apiUrl}/processes`);
  }
}
