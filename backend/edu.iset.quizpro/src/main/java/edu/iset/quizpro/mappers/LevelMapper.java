package edu.iset.quizpro.mappers;

import org.mapstruct.Mapper;

import edu.iset.quizpro.dto.LevelDto;
import edu.iset.quizpro.entities.Level;

@Mapper(componentModel = "spring")
public interface LevelMapper {
    LevelDto toDto(Level level);
    Level toEntity(LevelDto levelDto);
    // Add other mappings here for Level entity
}
