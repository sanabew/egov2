package gov.esprit.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EtapeCin  implements Serializable {

	private Boolean documentsCin;
	private Boolean photosCin;
	private Boolean empreinteCin;
	private Boolean impressionCin;
	private Boolean livraisonCin;
	private static final long serialVersionUID = 1L;
	
	public EtapeCin() {
		
	}
	public void initialize(){
		this.setDocuments(false);
		this.setEmpreinte(false);
		this.setImpression(false);
		this.setLivraison(false);
		this.setPhotos(false);
	}
	public Boolean isDocuments() {
		return documentsCin;
	}
	public void setDocuments(Boolean documents) {
		this.documentsCin = documents;
	}
	public Boolean isPhotos() {
		return photosCin;
	}
	public void setPhotos(Boolean photos) {
		this.photosCin = photos;
	}
	public Boolean isEmpreinte() {
		return empreinteCin;
	}
	public void setEmpreinte(Boolean empreinte) {
		this.empreinteCin = empreinte;
	}
	public Boolean isImpression() {
		return impressionCin;
	}
	public void setImpression(Boolean impression) {
		this.impressionCin = impression;
	}
	public Boolean isLivraison() {
		return livraisonCin;
	}
	public void setLivraison(Boolean livraison) {
		this.livraisonCin = livraison;
	}
	
	
}
