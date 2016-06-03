package gov.esprit.service.citoyen;

import javax.ejb.Local;

import gov.esprit.domain.Citoyen;
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
}
