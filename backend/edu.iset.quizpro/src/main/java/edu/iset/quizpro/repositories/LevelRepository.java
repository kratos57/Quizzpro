package edu.iset.quizpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.iset.quizpro.entities.Level;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long>{

}
