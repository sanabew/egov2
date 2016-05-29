package gov.esprit.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import gov.esprit.enums.TypeTransacrion;

/**
 * Entity implementation class for Entity: Transaction
 *
 */
@Entity

public class Transaction implements Serializable {

	   
	
	private int id;
	private LocalDateTime date;
	private TypeTransacrion type;
	private float montant;
	private Compte compte;
	private static final long serialVersionUID = 1L;

	public Transaction() {
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
	public LocalDateTime getDate() {
		return this.date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}   
	public TypeTransacrion getType() {
		return this.type;
	}

	public void setType(TypeTransacrion type) {
		this.type = type;
	}   
	public float getMontant() {
		return this.montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}
	@ManyToOne
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
   
}
