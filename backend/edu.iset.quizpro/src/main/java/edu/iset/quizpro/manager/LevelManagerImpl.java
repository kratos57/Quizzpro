package edu.iset.quizpro.manager;

import edu.iset.quizpro.dto.LevelDto;
import edu.iset.quizpro.entities.Level;
import edu.iset.quizpro.entities.Theme;
import edu.iset.quizpro.mappers.LevelMapper;
import edu.iset.quizpro.repositories.LevelRepository;
import edu.iset.quizpro.repositories.ThemeRepository;
import edu.iset.quizpro.Services.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;



@Transactional
@Service
public class LevelManagerImpl implements LevelManager {

    private final LevelService levelService;
    private final LevelRepository levelDao;
    private final LevelMapper levelMapper;
    private final ThemeRepository themeDao;

    @Autowired
    public LevelManagerImpl(LevelService levelService, LevelRepository levelDao, LevelMapper levelMapper, ThemeRepository themeDao) {
        this.levelService = levelService;
        this.levelDao = levelDao;
        this.levelMapper = levelMapper;
        this.themeDao = themeDao;
    }

    @Override
    public LevelDto addLevel(LevelDto levelDto, Long idTheme) {
        Theme theme = themeDao.getOne(idTheme);
        Level level = levelMapper.toEntity(levelDto);
        return levelMapper.toDto(levelService.addLevel(level, theme));
    }

    @Override
    public List<LevelDto> getLevels(Long idTheme) {
        Theme theme = themeDao.getOne(idTheme);
        List<Level> levels = theme.getLevels();
        return levels.stream()
                .map(levelMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public LevelDto getLevel(Long idTheme) {
        return levelMapper.toDto(levelDao.getOne(idTheme));
    }
    @Override
    public void deleteLevel(Long id) {
        levelDao.deleteById(id);
    }
}

// Other Manager implementations (QuestionManager, ThemeManager) will follow a similar structure using respective mappers (QuestionMapper, ThemeMapper)
