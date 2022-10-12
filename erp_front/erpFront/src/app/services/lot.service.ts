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

}
