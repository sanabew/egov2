package gov.esprit.domain;

import gov.esprit.domain.Citoyen;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ContratMariage
 *
 */
@Entity

public class ContratMariage implements Serializable {

	
	private int id;
	private LocalDate date;
	private Citoyen mari;
	private Citoyen mariee;
	private LocalDate dateDivorce;
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
	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
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
	public LocalDate getDateDivorce() {
		return dateDivorce;
	}
	public void setDateDivorce(LocalDate dateDivorce) {
		this.dateDivorce = dateDivorce;
	}
	
   
}
