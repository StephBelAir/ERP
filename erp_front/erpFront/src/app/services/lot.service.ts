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
    return this.httpClient.post<any>(`${this.apiUrl}/lots/add/{id}/process/{processId}`,lot)
  }


  /**
   *
   *
   patchHero (id: number, heroName: string): Observable<{}> {
    const url = `${this.heroesUrl}/${id}`;   // PATCH api/heroes/42
    return this.httpClient.patch(url, {name: heroName}, httpOptions)
      .pipe(catchError(this.handleError('patchHero')));
  }

   addProcess(id: number, processId: number): Observable<{}>{
    // @ts-ignore
    return this.httpClient.post(`${this.apiUrl}/lots/add/${this.id}/process/${this.processId}`);
      //`${this.apiUrl}/lots/add/{id}/process/{processId}`,lot)
  }

   * public getAccount(accountId: number, page: number, size: number) :Observable<AccountDetails>{
   *     return this.httpClient.get<AccountDetails>(this.apiUrl +'/'+ accountId + "/pageOperations?page/" + page + "&size="+size);
   *   }
   */



}
