package edu.iset.quizpro.manager;

import edu.iset.quizpro.Services.ThemeService;

import edu.iset.quizpro.dto.ThemeDto;
import edu.iset.quizpro.entities.Theme;
import edu.iset.quizpro.mappers.ThemeMapper;
import edu.iset.quizpro.repositories.ThemeRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;




@Transactional
@Service
public class ThemeManagerImpl implements ThemeManager {

    private final ThemeMapper themeMapper;
    private final ThemeService themeService;
    private final ThemeRepository themeDao;

    @Autowired
    public ThemeManagerImpl(ThemeMapper themeMapper, ThemeService themeService, ThemeRepository themeDao) {
        this.themeMapper = themeMapper;
        this.themeService = themeService;
        this.themeDao = themeDao;
    }

    @Override
    public ThemeDto addTheme(ThemeDto themeDto) {
        Theme theme = themeMapper.toEntity(themeDto);
        return themeMapper.toDto(themeService.addTheme(theme));
    }

    @Override
    public List<ThemeDto> getThemes() {
        List<Theme> themes = themeDao.findAll();
        return themeMapper.toDtoList(themes);
    }

    @Override
    public ThemeDto getTheme(Long idTheme) {
        Theme theme = themeDao.getOne(idTheme);
        return themeMapper.toDto(theme);
    }
    
    @Override
    public void deleteTheme(Long id) {
        themeDao.deleteById(id);
    }
}
