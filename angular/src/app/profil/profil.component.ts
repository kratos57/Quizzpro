import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../app/user/user.service';
import { User } from '../user/user';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit {
  title = 'QuizzPro';
  u!: User;
  id: number = 0;
  role: string = "";


  constructor(private service: UserService, private route: Router,private userservice: UserService) {
    this.loadUsers();
    this.role = this.userservice.getrole()!.toUpperCase();
    this.role = this.role.includes("ADMIN") ? "ADMIN" : this.userservice.getrole()!.toUpperCase();
    // Retrieve user ID from local storage
    const storedId = window.localStorage.getItem('id');
    
    if (storedId !== null) {
      this.id = Number(storedId);
    }

    this.loadUsers();
  }

  ngOnInit(): void {}

  loadUsers() {
    this.service.getUser(this.id).subscribe(data => {
      console.log("comp list");
      this.u = data;
    });
  }
}
