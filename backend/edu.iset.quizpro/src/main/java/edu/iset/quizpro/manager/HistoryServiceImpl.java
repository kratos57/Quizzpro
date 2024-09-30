package edu.iset.quizpro.manager;



import edu.iset.quizpro.entities.History;
import edu.iset.quizpro.repositories.HistoryRepository;
import edu.iset.quizpro.Services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryRepository historyDao;

    @Override
    public History addHistory(History history) {
        return historyDao.save(history);
    }

    @Override
    public History editHistory(History history, History history1) {
       history.setUsername(history1.getUsername());
       history.setLevelName(history1.getLevelName());
       history.setThemeName(history1.getThemeName());
       history.setSore(history1.getSore());
       history.setTotal(history1.getTotal());
       return historyDao.save(history);
    }
}
