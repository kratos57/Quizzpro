package edu.iset.quizpro.manager;

import edu.iset.quizpro.Services.QuestionService;
import edu.iset.quizpro.entities.Level;
import edu.iset.quizpro.entities.Question;
import edu.iset.quizpro.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    @Transactional
    public Question addQuestion(Question question, Level level) {
        // Set the level for the question
        question.setLevel(level);

        // Save the question to the database
        Question savedQuestion = questionRepository.save(question);

        return savedQuestion;
    }
}
