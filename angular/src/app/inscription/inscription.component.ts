import { Component, OnInit } from '@angular/core';

import { UserService } from '../user/user.service';
import { User } from '../user/user';
import { Router } from '@angular/router';


@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {
  users: any = {};
  constructor(private service:UserService, private router:Router) { }

  ngOnInit(): void {
  }

  ajouterUser(){

    if (this.users.email!=null&&this.users.password!=null){ 
    this.service.createUser(this.users).subscribe(data=>{
      this.users=new User();
      this.router.navigate(['authentification']);

    })
    }else alert('remplir les champs')
  }

}
