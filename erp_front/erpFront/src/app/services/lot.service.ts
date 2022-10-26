import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {ILot} from "../interfaces/ilot";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LotService {
  apiUrl = environment.apiUrl;


  constructor(private httpClient : HttpClient,) { }


  postLot(lot : any){
    return this.httpClient.post<any>(`${this.apiUrl}/lots/add`,lot)
  }

  getLot(): Observable<any>{
    return this.httpClient.get <any>(`${this.apiUrl}/lots`);
  }

  addProcess(lot : any){
    return this.httpClient.patch<any>(`${this.apiUrl}/lot/addProcess`,lot)
  }

  patchLot(lot : any){
    return this.httpClient.patch<any>(`${this.apiUrl}/lot/launchLot`,lot)
  }

  patchEndLot(lot : any){
    return this.httpClient.patch<any>(`${this.apiUrl}/lot/endLot`,lot)
  }
}
