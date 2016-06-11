package gov.esprit.domain;

import java.io.Serializable;
import javax.persistence.*;

import gov.esprit.enums.TypeHoraire;
import gov.esprit.enums.TypeTrajet;

/**
 * Entity implementation class for Entity: AbonnementTransport
 *
 */
@Entity

public class AbonnementTransport implements Serializable {

	   
	
	private int id;
	private TypeTrajet trajet;
	private TypeHoraire horaire;
	private int prix;
	private static final long serialVersionUID = 1L;
	private Citoyen citoyen;
	
	public AbonnementTransport() {
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
	public TypeTrajet getTrajet() {
		return this.trajet;
	}

	public void setTrajet(TypeTrajet trajet) {
		this.trajet = trajet;
	}   
	public TypeHoraire getHoraire() {
		return this.horaire;
	}

	public void setHoraire(TypeHoraire horaire) {
		this.horaire = horaire;
	}   
	public int getPrix() {
		return this.prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	@ManyToOne
	@JoinColumn(name="citoyenId",referencedColumnName="id")
	public Citoyen getCitoyen() {
		return citoyen;
	}
	public void setCitoyen(Citoyen citoyen) {
		this.citoyen = citoyen;
	}
   
}
