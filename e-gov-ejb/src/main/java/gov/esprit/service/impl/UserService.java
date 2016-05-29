package impl;

import interfaces.UserServiceLocal;
import interfaces.UserServiceRemote;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import gov.esprit.domain.Citoyen;

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

}
