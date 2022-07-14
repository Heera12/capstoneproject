import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ServicesService } from '../services.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Users } from '../users';
import {FormGroup,FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  public signupForm !: FormGroup;

  constructor(private formBuilder : FormBuilder, private http : HttpClient, private router : Router) { }

  ngOnInit(): void {
    this.signupForm = this.formBuilder.group({
      uname:[''],
      email:[''],
      password:[''],
      role:['']
    })
  }
  signUp(){
    this.http.post<any>("http://localhost:9090/cap/project/users/add", this.signupForm?.value).subscribe
    (res=>{
      alert("Sign Up Is Done Succesfully");
      this.signupForm?.reset();
      this.router.navigate(['login']);
    },err=>{
      alert("Something went wrong")

    })
  }
}