package edu.iset.quizpro.Services;



import edu.iset.quizpro.entities.History;

public interface HistoryService {
    History addHistory(History history);

    History editHistory(History history, History history1);
}
