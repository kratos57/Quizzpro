import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-add',
  templateUrl: './user-add.component.html',
  styleUrls: ['./user-add.component.css']
})
export class UserAddComponent implements OnInit {
  users: any = {};
  constructor(private service:UserService, private router:Router) { }

  ngOnInit(): void {
    
  }
  ajouterUser(){
    this.service.createUser(this.users).subscribe(data=>{
      this.users=new User();
      this.router.navigate(['list']);

    })
  }

}
