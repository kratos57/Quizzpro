package edu.iset.quizpro.Controllers;



import edu.iset.quizpro.dto.ThemeDto;
import edu.iset.quizpro.manager.ThemeManager;
import edu.iset.quizpro.entities.Theme;
import edu.iset.quizpro.Services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ThemeController {

    @Autowired
    private ThemeManager themeManager;

    @PostMapping("/addTheme")
    public ThemeDto addTheme(@RequestBody ThemeDto theme) {
        return themeManager.addTheme(theme);
    }

    @GetMapping("/getThemes")
    public List<ThemeDto> getThemes() {
        return themeManager.getThemes();
    }
    @GetMapping("/getTheme/{idTheme}")
    public ThemeDto getTheme(@PathVariable("idTheme") Long idTheme) {
        return themeManager.getTheme(idTheme);
    }
    @DeleteMapping("/deleteTheme/{id}")
    public void deleteTheme(@PathVariable("id") Long id) {
        themeManager.deleteTheme(id);
    }
}
