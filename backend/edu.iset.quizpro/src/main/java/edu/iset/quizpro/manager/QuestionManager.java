package edu.iset.quizpro.manager;



import edu.iset.quizpro.dto.QuestionDto;
import java.util.List;

	public interface QuestionManager {

	     QuestionDto addQuestion(QuestionDto questionDto, Long idLevel);

	     List<QuestionDto> getQuestions(Long idLevel);
	}
