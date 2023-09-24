import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit  {
  isShow:boolean=true;
  formData={
    customerId:'',
    password:'',
    otp:''
  }

  EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
  + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

  incorrect:string='';
  constructor(
              private router:Router) { }

  ngOnInit(): void {
    
  }
  onShow(){
    this.isShow=!this.isShow;
  }
  // onSubmit(){
  //   this.service.login(this.formData).subscribe((response:any)=>{
  //     console.log(response);
  //   })

  }

   

