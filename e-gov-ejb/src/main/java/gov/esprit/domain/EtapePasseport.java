package gov.esprit.domain;

import javax.persistence.Embeddable;

@Embeddable
public class EtapePasseport {

	private boolean documentsPasseport;
	private boolean photosPasseport;
	private boolean empreintePasseport;
	private boolean impressionPasseport;
	private boolean livraisonPasseport;
	private boolean timbrePasseport;
	
	public EtapePasseport() {
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
