package edu.iset.quizpro.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iset.quizpro.entities.Utilisateur;
import edu.iset.quizpro.repositories.UtilisateurRepository;

@Service
public class UtilisateurServicempl implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur findUtilisateurById(Long id) {
        Optional<Utilisateur> utOptional = utilisateurRepository.findById(id);
        return utOptional.orElse(null);
    }

    @Override
    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("abdeliahmed204@gmail.com");
        message.setTo(utilisateur.getEmail());
        message.setText("Cher(e) " + utilisateur.getFirstName() +
                " Nous sommes ravis de vous accueillir au sein de notre communauté winshot \n "
                + " Votre inscription a été enregistrée avec succès et nous vous remercions de nous faire confiance\n"
                + "Attendre une réponse par email pour la validation");
        message.setSubject("Confirmation d'inscription");

        try {
            mailSender.send(message);
            System.out.println("Mail sent for registration");
        } catch (MailException e) {
            e.printStackTrace();
            // Handle exception
        }

        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

    @Override
    public List<Utilisateur> findByFirstName(String firstName) {
        return utilisateurRepository.findByFirstName(firstName);
    }

    @Override
    public Utilisateur getUserByMailAndPassword(String email, String password) {
        return utilisateurRepository.findByEmailAndPassword(email, password);
    }



    @Override
    public Utilisateur getUserByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    @Override
    public void updateUserPassword(Utilisateur utilisateur, String newPassword) {
        utilisateur.setPassword(newPassword);
        utilisateurRepository.save(utilisateur);
    }

    @Override
    public void invalidatePasswordResetToken(Utilisateur utilisateur) {
        utilisateur.setResetToken(null);
        utilisateurRepository.save(utilisateur);
    }

    @Override
    public boolean savePasswordResetToken(Utilisateur utilisateur, String token) {
        utilisateur.setResetToken(token);
        utilisateurRepository.save(utilisateur);
        return true;
    }

    @Override
    public String generateToken() {
        return UUID.randomUUID().toString();
    }

    @Override
    public boolean sendResetEmail(String userEmail, String resetLink) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(userEmail);
            message.setSubject("Password Reset");
            message.setText("Use the following link to reset your password: " + resetLink);
            mailSender.send(message);
            return true;
        } catch (MailException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Utilisateur getUserByPasswordResetToken(String token) {
        return utilisateurRepository.findByResetToken(token);
    }

	@Override
	public void sendSimpleEmail(String toEmail, String subject, String body) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur updateRoleAndSendEmail(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

    // Implement other methods as needed

}




