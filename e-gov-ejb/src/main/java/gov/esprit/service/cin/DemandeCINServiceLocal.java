package gov.esprit.service.cin;

import javax.ejb.Local;

import gov.esprit.business.CinInfo;
import gov.esprit.domain.Citoyen;
import gov.esprit.domain.Demande;
import gov.esprit.enums.EtatDemande;
import gov.esprit.enums.Gouvernerat;
import gov.esprit.exception.EgovException;

/**
 * {@link DemandeCINServiceLocal} for local use.
 * 
 * @author monta
 */
@Local
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
	public void ajouter(Citoyen citoyen, boolean isExtrait, boolean isResidanceProof, Gouvernerat gouvernerat) throws EgovException;

	/**
	 * Traiter une demande d'obtention d'une cin.
	 * 
	 * @param demande
	 * @param cinInfo
	 * @return
	 * @throws EgovException
	 */
	public void traiter(Demande demande) throws EgovException;
	
	/**
	 * @param demande
	 * @return
	 * @throws EgovException
	 */
	public CinInfo delivrer(Demande demande) throws EgovException;
	
	/**
	 * @param demande
	 * @return
	 * @throws EgovException
	 */
	public EtatDemande getEtat(Demande demande) throws EgovException;
	/**
	 * 
	 * @param Citoyen
	 * @return
	 * @throws EgovException
	 */
	public CinInfo findCitoyenByCIN(Citoyen Citoyen)throws EgovException;
}
