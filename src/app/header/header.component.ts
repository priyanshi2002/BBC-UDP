import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  
  constructor() { }

  ngOnInit(): void {
  }

  // onSubmit()
  // {
  //   console.log("Submit"+formData.username + formData.password);

  //    if((this.credentials.username!='' && this.credentials.password!='') && (this.credentials.username!=null && this.credentials.password!=null)) 
  //    {
  //       console.log("Submit form to server");
        
  //       //generate token
        
  //    }else{
  //     console.log("Fields are empty !!");
  //    }
  // }
}
