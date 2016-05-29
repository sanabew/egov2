package gov.esprit.domain;

import gov.esprit.domain.Citoyen;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Passport
 *
 */
@Entity

public class Passeport implements Serializable {

	   
	
	private int id;
	private Citoyen citoyen;
	private LocalDate dateAttribution;
	private LocalDate dateExpiration;
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
   
}
