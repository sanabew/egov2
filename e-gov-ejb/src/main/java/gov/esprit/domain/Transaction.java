package gov.esprit.domain;

import gov.esprit.domain.TypeTransacrion;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Transaction
 *
 */
@Entity

public class Transaction implements Serializable {

	   
	
	private int id;
	private LocalDate date;
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
	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
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
