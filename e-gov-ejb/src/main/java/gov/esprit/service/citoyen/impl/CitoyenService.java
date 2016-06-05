package gov.esprit.service.citoyen.impl;

import gov.esprit.domain.Citoyen;
import gov.esprit.enums.EtatDemande;
import gov.esprit.enums.Gouvernerat;
import gov.esprit.exception.EgovErrorCode;
import gov.esprit.exception.EgovException;
import gov.esprit.service.citoyen.CitoyenServiceLocal;
import gov.esprit.service.citoyen.CitoyenServiceRemote;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class CitoyenService
 */
@Stateless
@LocalBean
public class CitoyenService implements CitoyenServiceRemote, CitoyenServiceLocal {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public CitoyenService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Citoyen findByCin(String cin) throws EgovException {
		Citoyen citoyen = null;
		try {
			
			Query query = em.createQuery(
				    "SELECT * FROM Citoyen c WHERE c.cin = :cin"
				);
			query.setParameter("cin", cin);
			citoyen = (Citoyen) query.getSingleResult();
		
		} catch (Exception e) {
			throw new EgovException(EgovErrorCode.DOES_NOT_EXIST_ITEM, "_CITOYEN_WITH_CIN: " + cin);
		}
		return citoyen;
	}

	@Override
	public Citoyen findByNomAndPrenomAndDateAndGouvernerat(String nom, String prenom, Date date,
			Gouvernerat gouvernerat) throws EgovException {
		Citoyen citoyen = null;
		try {
			Query query = em.createQuery(
				    "SELECT * FROM Citoyen c WHERE c.nom = :nom "
				    + "AND c.prenom = :prenom "
				    + "AND c.dateNaissance = :date "
				    + "AND c.gouvernerat := gouvernerat"
				);
			
			query.setParameter("nom", nom);
			query.setParameter("prenom", prenom);
			query.setParameter("date", date);
			query.setParameter("gouvernerat", gouvernerat);
			
			
			citoyen = (Citoyen) query.getSingleResult();
	
		} catch (Exception e) {
			
			throw new EgovException(EgovErrorCode.DOES_NOT_EXIST_ITEM, "_CITOYEN_WITH: " 
					+ nom + " " + prenom + "birth in " + date.toString() + " lives in" + gouvernerat);
		}
		return citoyen;
	}
	
	
	
}
