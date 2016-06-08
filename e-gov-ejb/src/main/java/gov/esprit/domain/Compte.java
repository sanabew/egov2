package gov.esprit.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Compte
 *
 */
@Entity

public class Compte implements Serializable {

	
	private int id;
	private Date dateOuverture;
	private Citoyen proprietaire;
	private float solde;
	private List<Transaction>transactions;
	private static final long serialVersionUID = 1L;

	public Compte() {
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
   
	public Date getDateOuverture() {
		return this.dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}  
	@ManyToOne
	@JoinColumn(name="citoyenId",referencedColumnName="id")
	public Citoyen getProprietaire() {
		return this.proprietaire;
	}

	public void setProprietaire(Citoyen proprietaire) {
		this.proprietaire = proprietaire;
	}   
	public float getSolde() {
		return this.solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}
	@OneToMany(mappedBy="compte")
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
   
}
