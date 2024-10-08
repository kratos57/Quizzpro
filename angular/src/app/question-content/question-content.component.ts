import { AddThemeComponent } from './../add-theme/add-theme.component';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { InscriptionComponent } from '../inscription/inscription.component';
import {Question} from "../model/Question";
import {QuestionService} from "../service/question.service";
import {ActivatedRoute} from "@angular/router";
import {Response} from "../model/Response";
import {ResponseService} from "../service/response.service";

@Component({
  selector: 'app-question-content',
  templateUrl: './question-content.component.html',
  styleUrls: ['./question-content.component.css']
})
export class QuestionContentComponent implements OnInit {
  questions: Question[] = [];
  responses: Response[] = [];
  dialogRef: any;
  id: number = 0;
  

  constructor(private dialog: MatDialog, private questionService: QuestionService, private route: ActivatedRoute,
              private responseService: ResponseService) {
    this.route.params.subscribe(
      params => {
        this.id = this.route.snapshot.params['id'];
        this.questionService.getQuestions(this.id).subscribe(questions => {
          this.questions = questions;
        });
      }
    )
  }

  ngOnInit(): void {
  }
  // tslint:disable-next-line: typedef
  public openRegister() {
    this.dialogRef = this.dialog.open(InscriptionComponent, {
      width: '420px'
    });
  }
  findResponse(id: number) {
  this.responseService.getResponses(id).subscribe(res => {
    this.responses = res;
  })
  }
}
