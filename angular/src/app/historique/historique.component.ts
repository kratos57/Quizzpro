import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AddQuestionComponent } from '../add-question/add-question.component';
import { HistoryService } from "../service/history.service";
import { History } from "../model/History";
import { ActivatedRoute, Router } from "@angular/router";
import { User } from '../user/user';
import { UserService } from '../user/user.service';

@Component({
  selector: 'app-historique',
  templateUrl: './historique.component.html',
  styleUrls: ['./historique.component.css']
})
export class HistoriqueComponent implements OnInit {
  userUsername: string | undefined;
  dialogRef: any;
  histories: History[] | undefined;
  title = 'QuizzPro';
  u!: User;
  id: number = 0;
  role: string = "";

  constructor(
    private dialog: MatDialog,
    private historyService: HistoryService,
    private activatedRoute: ActivatedRoute,
    private service: UserService,
    private router: Router,
    private userservice: UserService
  ) {
    this.loadUsers();
    this.role = this.userservice.getrole()!.toUpperCase();
    this.role = this.role.includes("ADMIN") ? "ADMIN" : this.userservice.getrole()!.toUpperCase();
    const storedId = window.localStorage.getItem('id');

    if (storedId !== null) {
      this.id = Number(storedId);
    }

    this.loadUsers();
  }

  ngOnInit(): void {
    // Use 'activatedRoute' instead of 'router'
    this.userUsername = this.activatedRoute.snapshot.params['userUsername'];
    this.historyService.getHistories().subscribe(data => {
      this.histories = data;
    });
  }

  loadUsers() {
    this.service.getUser(this.id).subscribe(data => {
      console.log("comp list");
      this.u = data;
    });
  }
}
