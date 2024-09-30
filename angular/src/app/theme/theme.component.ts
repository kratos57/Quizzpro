import { Component, OnInit } from '@angular/core';
import {Theme} from "../model/Theme";
import {ThemeService} from "../service/theme.service";
import {ActivatedRoute,Router} from "@angular/router";
import { User } from '../user/user';
import { UserService } from '../user/user.service';

@Component({
  selector: 'app-theme',
  templateUrl: './theme.component.html',
  styleUrls: ['./theme.component.css']
})
export class ThemeComponent implements OnInit {
  title = 'QuizzPro';
  u!: User;
  id: number = 0;
  themes!: Theme[];
  userUsername!: string;
  constructor(private themeService: ThemeService, private router: Router, private route: ActivatedRoute,private service: UserService) {   const storedId = window.localStorage.getItem('id');
    
  if (storedId !== null) {
    this.id = Number(storedId);
  }

  this.loadUsers(); }

  ngOnInit(): void {
    this.userUsername = this.route.snapshot.params['userUsername'];
    this.themeService.getThemes().subscribe(themes => {
      this.themes = themes;
    })
  }
  logout(): void {
    this.router.navigate(['/authentification']);
  }
  loadUsers() {
    this.service.getUser(this.id).subscribe(data => {
      console.log("comp list");
      this.u = data;
    });}
}
