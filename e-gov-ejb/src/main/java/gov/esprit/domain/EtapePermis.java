package gov.esprit.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class EtapePermis  implements Serializable {

	private boolean photosPermis;
	private boolean examenPermis;
	private boolean impressionPermis;
	private boolean livraisonPermis;
	private boolean certifMedicalPermis;
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

	@Override
	public String toString() {
		return "EtapePermis [photosPermis=" + photosPermis + ", examenPermis=" + examenPermis + ", impressionPermis="
				+ impressionPermis + ", livraisonPermis=" + livraisonPermis + ", certifMedicalPermis="
				+ certifMedicalPermis + "]";
	}
	
	
	
}
