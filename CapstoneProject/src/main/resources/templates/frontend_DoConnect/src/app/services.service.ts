import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {

  constructor(private http:HttpClient) { }
getQuestions():Observable<object>
{
  return this.http.get("http://localhost:9090/cap/project/quest/getall");
}

getAnswers():Observable<object>
{
  return this.http.get("http://localhost:9090/cap/project/answers/getall");
}

getUsers():Observable<object>
{
  return this.http.get("http://localhost:9090/cap/project/users/getall");
}
addUsers(data:any){
  return this.http.post<any>("http://localhost:9090/cap/project/users/add", data).pipe(map((res:any)=>{
    return res;
  }))
}
}