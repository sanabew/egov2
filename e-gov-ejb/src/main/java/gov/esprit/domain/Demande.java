package gov.esprit.domain;

import gov.esprit.domain.TypeDemande;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Demande
 *
 */
@Entity

public class Demande implements Serializable {

	   
	
	private int id;
	private TypeDemande type;
	private EtatDemande etat;
	private LocalDate date;
	private Citoyen citoyen;
	private static final long serialVersionUID = 1L;

	public Demande() {
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
	public TypeDemande getType() {
		return this.type;
	}

	public void setType(TypeDemande type) {
		this.type = type;
	}   
	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	@ManyToOne
	@JoinColumn(name="citoyenId",referencedColumnName="id")
	public Citoyen getCitoyen() {
		return citoyen;
	}
	public void setCitoyen(Citoyen citoyen) {
		this.citoyen = citoyen;
	}
	public EtatDemande getEtat() {
		return etat;
	}
	public void setEtat(EtatDemande etat) {
		this.etat = etat;
	}
	
	
   
}
