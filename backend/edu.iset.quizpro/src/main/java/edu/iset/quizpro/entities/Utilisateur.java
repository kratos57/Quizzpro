package edu.iset.quizpro.entities;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Utilisateur implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
@Column(name="first_name")
     private String firstName;
     private String lastName;
     private String email;
     private String password;
     @JsonFormat(pattern = "yyyy-MM-dd")
     private Date starterDate;
     private int age;
     private double score;
     private Boolean active;

     private String resetToken;

     private String roll;
     
    public Utilisateur(){
    	
    }
    

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }
     
public double getScore() {
return score;
}
public void setScore(double score) {
this.score = score;
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}

public String getFirstName() {
return firstName;
}
public void setFirstName(String firstName) {
this.firstName = firstName;
}
public String getLastName() {
return lastName;
}
public void setLastName(String lastName) {
this.lastName = lastName;
}
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}
public Date getStarterDate() {
return starterDate;
}
public void setStarterDate(Date starterDate) {
this.starterDate = starterDate;
}
public int getAge() {
return age;
}

public void setAge(int age) {
this.age = age;
}
public Boolean getActive() {
return active;
}
public void setActive(Boolean active) {
this.active = active;
}


public String getRoll() {
	return roll;
}


public void setRoll(String roll) {
	this.roll = roll;
}


     
}

