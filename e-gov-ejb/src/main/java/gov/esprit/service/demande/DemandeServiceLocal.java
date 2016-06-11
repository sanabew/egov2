package gov.esprit.service.demande;

import javax.ejb.Local;
import gov.esprit.domain.Demande;
import gov.esprit.enums.EtatDemande;
import gov.esprit.exception.EgovException;
@Local
public interface DemandeServiceLocal {
	public EtatDemande suivreDemande(int numero) throws EgovException;

	public Demande rechercherDemande(int numero)throws EgovException;

	void updateDemande(Demande demande);
}
