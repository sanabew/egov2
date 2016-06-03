package gov.esprit.service.citoyen.impl;

import gov.esprit.domain.Citoyen;
import gov.esprit.exception.EgovErrorCode;
import gov.esprit.exception.EgovException;
import gov.esprit.service.citoyen.CitoyenServiceLocal;
import gov.esprit.service.citoyen.CitoyenServiceRemote;
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

}
