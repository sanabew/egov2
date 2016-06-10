package gov.esprit.service.permis;

import javax.ejb.Local;

import gov.esprit.business.TraiterDemandeInfo;
import gov.esprit.domain.Demande;
import gov.esprit.exception.EgovException;


@Local
public interface PermisServiceLocal {

	void demanderPermis(String cin) throws EgovException;

	void demanderRenouvPermis(String cin) throws EgovException;
	
	void attribuerPermis(int numdemande);
	void traiterDemandePermis(TraiterDemandeInfo info, int numero) ;
	Demande rechercherDemandePermis(int numero) throws EgovException;

}
