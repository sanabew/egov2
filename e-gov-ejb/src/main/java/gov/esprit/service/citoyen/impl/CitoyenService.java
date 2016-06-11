package gov.esprit.service.citoyen.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import gov.esprit.domain.Citoyen;
import gov.esprit.enums.Gouvernerat;
import gov.esprit.exception.EgovErrorCode;
import gov.esprit.exception.EgovException;
import gov.esprit.service.citoyen.CitoyenServiceLocal;
import gov.esprit.service.citoyen.CitoyenServiceRemote;

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
    public  void add(Citoyen citoyen){
    	
    	em.persist(citoyen);
    }
	@Override
	public Citoyen findByCin(String cin) throws EgovException {
		Citoyen citoyen = null;
		try {
			
			Query query = em.createQuery(
				    "select c from Citoyen c where c.cin = :cin "
				);
			query.setParameter("cin", cin);
			citoyen = (Citoyen) query.getSingleResult();
		
		} catch (Exception e) {
			throw new EgovException(EgovErrorCode.DOES_NOT_EXIST_ITEM, "_CITOYEN_WITH_CIN: " + cin);
		}
		return citoyen;
	}

	@Override
	public Citoyen findByNomAndPrenomAndDateAndGouvernerat(String nom, String prenom, Gouvernerat gouvernerat, Date date)
			throws EgovException {
		
		Citoyen citoyen = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date dd = sdf.parse(sdf.format(date));
		
			Query query = em.createQuery(
				    "SELECT c FROM Citoyen c WHERE c.nom = :nom "
				    + "AND c.prenom = :prenom "
				    + "AND c.dateNaissance = :date "
				    + "AND c.gouvernerat = :gouvernerat"
				);
			
			query.setParameter("nom", nom);
			query.setParameter("prenom", prenom);
			query.setParameter("date", dd);
			query.setParameter("gouvernerat", gouvernerat);
			
			
			citoyen = (Citoyen) query.getSingleResult();
	
		} catch (Exception e) {
			throw new EgovException(EgovErrorCode.DOES_NOT_EXIST_ITEM, "_CITOYEN_WITH: " 
					+ nom + " " + prenom + " lives in" + gouvernerat);
		}
		return citoyen;		
	}
}
