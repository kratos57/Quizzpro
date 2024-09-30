import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css']
})
export class UserEditComponent implements OnInit {
  users: User = new User;
  id!:number;
  constructor(private service:UserService, private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params[('id')];
    this.service.getUser(this.id).subscribe(data=>{
    this.users=data;
  })
}
  modifUser(){
  this.service.updateUser(this.users).subscribe(data=>{
this.router.navigate(['list']);
  })
  }

}
  

