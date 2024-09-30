export class Quiz{
  id!: number;
  title!:string;
  questions: Array<Question> = [];

}

export class Question {
  id!: number;
  questionText!: string;
  answers: Array<string> = [];
  correctAnswer!: string;
}
