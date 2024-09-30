package edu.iset.quizpro.Controllers;

import java.util.List;
import java.util.Map;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import edu.iset.quizpro.entities.Utilisateur;
import edu.iset.quizpro.repositories.UtilisateurRepository;

import edu.iset.quizpro.Services.UtilisateurService;

@RestController
@RequestMapping("/utilisateur") // localhost:8080/utilisateur
@CrossOrigin(origins = "8080")
public class UtilisateurController {
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private UtilisateurRepository utilisateurRepository;


@Autowired
private JavaMailSender mailSender;

@GetMapping
@CrossOrigin(origins = "http://localhost:4200")
public List<Utilisateur> getAllUtilisateur()
{
return utilisateurService.getAllUtilisateurs();
}

	@GetMapping("/forgotpassword")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> forgetPassword(@RequestParam String email) {
		System.out.println("Received forget password request for email: " + email);
		Utilisateur user = utilisateurService.getUserByEmail(email);

		System.out.print(user);
		if (user == null) {
			System.out.println("User not found");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		String token = utilisateurService.generateToken();
		user.setResetToken(token);
		utilisateurRepository.save(user);

		String resetLink = "http://localhost:4200/resetpassword?token=" + token;
		boolean emailSent = utilisateurService.sendResetEmail(email, resetLink);
		if (emailSent) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/resetpassword/{token}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> resetPassword(@PathVariable String token, @RequestBody Map<String, String> payload) {
	    String newPassword = payload.get("newPassword");

	    Utilisateur user = utilisateurRepository.findByResetToken(token);
	    if (user == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    user.setPassword(newPassword);
	    utilisateurRepository.save(user);

	    return new ResponseEntity<>(HttpStatus.OK);
	}
	

	@GetMapping(path = "/findByFirstName/{firstName}") // localhost:8080/utilisateur/findByFirstName/eya
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Utilisateur>> findUtilisateurByFirstName(@PathVariable String firstName) {
		List<Utilisateur> utilisateurs = utilisateurService.findByFirstName(firstName);
		if (utilisateurs == null) {
			return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Utilisateur>>(utilisateurs, HttpStatus.OK);
		}
	}

	@GetMapping(path = "/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Utilisateur> findUtilisateurById(@PathVariable Long id) {
		Utilisateur utilisateur = utilisateurService.findUtilisateurById(id);
		if (utilisateur == null) {
			return new ResponseEntity<Utilisateur>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
		}
	}



@PostMapping
@CrossOrigin(origins = "http://localhost:4200")
public ResponseEntity<Utilisateur> createUtilisateur(@RequestBody Utilisateur utilisateur) {
   Utilisateur createdUtilisateur = utilisateurService.createUtilisateur(utilisateur);
   return new ResponseEntity<>(createdUtilisateur, HttpStatus.CREATED);
}


@PostMapping("/updateRoleAndSendEmail")
@CrossOrigin(origins = "http://localhost:4200")
public ResponseEntity<Utilisateur> updateRoleAndSendEmail(@RequestBody Utilisateur utilisateur) {
    Optional<Utilisateur> utOptional = utilisateurRepository.findById(utilisateur.getId());

    if (utOptional.isPresent()) {
        Utilisateur existingUser = utOptional.get();

        // Update the role
        existingUser.setRoll(utilisateur.getRoll());

        // Save the updated user
        Utilisateur updatedUser = utilisateurRepository.save(existingUser);

        // Send email
        sendRoleUpdateEmail(updatedUser);

        return ResponseEntity.ok(updatedUser);
    }

    return null;
}
private void sendRoleUpdateEmail(Utilisateur utilisateur) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("abdeliahmed204@gmail.com");
    message.setTo(utilisateur.getEmail());
    message.setText("Cher(e) "+utilisateur.getFirstName()+" "+utilisateur.getLastName()+
    		"\n Nous espérons que ce message vous trouve bien. Nous sommes ravis de vous compter parmi nos utilisateurs,\n "
    		+ "et nous voulions vous fournir des instructions simples pour accéder à notre site."
    		+ "\n Rendez-vous sur notre site : http://localhost:4200/authentification"
    		+ "\n Email :"+utilisateur.getEmail()+
    		"\n Mot de passe "+utilisateur.getPassword()+
    		"\n Nous sommes impatients de vous voir profiter pleinement de notre site. \n"
    		+ "Merci de faire partie de notre communauté !\n"
    		+ "Cordialement,"

    		);
    message.setSubject(" Instructions d'Accès au Site");
    
    mailSender.send(message);

    System.out.println("Mail Sent validation");
}

@PutMapping("/{id}")
@CrossOrigin(origins = "http://localhost:4200")
public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
	 Utilisateur updateUtilisateur = utilisateurService.updateUtilisateur(utilisateur);
    return new ResponseEntity<>(utilisateur, HttpStatus.OK);
}





@DeleteMapping(path="/{id}")
@CrossOrigin(origins = "http://localhost:4200")
public void deleteUtilisateur(@PathVariable Long id) //localhost:8080/utilisateur/3
{
 utilisateurService.deleteUtilisateur(id);
}

@GetMapping("/{mail}/{password}")
@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Utilisateur> getUserByMailAndPassword(@PathVariable String mail,
			@PathVariable String password) {

		Utilisateur user = utilisateurService.getUserByMailAndPassword(mail, password);

		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


}
