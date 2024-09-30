import { Component, OnInit } from '@angular/core';
import { UserService as UserService1 } from '../user/user.service';
import { UserService as UserService2 } from '../service/user.service';
import { Router } from '@angular/router';
import { Quiz } from 'src/quizservice/quiz';

@Component({
  selector: 'app-authentification',
  templateUrl: './authentification.component.html',
  styleUrls: ['./authentification.component.css']
})
export class AuthentificationComponent implements OnInit {
  users: any = {};
  adminUsername = '';
  quizz: Quiz[] = [];
  title = 'QuizzPro';
  role: string = '';
  id: number = 0;
  userUsername = '';

  constructor(private userService1: UserService1, private userService2: UserService2, private router: Router) {}

  ngOnInit(): void {}

  authentifier() {
    this.userService1.getUserByMailAndPassword(this.users.email, this.users.password).subscribe(
      (data) => {
        console.log('success');

        window.localStorage.setItem('id', data.id.toString());
        window.localStorage.setItem('role', data.roll.toString());
        this.router.navigate(['/homequizz']);
      },
    );
  }

  userLogin(userUsername: string) {
    console.log(userUsername.length);
    if (userUsername.length < 2) {
      alert('Please enter correct username');
    } else {
      this.userService2.saveUsername(userUsername);
      
    }
  }
}
