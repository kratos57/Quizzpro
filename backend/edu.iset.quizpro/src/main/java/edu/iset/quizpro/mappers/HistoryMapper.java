package edu.iset.quizpro.mappers;

import org.mapstruct.Mapper;

import edu.iset.quizpro.dto.HistoryDto;
import edu.iset.quizpro.entities.History;

@Mapper(componentModel = "spring")
public interface HistoryMapper {
    HistoryDto toDto(History history);
    History toEntity(HistoryDto historyDto);
    // Add other mappings here for History entity
}
