import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { QuizService } from 'src/quizservice/quiz.service';
import { Quiz } from 'src/quizservice/quiz';

@Component({
  selector: 'app-quizparticipation',
  templateUrl: './quizparticipation.component.html',
  styleUrls: ['./quizparticipation.component.css']
})
export class QuizparticipationComponent implements OnInit {
  quiz: Quiz | null = null;
  selectedValues: string[] = []; // Use string array for storing selected answer texts
  totalScore: number = 0;

  constructor(
    private route: ActivatedRoute,
    private quizService: QuizService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const quizId = +params.get('id')!;
      this.loadQuiz(quizId);
    });
  }

  private loadQuiz(quizId: number): void {
    this.quizService.getQuizById(quizId).subscribe(
      (quiz: Quiz) => {
        this.quiz = quiz;
      },
      error => {
        console.error('Error loading quiz:', error);
      }
    );
  }

  validerquiz(): void {
    if (this.quiz) {
      for (let i = 0; i < this.quiz.questions.length; i++) {
        const question = this.quiz.questions[i];
        const selectedAnswerText = this.selectedValues[i];

        if (selectedAnswerText && selectedAnswerText === question.correctAnswer) {
          // Correct answer selected, increment total score
          this.totalScore++;
        }
      }

      // Output or use the total score as needed
      console.log('Total Score:', this.totalScore);
    }
  }
}
