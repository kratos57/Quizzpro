package edu.iset.quizpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.iset.quizpro.entities.Theme;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {
	boolean existsByName(String name);
}
