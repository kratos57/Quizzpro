package edu.iset.quizpro.manager;


import edu.iset.quizpro.Services.ThemeService;
import edu.iset.quizpro.entities.Theme;
import edu.iset.quizpro.repositories.ThemeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ThemeServiceImpl implements ThemeService {

    private final ThemeRepository themeDao;

    @Autowired
    public ThemeServiceImpl(ThemeRepository themeDao) {
        this.themeDao = themeDao;
    }

    @Override
    @Transactional
    public Theme addTheme(Theme theme) {
        // Your logic to add a theme
        if (theme.getName() == null || theme.getName().isEmpty()) {
            throw new IllegalArgumentException("Theme name cannot be empty");
        }
        
        // Example additional validation
        // Ensure that the theme doesn't exist already
        if (themeDao.existsByName(theme.getName())) {
            throw new IllegalArgumentException("Theme with this name already exists");
        }

        // Save the theme to the database using themeDao
        return themeDao.save(theme);
    }
    @Override
    @Transactional
    public void deleteTheme(Long id) {
        themeDao.deleteById(id);
    }

}
