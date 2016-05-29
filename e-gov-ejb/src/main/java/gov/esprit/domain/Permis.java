package gov.esprit.domain;

import gov.esprit.domain.Citoyen;
import gov.esprit.domain.TypePermis;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Permis
 *
 */
@Entity

public class Permis implements Serializable {

	   

	private int id;
	private TypePermis type;
	private LocalDate dateAttribution;
	private LocalDate dateExpiration;
	private Citoyen citoyen;
	private static final long serialVersionUID = 1L;

	public Permis() {
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
	public TypePermis getType() {
		return this.type;
	}

	public void setType(TypePermis type) {
		this.type = type;
	}   
	public LocalDate getDateAttribution() {
		return this.dateAttribution;
	}

	public void setDateAttribution(LocalDate dateAttribution) {
		this.dateAttribution = dateAttribution;
	}   
	public LocalDate getDateExpiration() {
		return this.dateExpiration;
	}

	public void setDateExpiration(LocalDate dateExpiration) {
		this.dateExpiration = dateExpiration;
	}   
	@ManyToOne
	@JoinColumn(name="citoyenId",referencedColumnName="id")
	public Citoyen getCitoyen() {
		return this.citoyen;
	}

	public void setCitoyen(Citoyen citoyen) {
		this.citoyen = citoyen;
	}
   
}
