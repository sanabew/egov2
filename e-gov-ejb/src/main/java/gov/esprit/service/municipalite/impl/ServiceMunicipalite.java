package gov.esprit.service.municipalite.impl;

import gov.esprit.domain.Citoyen;
import gov.esprit.domain.ContratMariage;
import gov.esprit.enums.Civilite;
import gov.esprit.exception.EgovErrorCode;
import gov.esprit.exception.EgovException;
import gov.esprit.service.citoyen.CitoyenServiceLocal;
import gov.esprit.service.municipalite.ServiceMunicipaliteLocal;
import gov.esprit.service.municipalite.ServiceMunicipaliteRemote;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class ServiceMunicipalite
 */
@Stateless
@LocalBean
public class ServiceMunicipalite implements ServiceMunicipaliteRemote, ServiceMunicipaliteLocal {
	@PersistenceContext
	EntityManager entitymanager;
	Citoyen citoyen = new Citoyen();

	@EJB
	CitoyenServiceLocal citoyenservice;

	/**
	 * Default constructor.
	 */
	public ServiceMunicipalite() {
		// TODO Auto-generated constructor stub

	}

	public void enregistrerMariage(String cin1, String cin2, Date date) throws EgovException {

		Citoyen mari = new Citoyen();
		Citoyen mariee = new Citoyen();

		mari = citoyenservice.findByCin(cin1);
		mariee = citoyenservice.findByCin(cin2);

		if (mariee.getSex() != mari.getSex()) {
			if ((mari.getCivilite() == Civilite.CELIBATAIRE) && (mariee.getCivilite() == Civilite.CELIBATAIRE)) {
				System.out.println("oooo");
				ContratMariage contrat = new ContratMariage();
				contrat.setDate(date);
				contrat.setMari(mari);
				contrat.setMariee(mariee);
				mari.setCivilite(Civilite.MARIE);
				mariee.setCivilite(Civilite.MARIE);
				entitymanager.merge(contrat);
				entitymanager.merge(mari);
				entitymanager.merge(mariee);
			} else {
				throw new EgovException(EgovErrorCode.INVALID_ITEM, "_CIVILITY");
			}
		} else {
			throw new EgovException(EgovErrorCode.INVALID_ITEM, "_SEX");
		}
	}

	public List<ContratMariage> rechercherContrat(String cinH, String cinF) throws EgovException {
		
		
		Citoyen mari = new Citoyen();
		Citoyen mariee = new Citoyen();

		mari = citoyenservice.findByCin(cinH);
		mariee = citoyenservice.findByCin(cinF);

		Query query = entitymanager
				.createQuery("select c from ContratMariage c  where c.mari=:mari AND c.mariee=:mariee");
		query.setParameter("mari", mari);
		query.setParameter("mariee", mariee);
		List<ContratMariage> contrat = query.getResultList();
	

		return contrat;

	}

	public void enregistrerDivorse(String cinH, String cinF, Date date) throws EgovException {

		Citoyen mari = new Citoyen();
		Citoyen mariee = new Citoyen();
		ContratMariage contrat = new ContratMariage();
		contrat = rechercherContrat(cinH, cinF).get(0);
		if (contrat != null) {
			mari = contrat.getMari();
			mariee = contrat.getMariee();
			if (contrat.getDateDivorce() == null) {

				contrat.setDateDivorce(date);
				
				entitymanager.merge(contrat);
				mari.setCivilite(Civilite.DIVORCE);
				mariee.setCivilite(Civilite.DIVORCE);
				entitymanager.merge(mari);
				entitymanager.merge(mariee);
			} else {
				throw new EgovException(EgovErrorCode.INVALID_ITEM, "_DIVORSE DATE ALREADY EXIST");
			}
		} else {
			throw new EgovException(EgovErrorCode.DOES_NOT_EXIST_ITEM, "_MARRIAGE_CONTRACT");
		}
	}
	
	@Override
	public void enregistreNouvNee(Citoyen c)throws Exception {
		
		entitymanager.persist(c);
		
	}
	
	

	

}
