package edu.ise.quizpro.impl;


import edu.iset.quizpro.Services.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import edu.iset.quizpro.entities.Level;
import edu.iset.quizpro.entities.Theme;
import edu.iset.quizpro.repositories.LevelRepository;
import edu.iset.quizpro.repositories.ThemeRepository;

@Component
@Transactional
public class LevelServiceImpl implements LevelService {
	
	@Autowired
	private LevelRepository levelDao;

	@Autowired
	private ThemeRepository themeDao;
	
  
	@Override
	public Level addLevel(Level level, Theme theme) {
		theme.addLevel(level);
		return levelDao.save(level);
	}
	@Override
    @Transactional
    public void deleteLevel(Long id) {
        levelDao.deleteById(id);
    }
}
