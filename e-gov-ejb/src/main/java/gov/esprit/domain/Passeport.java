package gov.esprit.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


/**
 * Entity implementation class for Entity: Passport
 *
 */
@Entity

public class Passeport implements Serializable {

	   
	
	private int id;
	private Citoyen citoyen;
	private LocalDateTime dateAttribution;
	private LocalDateTime dateExpiration;
	private static final long serialVersionUID = 1L;

	public Passeport() {
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
	@OneToOne
	public Citoyen getCitoyen() {
		return this.citoyen;
	}

	public void setCitoyen(Citoyen citoyen) {
		this.citoyen = citoyen;
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
   
}
