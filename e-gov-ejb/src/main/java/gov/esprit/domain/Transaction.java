package gov.esprit.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import gov.esprit.enums.TypeTransacrion;

/**
 * Entity implementation class for Entity: Transaction
 *
 */
@Entity

public class Transaction implements Serializable {

	   
	
	private int id;
	private Date date;
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
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
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
	@JoinColumn(name="compteId",referencedColumnName="id")
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
   
}
