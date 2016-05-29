package gov.esprit.domain;

import gov.esprit.domain.Citoyen;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: SanctionPenale
 *
 */
@Entity

public class SanctionPenale implements Serializable {

	   
	private int id;
	private Citoyen citoyen;
	private LocalDate date;
	private int amende;
	private int dureePrison;
	private static final long serialVersionUID = 1L;

	public SanctionPenale() {
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
	@ManyToOne
	@JoinColumn(name="citoyenId",referencedColumnName="id", updatable = true, insertable = true)
	public Citoyen getCitoyen() {
		return this.citoyen;
	}

	public void setCitoyen(Citoyen citoyen) {
		this.citoyen = citoyen;
	}   
	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}   
	public int getAmende() {
		return this.amende;
	}

	public void setAmende(int amende) {
		this.amende = amende;
	}   
	public int getDureePrison() {
		return this.dureePrison;
	}

	public void setDureePrison(int dureePrison) {
		this.dureePrison = dureePrison;
	}
   
}
