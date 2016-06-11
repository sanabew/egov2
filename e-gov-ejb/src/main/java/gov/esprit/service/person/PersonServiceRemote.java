package gov.esprit.service.person;

import java.util.List;

import javax.ejb.Remote;


import gov.esprit.domain.Person;

@Remote
public interface PersonServiceRemote {
	void addUser(Person user);

	
	Boolean deleteUser(Person user);
	Boolean updateUser(Person user);
	Person findUserById(int userId);
	
	List<Person> findAll();
	
	Person authentificate(String login,String pwd);
}
