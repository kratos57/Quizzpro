package edu.iset.quizpro.Controllers;

import edu.iset.quizpro.dto.QuestionDto;
import edu.iset.quizpro.manager.QuestionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {

    @Autowired
    private QuestionManager questionManager;

    @PostMapping("/addQuestion/{idLevel}")
    QuestionDto addQuestion(@RequestBody QuestionDto questionDto, @PathVariable("idLevel") Long idLevel) {
        return questionManager.addQuestion(questionDto, idLevel);
    }
    @GetMapping("/getQuestions/{idLevel}")
    List<QuestionDto> getQuestions(@PathVariable("idLevel") Long idLevel)  {
        return questionManager.getQuestions(idLevel);
    }
}
