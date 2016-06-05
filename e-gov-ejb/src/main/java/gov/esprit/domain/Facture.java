package gov.esprit.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import gov.esprit.enums.EtatFacture;
import gov.esprit.enums.TypeFacture;


/**
 * Entity implementation class for Entity: Facture
 *
 */
@Entity

public class Facture implements Serializable {

	   
	
	private int id;
	private int num;
	private Date date;
	private int montant;
	private EtatFacture etat;
	private TypeFacture type;
	private Citoyen citoyen;
	
	private static final long serialVersionUID = 1L;

	public Facture() {
		super();
	}  
	
	public Facture(int num, Date date, int montant, EtatFacture etat, TypeFacture type) {
		super();
		this.num = num;
		this.date = date;
		this.montant = montant;
		this.etat = etat;
		this.type = type;
	}
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public EtatFacture getEtat() {
		return etat;
	}
	public void setEtat(EtatFacture etat) {
		this.etat = etat;
	}
	public TypeFacture getType() {
		return type;
	}
	public void setType(TypeFacture type) {
		this.type = type;
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
