package gov.esprit.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EtapePasseport implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3485164665950564169L;
	private Boolean documentsPasseport;
	private Boolean photosPasseport;
	private Boolean empreintePasseport;
	private Boolean impressionPasseport;
	private Boolean livraisonPasseport;
	private Boolean timbrePasseport;
	
	public EtapePasseport() {
	}
	
	public Boolean isDocumentsPasseport() {
		return documentsPasseport;
	}
	public void setDocumentsPasseport(Boolean documentsPasseport) {
		this.documentsPasseport = documentsPasseport;
	}
	public Boolean isPhotosPasseport() {
		return photosPasseport;
	}
	public void setPhotosPasseport(Boolean photosPasseport) {
		this.photosPasseport = photosPasseport;
	}
	public Boolean isEmpreintePasseport() {
		return empreintePasseport;
	}
	public void setEmpreintePasseport(Boolean empreintePasseport) {
		this.empreintePasseport = empreintePasseport;
	}
	public Boolean isImpressionPasseport() {
		return impressionPasseport;
	}
	public void setImpressionPasseport(Boolean impressionPasseport) {
		this.impressionPasseport = impressionPasseport;
	}
	public Boolean isLivraisonPasseport() {
		return livraisonPasseport;
	}
	public void setLivraisonPasseport(Boolean livraisonPasseport) {
		this.livraisonPasseport = livraisonPasseport;
	}
	public Boolean isTimbrePasseport() {
		return timbrePasseport;
	}
	public void setTimbrePasseport(Boolean timbrePasseport) {
		this.timbrePasseport = timbrePasseport;
	}
	
	
}
