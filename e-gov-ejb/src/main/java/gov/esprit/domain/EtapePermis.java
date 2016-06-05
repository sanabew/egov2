package gov.esprit.domain;

import javax.persistence.Embeddable;

@Embeddable
public class EtapePermis {

	private boolean photosPermis;
	private boolean examenPermis;
	private boolean impressionPermis;
	private boolean livraisonPermis;
	private boolean certifMedicalPermis;
	
	
	public EtapePermis() {
	}


	public boolean isPhotosPermis() {
		return photosPermis;
	}


	public void setPhotosPermis(boolean photosPermis) {
		this.photosPermis = photosPermis;
	}


	public boolean isExamenPermis() {
		return examenPermis;
	}


	public void setExamenPermis(boolean examenPermis) {
		this.examenPermis = examenPermis;
	}


	public boolean isImpressionPermis() {
		return impressionPermis;
	}


	public void setImpressionPermis(boolean impressionPermis) {
		this.impressionPermis = impressionPermis;
	}


	public boolean isLivraisonPermis() {
		return livraisonPermis;
	}


	public void setLivraisonPermis(boolean livraisonPermis) {
		this.livraisonPermis = livraisonPermis;
	}


	public boolean isCertifMedicalPermis() {
		return certifMedicalPermis;
	}


	public void setCertifMedicalPermis(boolean certifMedicalPermis) {
		this.certifMedicalPermis = certifMedicalPermis;
	}
	
}
