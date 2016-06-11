package gov.esprit.service.cin;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import gov.esprit.business.CinInfo;
import gov.esprit.business.TraiterDemandeInfo;
import gov.esprit.domain.Demande;
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
	 * @param nom
	 * @param prenom
	 * @param date
	 * @param isInscrit
	 * @param isExtrait
	 * @param isResidenceProof
	 * @param gouvernerat
	 * 
	 * @throws EgovException
	 */
	public void ajouter(String nom, String prenom, boolean isInscrit, boolean isExtrait, boolean isResidenceProof, boolean isTravailProof, Gouvernerat gouvernerat, Date date)
			throws EgovException;
	/**
	 * Traiter une demande d'obtention d'une cin.
	 * 
	 * @param demande
	 * @param cinInfo
	 * @return
	 * @throws EgovException
	 */
	public CinInfo traiter(TraiterDemandeInfo info) throws EgovException;
	
	/**
	 * @return
	 */
	public List<Demande> findAll();

}
