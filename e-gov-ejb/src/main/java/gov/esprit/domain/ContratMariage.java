package gov.esprit.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.joda.time.LocalDateTime;

/**
 * Entity implementation class for Entity: ContratMariage
 *
 */
@Entity

public class ContratMariage implements Serializable {

	
	private int id;
	private LocalDateTime date;
	private Citoyen mari;
	private Citoyen mariee;
	private LocalDateTime dateDivorce;
	private static final long serialVersionUID = 1L;

	public ContratMariage() {
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
	public LocalDateTime getDate() {
		return this.date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}  
	@OneToOne
	public Citoyen getMari() {
		return this.mari;
	}
	
	public void setMari(Citoyen mari) {
		this.mari = mari;
	}   
	@OneToOne
	public Citoyen getMariee() {
		return this.mariee;
	}

	public void setMariee(Citoyen mariee) {
		this.mariee = mariee;
	}
	public LocalDateTime getDateDivorce() {
		return dateDivorce;
	}
	public void setDateDivorce(LocalDateTime dateDivorce) {
		this.dateDivorce = dateDivorce;
	}
	
   
}
