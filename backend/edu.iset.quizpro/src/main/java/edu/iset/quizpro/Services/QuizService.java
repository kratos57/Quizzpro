package edu.iset.quizpro.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.iset.quizpro.entities.Quiz;
import edu.iset.quizpro.repositories.QuizRepository;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Quiz updateQuiz(Long id, Quiz updatedQuiz) {
        Quiz existingQuiz = quizRepository.findById(id).orElse(null);
        if (existingQuiz != null) {
            existingQuiz.setTitle(updatedQuiz.getTitle());
            return quizRepository.save(existingQuiz);
        }
        return null;
    }

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }
}
