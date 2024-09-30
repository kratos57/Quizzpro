package edu.iset.quizpro.repositories;


import org.springframework.stereotype.Repository;

import edu.iset.quizpro.entities.Utilisateur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

public List<Utilisateur> findByFirstName(String firstName);

public Utilisateur findByEmailAndPassword(String email, String matricule);
Utilisateur findByEmail(String email);

	

Utilisateur findByResetToken(String resetToken);
}
