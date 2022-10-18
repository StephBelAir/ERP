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

  getLot(): Observable<ILot[]>{
    return this.httpClient.get <ILot[]>(`${this.apiUrl}/lots`);
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

  /*
  patchLot(lotId: Number, startLot: Date, endLot: Date) {
    const resultStart = this.httpClient.patch(`${this.apiUrl}/lot/patch/startDate`, startLot)
    const resultEnd = this.httpClient.patch(`${this.apiUrl}/lot/patch/endDate`, endLot)
    return `${resultStart} - ${resultEnd}`;
  }*/
}
