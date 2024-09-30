package edu.iset.quizpro.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import edu.iset.quizpro.dto.QuestionDto;
import edu.iset.quizpro.entities.Question;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    QuestionDto toDto(Question question);
    Question toEntity(QuestionDto questionDto);
    List<QuestionDto> toDtoList(List<Question> questions);
}
