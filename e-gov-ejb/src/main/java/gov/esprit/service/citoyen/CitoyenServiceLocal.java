package gov.esprit.service.citoyen;

import java.util.Date;

import javax.ejb.Local;

import gov.esprit.domain.Citoyen;
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
	public Citoyen findByNomAndPrenomAndDateAndGouvernerat(String nom, String prenom, Date date, Gouvernerat gouvernerat) throws EgovException;
	void addCitoyen(Citoyen c);
	
}
