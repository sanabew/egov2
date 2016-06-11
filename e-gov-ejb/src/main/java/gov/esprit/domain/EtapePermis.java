package gov.esprit.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class EtapePermis  implements Serializable {

	private Boolean photosPermis;
	private Boolean examenPermis;
	private Boolean impressionPermis;
	private Boolean livraisonPermis;
	private Boolean certifMedicalPermis;
	private static final long serialVersionUID = 1L;
	
	
	public EtapePermis() {
		
	}
	
	public void initialize(){
		this.setCertifMedicalPermis(false);
		this.setExamenPermis(false);
		this.setImpressionPermis(false);
		this.setLivraisonPermis(false);
		this.setPhotosPermis(false);
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

	@Override
	public String toString() {
		return "EtapePermis [photosPermis=" + photosPermis + ", examenPermis=" + examenPermis + ", impressionPermis="
				+ impressionPermis + ", livraisonPermis=" + livraisonPermis + ", certifMedicalPermis="
				+ certifMedicalPermis + "]";
	}
	
	
	
}
