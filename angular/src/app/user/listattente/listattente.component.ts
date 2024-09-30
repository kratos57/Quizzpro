import { Component, OnInit  } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-listattente',
  templateUrl: './listattente.component.html',
  styleUrls: ['./listattente.component.css']
})
export class ListattenteComponent implements OnInit  {
 
  title = 'QuizzPro';
  users ! : User[];
   
   
    constructor(private service: UserService, private route:Router) { }
  
    ngOnInit(): void {
      this.loadUsers();
    }
    loadUsers(){
      this.service.getUserList().subscribe(data =>{
        console.log("comp list");
        this.users=data;
      });
    }
    removeUser(id:number){
      this.service.deleteUser(id).subscribe(data=>{
        this.loadUsers();
      })
    }
    updateUser(id:number){  
        this.route.navigate(['molistattente',id]);
        this.loadUsers();
    }
  
  }
