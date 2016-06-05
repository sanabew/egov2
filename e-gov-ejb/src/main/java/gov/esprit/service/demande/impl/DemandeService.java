package gov.esprit.service.demande.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import gov.esprit.domain.Demande;
import gov.esprit.enums.EtatDemande;
import gov.esprit.exception.EgovErrorCode;
import gov.esprit.exception.EgovException;

/**
 * Session Bean implementation class DemandeService
 */
@Stateless
@LocalBean
public class DemandeService implements DemandeServiceRemote, DemandeServiceLocal {
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public DemandeService() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	 public EtatDemande suivreDemande(int numero)throws EgovException {
		   EtatDemande etat = null;
			
			try {
				
				Query query = em.createQuery(
					    "SELECT * FROM Demande c WHERE c.id = :numero"
					);
				query.setParameter("numero", numero);
				etat = ( EtatDemande) query.getSingleResult();
			
			} catch (Exception e) {
				throw new EgovException(EgovErrorCode.DOES_NOT_EXIST_ITEM, "_DEMANDE: " + numero);
			}
			return etat;
	   }
	

    @Override
	 public Demande rechercherDemande(int numero)throws EgovException {
		   Demande demande = null;
			
			try {
				
				Query query = em.createQuery(
					    "SELECT * FROM Demande c WHERE c.id = :numero"
					);
				query.setParameter("numero", numero);
				demande = (Demande) query.getSingleResult();
			
			} catch (Exception e) {
				throw new EgovException(EgovErrorCode.DOES_NOT_EXIST_ITEM, "_DEMANDE: " + numero);
			}
			return demande;
	   }
	
}
