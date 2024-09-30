import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Question } from "../model/Question";
import { QuestionService } from "../service/question.service";
import { ActivatedRoute } from "@angular/router";
import { timer } from "rxjs";
import { ResultComponent } from "../result/result.component";
import { LevelService } from "../service/level.service";
import { HistoryService } from "../service/history.service";
import { History } from "../model/History";
import { UserService } from "../service/user.service";
import { MatRadioChange } from '@angular/material/radio';

@Component({
  selector: 'app-quizz',
  templateUrl: './quizz.component.html',
  styleUrls: ['./quizz.component.css']
})
export class QuizzComponent implements OnInit {
  dialogRef: any;
  questions!: Question[];
  history: History = {} as History;
  idLevel!: number;
  level: any;
  counter = 0;
  score = 0;
  btnDisabled = true;
  username!: string;

  constructor(
    private dialog: MatDialog,
    private questionService: QuestionService,
    private route: ActivatedRoute,
    private levelService: LevelService,
    private historyService: HistoryService,
    private userService: UserService
  ) {}

  ngOnInit(): void {
    this.username = this.userService.getUsername();
    this.idLevel = this.route.snapshot.params['idLevel'];

    this.questionService.getQuestions(this.idLevel).subscribe(data => {
      this.questions = this.shuffleArray(data);
    });

    this.levelService.getLevel(this.idLevel).subscribe(level => {
      this.level = level;
    });

    timer(0, 1000).subscribe(() => {
      this.counter += 1;
    });
  }

  shuffleArray(array: any[]): any[] {
    // Function to shuffle the array
    for (let i = array.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [array[i], array[j]] = [array[j], array[i]];
    }
    return array;
  }

  openResult(themeName: string, levelName: string): void {
    const counter = this.counter;
    const score = this.score;
    const username = this.username;

    this.history.total = counter;
    this.history.themeName = themeName;
    this.history.levelName = levelName;
    this.history.username = username;
    this.history.sore = score;

    this.dialogRef = this.dialog.open(ResultComponent, {
      width: '420px',
      data: { score, counter, themeName, levelName }
    });

    this.historyService.findHistoryByUsername(username).subscribe(data => {
      if (data && data.length > 0) {
        const existingHistory = data[0];
        if (score > existingHistory.sore) {
          existingHistory.sore = score;
          this.historyService.editHistory(existingHistory, username).subscribe();
        }
      } else {
        this.historyService.addHistory(this.history).subscribe();
      }
    });
  }

  setResponses(event: MatRadioChange): void {
    const selectedOption = event.value; // Get the selected value from the event
    // Compare selectedOption to question.correct
    if (selectedOption) {
      this.questions.forEach(question => {
        if (selectedOption === question.correct) {
          this.score++;
        }
      });
      this.btnDisabled = false;
    }
  }
}
