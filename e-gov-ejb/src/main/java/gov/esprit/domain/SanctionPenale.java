package gov.esprit.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * Entity implementation class for Entity: SanctionPenale
 *
 */
@Entity

public class SanctionPenale implements Serializable {

	   
	private int id;
	private Citoyen citoyen;
	private Date date;
	private int amende;
	private int dureePrison;
	private String motif;
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
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
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
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	
	
   
}
