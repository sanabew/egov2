package gov.esprit.service.person.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import gov.esprit.domain.Person;
import gov.esprit.service.person.PersonServiceLocal;
import gov.esprit.service.person.PersonServiceRemote;

/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean
public class PersonService implements PersonServiceRemote, PersonServiceLocal {

	@PersistenceContext(unitName = "e-gov-ejb")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public PersonService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addUser(Person user) {

		em.persist(user);
	}



	@Override
	public Person findUserById(int userId) {
		return em.find(Person.class, userId);
	}

	@Override
	public List<Person> findAll() {
		Query query = em.createQuery("select e from Person e");
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Person authentificate(String login, String pwd) {
		Person person = null;
		Query query = em.createQuery("select e from Person e where e.login=:l and e.motDePasse=:p");
		
		query.setParameter("l", login).setParameter("p", pwd);
		try {
			person = (Person) query.getSingleResult();
		} catch (Exception e) {
			person = null;
		}
		//System.out.println(person.getFonction());
		return person;
	}

	

	@Override
	public Boolean deleteUser(Person user) {
		Boolean b = false;
		try {
			em.remove(em.merge(user));
			b = true;
		} catch (Exception e) {
			System.err.println("problem deleting user");
		}
		return b;
	}

	@Override
	public Boolean updateUser(Person user) {
		Boolean b = false;
		try {
			em.merge(user);
			b = true;
		} catch (Exception e) {
			System.err.println("problem deleting user");
		}
		return b;
	}
}
