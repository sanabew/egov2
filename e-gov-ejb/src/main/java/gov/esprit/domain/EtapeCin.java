package gov.esprit.domain;

import javax.persistence.Embeddable;

@Embeddable
public class EtapeCin {

	private boolean documentsCin;
	private boolean photosCin;
	private boolean empreinteCin;
	private boolean impressionCin;
	private boolean livraisonCin;
	
	public EtapeCin() {
	}
	
	public boolean isDocuments() {
		return documentsCin;
	}
	public void setDocuments(boolean documents) {
		this.documentsCin = documents;
	}
	public boolean isPhotos() {
		return photosCin;
	}
	public void setPhotos(boolean photos) {
		this.photosCin = photos;
	}
	public boolean isEmpreinte() {
		return empreinteCin;
	}
	public void setEmpreinte(boolean empreinte) {
		this.empreinteCin = empreinte;
	}
	public boolean isImpression() {
		return impressionCin;
	}
	public void setImpression(boolean impression) {
		this.impressionCin = impression;
	}
	public boolean isLivraison() {
		return livraisonCin;
	}
	public void setLivraison(boolean livraison) {
		this.livraisonCin = livraison;
	}
	
	
}
