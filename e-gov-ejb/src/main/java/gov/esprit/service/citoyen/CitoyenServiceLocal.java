package gov.esprit.service.citoyen;

import java.util.Date;

import javax.ejb.Local;

import gov.esprit.domain.Citoyen;
import gov.esprit.enums.EtatDemande;
import gov.esprit.enums.Gouvernerat;
import gov.esprit.exception.EgovException;

/**
 * {@link CitoyenServiceLocal}.
 * 
 * @author Sbelwafi
 *
 */
@Local
public interface CitoyenServiceLocal {

	/**
	 * @param citoyen
	 */
	public void add(Citoyen citoyen);
	
	/**
	 * find the citoyen by its cin identifier.
	 * 
	 * @param cin
	 * @return {@link Citoyen}
	 * @throws EgovException 
	 */
	public Citoyen findByCin(String cin) throws EgovException;
	
	/**
	 * find the citoyeb By:
	 * 
	 * @param nom
	 * @param prenom
	 * @param date de naissance
	 * @param gouvernerat
	 * @return {@link Citoyen}
	 * @throws EgovException 
	 */
	public Citoyen findByNomAndPrenomAndDateAndGouvernerat(String nom, String prenom, Gouvernerat gouvernerat, Date date) throws EgovException;

	
}
