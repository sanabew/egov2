package gov.esprit.service.demande.impl;

import gov.esprit.domain.Demande;
import gov.esprit.enums.EtatDemande;
import gov.esprit.exception.EgovException;
import gov.esprit.service.demande.DemandeServiceLocal;
import gov.esprit.service.demande.DemandeServiceRemote;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class DemandeService
 */
@Stateless
@LocalBean
public class DemandeService implements DemandeServiceRemote, DemandeServiceLocal {

	@PersistenceContext
	private EntityManager em;
    
    public DemandeService() {
        // TODO Auto-generated constructor stub
    }
    
    
    @Override
	public EtatDemande suivreDemande(int numero) throws EgovException {
		EtatDemande etat = null;

		try {

			Query query = em.createQuery("SELECT c.etat FROM Demande c WHERE c.id = :numero");
			query.setParameter("numero", numero);
			etat = (EtatDemande) query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return etat;
	}
    
    
    @Override
	public Demande rechercherDemande(int numero) throws EgovException {
		Demande demande = null;

		try {

			Query query = em.createQuery("SELECT c FROM Demande c WHERE c.id = :numero");
			query.setParameter("numero", numero);
			demande = (Demande) query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return demande;
	}
    @Override
	public void updateDemande(Demande demande) {
		em.merge(demande);
	}
    

}
