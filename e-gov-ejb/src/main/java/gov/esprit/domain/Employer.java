package gov.esprit.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import gov.esprit.enums.Fonction;

/**
 * Entity implementation class for Entity: Employer
 *
 */
@Entity

public class Employer implements Serializable {

	   
	
	private int id;
	private String nom;
	private String prenom;
	private Fonction fonction;
	public Employer(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	private String login;
	private String motDePasse;
	private static final long serialVersionUID = 1L;

	public Employer() {
		super();
	}  
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   
	@Enumerated(EnumType.STRING)
	public Fonction getFonction() {
		return this.fonction;
	}
	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
   
}
