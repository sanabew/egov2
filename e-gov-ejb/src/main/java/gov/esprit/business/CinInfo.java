package gov.esprit.business;

import java.time.LocalDateTime;

import gov.esprit.domain.Citoyen;
import gov.esprit.enums.Gouvernerat;

/*
 * @non-javadoc:
 * this class is not an entity.
 */
/**
 * {@link CinInfo}.
 * 
 * @category Business
 * @author monta
 *
 */
public class CinInfo {

	/**
	 * the 8 digits cin number.
	 */
	private Integer numero;
	
	/**
	 * the {@link Citoyen} cin owner.
	 */
	private Citoyen proprietaire;
	
	/**
	 * the cin creation date.
	 */
	private LocalDateTime dateExpedition;
	
	/**
	 * the cin location (can be different than Citoyen.address)
	 */
	private Gouvernerat gouvernerat;
	
	/**
	 * the cin digital identity identifier.
	 */
	private Integer referenceEmpreinte;
	
	/**
	 * @return the dateExpedition
	 */
	public LocalDateTime getDateExpedition() {
		return dateExpedition;
	}
	/**
	 * @param dateExpedition the dateExpedition to set
	 */
	public void setDateExpedition(LocalDateTime dateExpedition) {
		this.dateExpedition = dateExpedition;
	}
	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	/**
	 * @return the proprietaire
	 */
	public Citoyen getProprietaire() {
		return proprietaire;
	}
	/**
	 * @param proprietaire the proprietaire to set
	 */
	public void setProprietaire(Citoyen proprietaire) {
		this.proprietaire = proprietaire;
	}
	/**
	 * @return the gouvernerat
	 */
	public Gouvernerat getGouvernerat() {
		return gouvernerat;
	}
	/**
	 * @param gouvernerat the gouvernerat to set
	 */
	public void setGouvernerat(Gouvernerat gouvernerat) {
		this.gouvernerat = gouvernerat;
	}
	/**
	 * @return the referenceEmpreinte
	 */
	public Integer getReferenceEmpreinte() {
		return referenceEmpreinte;
	}
	/**
	 * @param referenceEmpreinte the referenceEmpreinte to set
	 */
	public void setReferenceEmpreinte(Integer referenceEmpreinte) {
		this.referenceEmpreinte = referenceEmpreinte;
	}

}
