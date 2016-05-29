package gov.esprit.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.joda.time.LocalDateTime;

import gov.esprit.enums.TypePermis;

/**
 * Entity implementation class for Entity: Permis
 *
 */
@Entity

public class Permis implements Serializable {

	   

	private int id;
	private TypePermis type;
	private LocalDateTime dateAttribution;
	private LocalDateTime dateExpiration;
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
	public LocalDateTime getDateAttribution() {
		return this.dateAttribution;
	}

	public void setDateAttribution(LocalDateTime dateAttribution) {
		this.dateAttribution = dateAttribution;
	}   
	public LocalDateTime getDateExpiration() {
		return this.dateExpiration;
	}

	public void setDateExpiration(LocalDateTime dateExpiration) {
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
