package gov.esprit.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EtapePasseport implements Serializable {

	private boolean documentsPasseport;
	private boolean photosPasseport;
	private boolean empreintePasseport;
	private boolean impressionPasseport;
	private boolean livraisonPasseport;
	private boolean timbrePasseport;
	private static final long serialVersionUID = 1L;
	public EtapePasseport() {
		
		
	}
	public void initialize(){
		this.setDocumentsPasseport(false);
		this.setEmpreintePasseport(false);
		this.setImpressionPasseport(false);
		this.setLivraisonPasseport(false);
		this.setPhotosPasseport(false);
		this.setTimbrePasseport(false);
	}
	public boolean isDocumentsPasseport() {
		return documentsPasseport;
	}
	public void setDocumentsPasseport(boolean documentsPasseport) {
		this.documentsPasseport = documentsPasseport;
	}
	public boolean isPhotosPasseport() {
		return photosPasseport;
	}
	public void setPhotosPasseport(boolean photosPasseport) {
		this.photosPasseport = photosPasseport;
	}
	public boolean isEmpreintePasseport() {
		return empreintePasseport;
	}
	public void setEmpreintePasseport(boolean empreintePasseport) {
		this.empreintePasseport = empreintePasseport;
	}
	public boolean isImpressionPasseport() {
		return impressionPasseport;
	}
	public void setImpressionPasseport(boolean impressionPasseport) {
		this.impressionPasseport = impressionPasseport;
	}
	public boolean isLivraisonPasseport() {
		return livraisonPasseport;
	}
	public void setLivraisonPasseport(boolean livraisonPasseport) {
		this.livraisonPasseport = livraisonPasseport;
	}
	public boolean isTimbrePasseport() {
		return timbrePasseport;
	}
	public void setTimbrePasseport(boolean timbrePasseport) {
		this.timbrePasseport = timbrePasseport;
	}
	
	
}
