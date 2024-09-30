package edu.iset.quizpro.Services;


import java.util.List;

import org.springframework.stereotype.Service;

import edu.iset.quizpro.entities.Theme;



@Service
public interface ThemeService {

	 Theme addTheme(Theme theme);
	    void deleteTheme(Long id);
 // Add this method declaration


}
