package gov.esprit.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.joda.time.LocalDateTime;

/**
 * Entity implementation class for Entity: Vehicule
 *
 */
@Entity

public class Vehicule implements Serializable {

	   
	
	private int id;
	private String matricule;
	private String marque;
	private String modele;
	private String carteGrise;
	private LocalDateTime dateMiseEnCirculation;
	private Citoyen proprietaire;
	private static final long serialVersionUID = 1L;

	public Vehicule() {
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
	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}   
	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}   
	public String getModele() {
		return this.modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}   
	public String getCarteGrise() {
		return this.carteGrise;
	}

	public void setCarteGrise(String carteGrise) {
		this.carteGrise = carteGrise;
	}   
	public LocalDateTime getDateMiseEnCirculation() {
		return this.dateMiseEnCirculation;
	}

	public void setDateMiseEnCirculation(LocalDateTime dateMiseEnCirculation) {
		this.dateMiseEnCirculation = dateMiseEnCirculation;
	}   
	
	@ManyToOne
	@JoinColumn(name="citoyenId",referencedColumnName="id")
	public Citoyen getProprietaire() {
		return this.proprietaire;
	}

	public void setProprietaire(Citoyen propriaitaire) {
		this.proprietaire = propriaitaire;
	}
   
}
