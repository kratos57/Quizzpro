package edu.iset.quizpro.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import edu.iset.quizpro.dto.ThemeDto;
import edu.iset.quizpro.entities.Theme;

@Mapper(componentModel = "spring")
public interface ThemeMapper {
    ThemeDto toDto(Theme theme);
    Theme toEntity(ThemeDto themeDto);
    List<ThemeDto> toDtoList(List<Theme> themes);
}
