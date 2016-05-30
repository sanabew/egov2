package gov.esprit.service.cin;

import javax.ejb.Local;

import gov.esprit.business.CinInfo;
import gov.esprit.domain.Citoyen;
import gov.esprit.enums.Gouvernerat;
import gov.esprit.exception.EgovException;

/**
 * {@link DemandeCINServiceLocal} for local use.
 * 
 * @author monta
 */
@Local
@FunctionalInterface
public interface DemandeCINServiceLocal {

	/**
	 * Demander a avoir une cin.
	 * 
	 * @param citoyen
	 * @param isExtrait
	 * @param isResidanceProof
	 * @param gouvernerat
	 * @return {@link CinInfo}
	 * @throws EgovException 
	 */
	public CinInfo forCin(Citoyen citoyen, boolean isExtrait, boolean isResidanceProof, Gouvernerat gouvernerat) throws EgovException;
}
