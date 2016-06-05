package gov.esprit.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

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
	private Date dateAttribution;
	private Date dateExpiration;
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
	public Date getDateAttribution() {
		return this.dateAttribution;
	}

	public void setDateAttribution(Date dateAttribution) {
		this.dateAttribution = dateAttribution;
	}   
	public Date getDateExpiration() {
		return this.dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
   
}
