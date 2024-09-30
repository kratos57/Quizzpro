import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Quiz } from './quiz';

import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuizService {
  private url='http://localhost:8080/quizz';

  constructor(private http:HttpClient) {}

    getQuizList(){
      return this.http.get<Quiz[]>(this.url);
     }

     getQuizById(quizId: number): Observable<Quiz> {
      const quizUrl = `${this.url}/${quizId}`;
      return this.http.get<Quiz>(quizUrl);
    }



}
