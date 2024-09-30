package edu.iset.quizpro.manager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iset.quizpro.entities.Level;
import edu.iset.quizpro.entities.Theme;
import edu.iset.quizpro.repositories.LevelRepository;
import edu.iset.quizpro.repositories.ThemeRepository;
import edu.iset.quizpro.Services.LevelService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelDao;
    private final ThemeRepository themeDao;

    @Autowired
    public LevelServiceImpl(LevelRepository levelDao, ThemeRepository themeDao) {
        this.levelDao = levelDao;
        this.themeDao = themeDao;
    }

    @Override
    public Level addLevel(Level level, Theme theme) {
        theme.getLevels().add(level); // Assuming a One-to-Many relationship between Theme and Level
        level.setTheme(theme); // Assuming Level has a reference to Theme

        // Save the changes to the database
        themeDao.save(theme);
        levelDao.save(level);

        return level; // Return the added level
    }
    @Override
    @Transactional
    public void deleteLevel(Long id) {
        levelDao.deleteById(id);
    }
    


}
