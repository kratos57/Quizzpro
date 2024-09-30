package edu.iset.quizpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.iset.quizpro.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}

