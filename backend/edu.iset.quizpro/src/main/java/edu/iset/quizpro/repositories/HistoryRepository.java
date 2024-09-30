package edu.iset.quizpro.repositories;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.iset.quizpro.entities.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
	History findBySore(int score);
	History findByUsername(String username);
}
