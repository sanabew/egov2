package gov.esprit.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EtapeCin implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Boolean documentsCin;
	private Boolean photosCin;
	private Boolean empreinteCin;
	private Boolean impressionCin;
	private Boolean livraisonCin;
	
	public EtapeCin() {
	}

	/**
	 * @return the documentsCin
	 */
	public Boolean isDocumentsCin() {
		return documentsCin;
	}

	/**
	 * @param documentsCin the documentsCin to set
	 */
	public void setDocumentsCin(Boolean documentsCin) {
		this.documentsCin = documentsCin;
	}

	/**
	 * @return the photosCin
	 */
	public Boolean isPhotosCin() {
		return photosCin;
	}

	/**
	 * @param photosCin the photosCin to set
	 */
	public void setPhotosCin(Boolean photosCin) {
		this.photosCin = photosCin;
	}

	/**
	 * @return the empreinteCin
	 */
	public Boolean isEmpreinteCin() {
		return empreinteCin;
	}

	/**
	 * @param empreinteCin the empreinteCin to set
	 */
	public void setEmpreinteCin(Boolean empreinteCin) {
		this.empreinteCin = empreinteCin;
	}

	/**
	 * @return the impressionCin
	 */
	public Boolean isImpressionCin() {
		return impressionCin;
	}

	/**
	 * @param impressionCin the impressionCin to set
	 */
	public void setImpressionCin(Boolean impressionCin) {
		this.impressionCin = impressionCin;
	}

	/**
	 * @return the livraisonCin
	 */
	public Boolean isLivraisonCin() {
		return livraisonCin;
	}

	/**
	 * @param livraisonCin the livraisonCin to set
	 */
	public void setLivraisonCin(Boolean livraisonCin) {
		this.livraisonCin = livraisonCin;
	}
	
	
	
	
}
