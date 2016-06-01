package gov.esprit.service.cin.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gov.esprit.business.CinInfo;
import gov.esprit.domain.Citoyen;
import gov.esprit.domain.Demande;
import gov.esprit.enums.EtatDemande;
import gov.esprit.enums.Gouvernerat;
import gov.esprit.enums.TypeDemande;
import gov.esprit.exception.EgovErrorCode;
import gov.esprit.exception.EgovException;
import gov.esprit.service.cin.DemandeCINServiceLocal;
import gov.esprit.service.cin.DemandeCINServiceRemote;
import gov.esprit.service.user.UserServiceLocal;
import gov.esprit.utils.Identifier;

/**
 * Session Bean implementation class DemandeCINService.
 * 
 * @author monta
 */
@Stateful
@LocalBean
public class DemandeCINService implements DemandeCINServiceRemote, DemandeCINServiceLocal {

	/**
	 * {@link UserServiceLocal}.
	 */
	@EJB
	UserServiceLocal userServiceLocal;
	
	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public DemandeCINService() {
        // TODO Auto-generated constructor stub
    }

	/* (non-Javadoc)
	 * @see gov.esprit.service.cin.DemandeCINServiceLocal#forCin(gov.esprit.domain.Citoyen, boolean, boolean)
	 */
	@Override
	public void ajouter(Citoyen citoyen, boolean isExtrait, boolean isResidenceProof, Gouvernerat gouvernerat) throws EgovException {
		
		if (citoyen == null){
			// TODO recup citoyen depuis une reference
			throw new EgovException(EgovErrorCode.DOES_NOT_EXIST_ITEM, "_CITOYEN");
		}
		if(!isExtrait){
			throw new EgovException(EgovErrorCode.DOES_NOT_EXIST_ITEM, "_EXTRAIT_DE_NAISSANCE");
		}
		if(!isResidenceProof){
			throw new EgovException(EgovErrorCode.DOES_NOT_EXIST_ITEM, "_PREUVE_DE_RESIDENCE");
		}
		
		Demande demande = new Demande();
		demande.setType(TypeDemande.DEMANDE_CIN);
		demande.setDate(LocalDateTime.now());
		demande.setEtat(EtatDemande.EN_ATTENTE);
		demande.setCitoyen(citoyen);
		
		em.persist(demande);
	}

	@Override
	public void traiter(Demande demande) throws EgovException {
		// TODO recuperer demande depuis reference
		
	}

	@Override
	public CinInfo delivrer(Demande demande) throws EgovException {
		// TODO recuperer demande depuis une reference.
		CinInfo cinInfo = new CinInfo();
		
		// get the cin proprio
		Citoyen citoyen = demande.getCitoyen();	
		cinInfo.setProprietaire(citoyen);
		
		cinInfo.setDateExpedition(LocalDateTime.now());
		
		// generate cin identifier
		String cin = Identifier.generate(citoyen.getId());
		cinInfo.setNumero(Integer.valueOf(cin));
		
		cinInfo.setReferenceEmpreinte(UUID.randomUUID().toString());
		
		demande.setEtat(EtatDemande.PRET);
		em.merge(demande);
		
		return cinInfo;
	}

	@Override
	public EtatDemande getEtat(Demande demande) throws EgovException {
		// recuperer demande depuis refernces
		return demande.getEtat();
	}

}
