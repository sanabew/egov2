package gov.esprit.service.municipalite;

import javax.ejb.Remote;
import gov.esprit.domain.ContratMariage;
import gov.esprit.exception.EgovException;

@Remote
public interface ServiceMunicipaliteRemote {

	public void enregistrerDivorse(String cinH, String cinF) throws EgovException;
	
	public ContratMariage rechercherContrat(String cinH, String cinF) throws EgovException;
	
	public void enregistrerMariage(String cin1, String cin2) throws EgovException ;
}
