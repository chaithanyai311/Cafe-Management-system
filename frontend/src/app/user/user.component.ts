import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerserviceService } from '../customerservice.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  model: any = {}
  getValue: boolean
  constructor(private customerService:CustomerserviceService,
    private router: Router) { }

  ngOnInit() {
  }
  loginUser(){
    console.log("in side login")
    var username = this.model.username;
    var password = this.model.password;

if(username=="Admin01"&& password=="1100"){
        this.router.navigate(["/display/"]);
      
  }
  else{
    alert(" Invalid Details!")
  }

}
}

