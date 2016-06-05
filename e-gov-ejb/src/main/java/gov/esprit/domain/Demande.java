package gov.esprit.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import gov.esprit.enums.EtatDemande;
import gov.esprit.enums.TypeDemande;
import gov.esprit.enums.TypePermis;

/**
 * Entity implementation class for Entity: Demande
 *
 */
@Entity

public class Demande implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private TypeDemande type;
	private EtatDemande etat;
	private Date date;
	private Citoyen citoyen;
	private EtapeCin etapeCin;
	private EtapePasseport etapePasseport;
	private EtapePermis	etapePermis;
	
	
	public Demande() {
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
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
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
	@Embedded
	public EtapeCin getEtapeCin() {
		return etapeCin;
	}

	public void setEtapeCin(EtapeCin etapeCin) {
		this.etapeCin = etapeCin;
	}
	
	@Embedded
	public EtapePasseport getEtapePasseport() {
		return etapePasseport;
	}

	public void setEtapePasseport(EtapePasseport etapePasseport) {
		this.etapePasseport = etapePasseport;
	}

	@Embedded
	public EtapePermis getEtapePermis() {
		return etapePermis;
	}

	public void setEtapePermis(EtapePermis etapePermis) {
		this.etapePermis = etapePermis;
	}

	
	
   
}
