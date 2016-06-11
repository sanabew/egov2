package gov.esprit.service.user.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import gov.esprit.domain.Citoyen;
import gov.esprit.service.user.UserServiceLocal;
import gov.esprit.service.user.UserServiceRemote;

/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean
public class UserService implements UserServiceRemote, UserServiceLocal {

	@PersistenceContext(unitName="e-gov-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public UserService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addUser(Citoyen user) {

		em.merge(user);
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Citoyen findUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Citoyen> findAll() {
		Query query = em.createNativeQuery("select * from citoyen");
		return query.getResultList();
	}

}
