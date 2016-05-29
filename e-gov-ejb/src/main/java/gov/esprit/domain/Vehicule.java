package gov.esprit.domain;

import gov.esprit.domain.Citoyen;
import java.io.Serializable;
import java.lang.String;
import java.time.LocalDate;
import javax.persistence.*;

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
	private LocalDate dateMiseEnCirculation;
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
	public LocalDate getDateMiseEnCirculation() {
		return this.dateMiseEnCirculation;
	}

	public void setDateMiseEnCirculation(LocalDate dateMiseEnCirculation) {
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
