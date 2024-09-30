package edu.iset.quizpro.manager;



import edu.iset.quizpro.dto.ThemeDto;


import java.util.List;

public interface ThemeManager {
    ThemeDto addTheme(ThemeDto themeDto);

    List<ThemeDto> getThemes();

    ThemeDto getTheme(Long idTheme);
    void deleteTheme(Long id);
}
