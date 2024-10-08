package edu.iset.quizpro.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class History {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	private String themeName;

	private String levelName;
	
	private int total;
	
	private int sore;

	public History() {
	}

	public History(String username, String themeName, String levelName, int total, int sore) {
		this.username = username;
		this.themeName = themeName;
		this.levelName = levelName;
		this.total = total;
		this.sore = sore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getSore() {
		return sore;
	}

	public void setSore(int sore) {
		this.sore = sore;
	}
}
