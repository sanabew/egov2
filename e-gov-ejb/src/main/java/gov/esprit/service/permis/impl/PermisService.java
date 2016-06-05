package gov.esprit.service.permis.impl;

import gov.esprit.domain.Citoyen;
import gov.esprit.domain.Demande;
import gov.esprit.enums.EtatDemande;
import gov.esprit.enums.TypeDemande;
import gov.esprit.enums.TypePermis;
import gov.esprit.exception.EgovException;
import gov.esprit.service.citoyen.CitoyenServiceLocal;
import gov.esprit.service.permis.PermisServiceLocal;
import gov.esprit.service.permis.PermisServiceRemote;

import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class PermisService
 */
@Stateless
@LocalBean
public class PermisService implements PermisServiceRemote, PermisServiceLocal {

	Demande demande = new Demande();
	Citoyen citoyen = new Citoyen();
	@EJB
	CitoyenServiceLocal citoyenservice;
	@PersistenceContext
	EntityManager entitymanager;
    /**
     * Default constructor. 
     */
    public PermisService() {
        // TODO Auto-generated constructor stub
    }
    
   
    public void demanderPermis(String cin)throws EgovException {
    	
    	citoyen = citoyenservice.findByCin(cin);
    	demande.setCitoyen(citoyen);
    	demande.setDate(new Date());
    	demande.setType(TypeDemande.DEMANDE_PERMIS);
    	demande.setEtat(EtatDemande.EN_ATTENTE);
    	
    	entitymanager.persist(demande);
    }
    
   public void demanderRenouvPermis(String cin)throws EgovException {
    	
    	citoyen = citoyenservice.findByCin(cin);
    	demande.setCitoyen(citoyen);
    	demande.setDate(Calendar.getInstance().getTime());
    	demande.setType(TypeDemande.DEMANDE_PERMIS);
    	demande.setEtat(EtatDemande.EN_ATTENTE);
    	//demande.setTypePermis(type);
    	entitymanager.persist(demande);
    }
   

   
   
    

}
