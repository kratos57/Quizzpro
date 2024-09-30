package edu.iset.quizpro.manager;


import edu.iset.quizpro.dto.QuestionDto;
import edu.iset.quizpro.entities.Level;
import edu.iset.quizpro.entities.Question;
import edu.iset.quizpro.mappers.QuestionMapper;
import edu.iset.quizpro.repositories.LevelRepository;
import edu.iset.quizpro.repositories.QuestionRepository;
import edu.iset.quizpro.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class QuestionManagerImpl implements QuestionManager {

    private final QuestionMapper questionMapper;
    private final QuestionRepository questionDao;
    private final LevelRepository levelDao;
    private final QuestionService questionService;

    @Autowired
    public QuestionManagerImpl(QuestionMapper questionMapper, QuestionRepository questionDao,
                               LevelRepository levelDao, QuestionService questionService) {
        this.questionMapper = questionMapper;
        this.questionDao = questionDao;
        this.levelDao = levelDao;
        this.questionService = questionService;
    }

    @Override
    public QuestionDto addQuestion(QuestionDto questionDto, Long idLevel) {
        Question question = questionMapper.toEntity(questionDto);
        Level level = levelDao.getOne(idLevel);
        return questionMapper.toDto(questionService.addQuestion(question, level));
    }

    @Override
    public List<QuestionDto> getQuestions(Long idLevel) {
        Level level = levelDao.getOne(idLevel);
        List<Question> questions = level.getQuestions();
        return questionMapper.toDtoList(questions);
    }
}

// Other Manager implementations (ThemeManager, HistoryManager) will follow a similar structure using respective mappers (ThemeMapper, HistoryMapper)
