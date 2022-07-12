import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ServicesService {

  constructor(private http:HttpClient) { }
getQuestions():Observable<object>
{
  return this.http.get("http://localhost:9090/cap/project/quest/getall");
}
}
