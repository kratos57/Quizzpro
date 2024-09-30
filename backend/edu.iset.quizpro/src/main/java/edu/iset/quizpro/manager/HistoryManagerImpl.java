package edu.iset.quizpro.manager;

import edu.iset.quizpro.repositories.HistoryRepository;
import edu.iset.quizpro.dto.HistoryDto;
import edu.iset.quizpro.entities.History;
import edu.iset.quizpro.mappers.HistoryMapper;
import edu.iset.quizpro.Services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Transactional
@Service
public class HistoryManagerImpl implements HistoryManager {

    private final HistoryService historyService;
    private final HistoryRepository historyDao;
    private final HistoryMapper historyMapper;

    @Autowired
    public HistoryManagerImpl(HistoryService historyService, HistoryRepository historyDao, HistoryMapper historyMapper) {
        this.historyService = historyService;
        this.historyDao = historyDao;
        this.historyMapper = historyMapper;
    }

    @Override
    public HistoryDto addHistory(HistoryDto historyDto) {
        History history = historyMapper.toEntity(historyDto);
        return historyMapper.toDto(historyService.addHistory(history));
    }

    @Override
    public List<HistoryDto> getHistories() {
        List<History> histories = historyDao.findAll();
        histories.sort(Comparator.comparingLong(History::getSore).reversed());

        return histories.stream()
                .map(historyMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public HistoryDto findHistoryBySore(int score) {
        return historyMapper.toDto(historyDao.findBySore(score));
    }

    @Override
    public HistoryDto findHistoryByUsername(String username) {
        return historyMapper.toDto(historyDao.findByUsername(username));
    }

    @Override
    public HistoryDto editHistory(HistoryDto historyDto, String username) {
        History history = historyMapper.toEntity(historyDto);
        History existingHistory = historyDao.findByUsername(username);
        return historyMapper.toDto(historyService.editHistory(history, existingHistory));
    }
}

// Similar changes for other manager implementations (LevelManager, QuestionManager, ThemeManager)
