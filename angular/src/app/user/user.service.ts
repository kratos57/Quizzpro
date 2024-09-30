import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';

import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  private url='http://localhost:8080/utilisateur';

  constructor(private http:HttpClient) { }
  private username: string = '';

  saveUsername(username: string) {
    this.username = username;
  }

  getUsername(): string {
    return this.username;
  }

 getUserList(){
  return this.http.get<User[]>(this.url);
 }
getUser(id:number){
  return this.http.get<User>(this.url+"/"+id);
}
createUser(u:User){
  return this.http.post<User>(this.url,u);
}
deleteUser(id:number){
  return this.http.delete<User>(this.url+"/"+id);
}
updateUser(u:User){
  return this.http.put<User>(this.url+"/"+u.id,u);
}
updateUserRole(user: any): Observable<any> {
  const url = `${this.url}/updateRoleAndSendEmail`;
  return this.http.post<any>(url, user);
}
getUserByMailAndPassword(email:String,password:String){
  return this.http.get<User>(this.url+"/"+email+"/"+password);
}

forgetPassword(email: string) {

  // Define the params using HttpParams
  const params = new HttpParams().set('email', email);

  // Make the HTTP GET request with the defined params
  return this.http.get(`${this.url}/forgotpassword`, { params });
}
 
 
resetPassword(token: string, newPassword: string) {
  return this.http.put<any>(`${this.url}/resetpassword/${token}`, { newPassword });
}

getToken()
{
 return window.localStorage.getItem('id');
}
getrole()
{
  return window.localStorage.getItem('role');
}

}