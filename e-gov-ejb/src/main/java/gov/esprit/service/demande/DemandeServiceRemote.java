package gov.esprit.service.demande;

import javax.ejb.Remote;

import gov.esprit.domain.Demande;
import gov.esprit.enums.EtatDemande;
import gov.esprit.exception.EgovException;

@Remote
public interface DemandeServiceRemote {
	public EtatDemande suivreDemande(int numero) throws EgovException;

	public Demande rechercherDemande(int numero)throws EgovException;

	void updateDemande(Demande demande);
}
