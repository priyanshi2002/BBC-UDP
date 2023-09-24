import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class LoginService {
  url=" http://localhost:9096"
  
  constructor(private http:HttpClient)
  {}
  login(requestBody:any): Observable<Object>{
    return this.http.post<Object>(`${this.url}auth/login`,requestBody);
  }
  
//     doLogin(Credentials : any)
//     {
//         return this.http.post(`${this.url}/token`,Credentials)
//     }
   
//    //for login User
//   loginUser(token : any)
//   {
//     localStorage.setItem("token",token)
//     return true;
//   }
//    isLoggenIn()
//    {
//     let token= localStorage.getItem("token");
//     if(token==undefined || token=='' || token == null)
//     {
//       return false;
//     }else{
//     return true;
//    }
// }
// // logout User
//  logout()
//  {
//   localStorage.removeItem('token')
//   return true;
//  }

//  getToken()
//  {
//   return localStorage.getItem("token");
//  }
}
