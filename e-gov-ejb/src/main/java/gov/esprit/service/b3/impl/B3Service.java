package gov.esprit.service.b3.impl;

import gov.esprit.domain.Citoyen;
import gov.esprit.domain.SanctionPenale;
import gov.esprit.service.b3.B3ServiceLocal;
import gov.esprit.service.b3.B3ServiceRemote;
import gov.esprit.service.citoyen.CitoyenServiceLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class B3Service
 */
@Stateless
@LocalBean
public class B3Service implements B3ServiceRemote, B3ServiceLocal {

	Citoyen citoyen = new Citoyen();
	@EJB
	CitoyenServiceLocal citoyenservice;
	@PersistenceContext
	EntityManager entitymanager;
	
	
	/**
     * Default constructor. 
     */
    public B3Service() {
        // TODO Auto-generated constructor stub
    }
    
    
    public List<SanctionPenale> extraireB3(String cin){
    	
    	List<SanctionPenale> b3 = null;
    	try{
    	citoyen = citoyenservice.findByCin(cin);
    	
    	Query query = entitymanager.createQuery("select s from SanctionPenale s  where s.citoyen=:citoyen");
		query.setParameter("citoyen", citoyen);
		b3 = query.getResultList();
    	
    	}catch(Exception e){
    		System.out.println(e.fillInStackTrace());
    	}
    	return b3;   	
    }

}
