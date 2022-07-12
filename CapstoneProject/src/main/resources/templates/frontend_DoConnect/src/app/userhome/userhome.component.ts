import { Component, OnInit } from '@angular/core';
import { ServicesService } from '../services.service'
@Component({
  selector: 'app-userhome',
  templateUrl: './userhome.component.html',
  styleUrls: ['./userhome.component.css']
})
export class UserhomeComponent implements OnInit {
  questions: any;

  constructor(private service : ServicesService) { }

  ngOnInit(): void {
    this.service.getQuestions().subscribe(data=>{
      this.questions=data;
    })
  }

}
