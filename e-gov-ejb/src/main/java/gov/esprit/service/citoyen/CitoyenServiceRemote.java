package gov.esprit.service.citoyen;

import javax.ejb.Remote;

import gov.esprit.domain.Citoyen;
import gov.esprit.enums.EtatDemande;
import gov.esprit.exception.EgovException;

@Remote
public interface CitoyenServiceRemote {

	
	public Citoyen findByCin(String cin) throws EgovException;

}
