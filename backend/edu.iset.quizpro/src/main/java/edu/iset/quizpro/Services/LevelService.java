package edu.iset.quizpro.Services;



import edu.iset.quizpro.entities.Theme;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.iset.quizpro.entities.Level;

@Service
public interface LevelService {
	
	Level addLevel(Level level, Theme theme);
    void deleteLevel(Long id);
}
