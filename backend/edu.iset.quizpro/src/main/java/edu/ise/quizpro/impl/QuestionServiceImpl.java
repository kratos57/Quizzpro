package edu.ise.quizpro.impl;




import edu.iset.quizpro.entities.Level;
import edu.iset.quizpro.entities.Question;
import edu.iset.quizpro.repositories.LevelRepository;
import edu.iset.quizpro.repositories.QuestionRepository;
import edu.iset.quizpro.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionDao;

    private LevelRepository levelDao;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionDao, LevelRepository levelDao) {
        this.questionDao = questionDao;
        this.levelDao = levelDao;
    }

    @Override
    public Question addQuestion(Question question, Level level) {
        level.addQuestion(question);
        return questionDao.save(question);
    }
}
