import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Quiz } from 'src/quizservice/quiz';
import { QuizService } from 'src/quizservice/quiz.service';
import { UserService } from '../user/user.service';
import { User } from '../user/user';

@Component({
  selector: 'app-homequizz',
  templateUrl: './homequizz.component.html',
  styleUrls: ['./homequizz.component.css']
})
export class HomequizzComponent implements OnInit {
  quizz: Quiz[] = [];
  title = 'QuizzPro';
  role: string = "";
  u!: User;
  id: number = 0;
  userUsername = '';


  constructor(private service: QuizService, private ervice: UserService, private router: Router, private userservice: UserService,private userService: UserService) {
   
    const storedId = window.localStorage.getItem('id');
      if (storedId !== null) {
      this.id = Number(storedId);
    }

    this.loadUsers();
    this.role = this.userservice.getrole()!.toUpperCase();
    this.role = this.role.includes("ADMIN") ? "ADMIN" : this.userservice.getrole()!.toUpperCase();
  }

  ngOnInit(): void {
    this.loadQuizz();
  }

  loadUsers() {
    this.ervice.getUser(this.id).subscribe((data: any) => {
      console.log("comp list");
      this.u = data;
    });
  }

  loadQuizz() {
    this.service.getQuizList().subscribe((data: Quiz[]) => {
      console.log("comp list", data);
      this.quizz = data;
    });
  }

  logout() {
    window.localStorage.removeItem('id');
    window.localStorage.removeItem('role');
    window.location.reload();
  }
  userLogin(userUsername: string) {
    console.log(userUsername.length);
    if (userUsername.length < 2) {
      alert('Please enter correct username');
    } else {
      this.userService.saveUsername(userUsername);
      window.location.replace(`/historique/${userUsername}`);
    }
  }
}
