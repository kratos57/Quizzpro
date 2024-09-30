package edu.iset.quizpro.Controllers;



import edu.iset.quizpro.dto.HistoryDto;
import edu.iset.quizpro.manager.HistoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class HistoryController {

    @Autowired
    private HistoryManager historyManager;

    @PostMapping("/addHistory")
    HistoryDto addHistory(@RequestBody HistoryDto historyDto) {
        return historyManager.addHistory(historyDto);
    }
    @PutMapping("/editHistory/{username}")
    HistoryDto editHistory(@RequestBody HistoryDto historyDto, @PathVariable("username") String username) {
        return historyManager.editHistory(historyDto, username);
    }
    @GetMapping("/getHistories")
    List<HistoryDto> getHistories() {
        return historyManager.getHistories();
    }
    @GetMapping("/findHistoryBySore/{score}")
    HistoryDto findHistoryBySore(@PathVariable("score") int score) {
        return historyManager.findHistoryBySore(score);
    }
    @GetMapping("/findHistoryByUsername/{username}")
    HistoryDto findHistoryByUsername(@PathVariable("username") String username) {
        return historyManager.findHistoryByUsername(username);
    }
}
