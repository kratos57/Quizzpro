package edu.iset.quizpro.Services;

import java.util.List;
import edu.iset.quizpro.entities.Utilisateur;

public interface UtilisateurService {
    // Basic CRUD methods
    List<Utilisateur> getAllUtilisateurs();

    Utilisateur findUtilisateurById(Long id);

    Utilisateur createUtilisateur(Utilisateur utilisateur);

    Utilisateur updateUtilisateur(Utilisateur utilisateur);

    void deleteUtilisateur(Long id);

    Utilisateur getUserByMailAndPassword(String email, String password);

    List<Utilisateur> findByFirstName(String firstName);

    Utilisateur getUserByEmail(String email);

    void updateUserPassword(Utilisateur utilisateur, String newPassword);

    void invalidatePasswordResetToken(Utilisateur utilisateur);

    boolean savePasswordResetToken(Utilisateur utilisateur, String token);

    String generateToken();

    boolean sendResetEmail(String userEmail, String token);

    Utilisateur getUserByPasswordResetToken(String token);

    // Additional method from the second version
    void sendSimpleEmail(String toEmail, String subject, String body);

    // Additional method from the second version
    Utilisateur updateRoleAndSendEmail(Utilisateur utilisateur);
}
