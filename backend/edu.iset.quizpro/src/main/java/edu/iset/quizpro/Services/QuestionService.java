package edu.iset.quizpro.Services;


import edu.iset.quizpro.entities.Level;
import edu.iset.quizpro.entities.Question;
import org.springframework.stereotype.Service;

@Service
public interface QuestionService {
  Question addQuestion(Question question, Level level);
}
