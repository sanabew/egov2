package gov.esprit.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EtapePermis implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5827515817889298484L;
	private Boolean photosPermis;
	private Boolean examenPermis;
	private Boolean impressionPermis;
	private Boolean livraisonPermis;
	private Boolean certifMedicalPermis;
	
	
	public EtapePermis() {
	}


	public Boolean isPhotosPermis() {
		return photosPermis;
	}


	public void setPhotosPermis(Boolean photosPermis) {
		this.photosPermis = photosPermis;
	}


	public Boolean isExamenPermis() {
		return examenPermis;
	}


	public void setExamenPermis(Boolean examenPermis) {
		this.examenPermis = examenPermis;
	}


	public Boolean isImpressionPermis() {
		return impressionPermis;
	}


	public void setImpressionPermis(Boolean impressionPermis) {
		this.impressionPermis = impressionPermis;
	}


	public Boolean isLivraisonPermis() {
		return livraisonPermis;
	}


	public void setLivraisonPermis(Boolean livraisonPermis) {
		this.livraisonPermis = livraisonPermis;
	}


	public Boolean isCertifMedicalPermis() {
		return certifMedicalPermis;
	}


	public void setCertifMedicalPermis(Boolean certifMedicalPermis) {
		this.certifMedicalPermis = certifMedicalPermis;
	}
	
}
