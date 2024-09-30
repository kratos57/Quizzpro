package edu.ise.quizpro.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.iset.quizpro.entities.Theme;
import edu.iset.quizpro.repositories.ThemeRepository;
import edu.iset.quizpro.Services.ThemeService;



@Component
@Transactional
public class ThemeServiceImpl implements ThemeService {
	
	@Autowired
	private ThemeRepository themeDao;

	@Override
	public Theme addTheme(Theme theme) {
		return themeDao.save(theme);
	}
	 @Override
	    @Transactional
	    public void deleteTheme(Long id) {
	        themeDao.deleteById(id);
	    }


}
