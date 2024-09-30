package edu.iset.quizpro.Controllers;



import edu.iset.quizpro.dto.LevelDto;
import edu.iset.quizpro.manager.LevelManager;
import edu.iset.quizpro.entities.Level;
import edu.iset.quizpro.Services.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class LevelController {

    private LevelManager levelManager;

    @Autowired
    public LevelController(LevelManager levelManager) {
        this.levelManager = levelManager;
    }

    @PostMapping("/addLevel/{idTheme}")
    public LevelDto addLevel(@RequestBody LevelDto level, @PathVariable("idTheme") Long idTheme) {
        return levelManager.addLevel(level, idTheme);
    }

    @GetMapping("/getLevels/{idTheme}")
    public List<LevelDto> getLevels(@PathVariable("idTheme") Long idTheme) {
        return levelManager.getLevels(idTheme);
    }

    @GetMapping("/getLevel/{idTheme}")
    public LevelDto getLevel(@PathVariable("idTheme") Long idTheme) {
        return levelManager.getLevel(idTheme);
    }
    @DeleteMapping("/deleteLevel/{id}")
    public void deleteLevel(@PathVariable("id") Long id) {
        levelManager.deleteLevel(id);
    }
    
}
