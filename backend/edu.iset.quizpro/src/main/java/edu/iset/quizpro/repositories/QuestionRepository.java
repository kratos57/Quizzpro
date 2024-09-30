package edu.iset.quizpro.repositories;


import org.springframework.data.jpa.repository.JpaRepository;


import edu.iset.quizpro.entities.Question;


public interface QuestionRepository extends JpaRepository<Question, Long> {

}