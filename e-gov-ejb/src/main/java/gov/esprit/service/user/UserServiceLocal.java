package gov.esprit.service.user;

import javax.ejb.Local;

import gov.esprit.domain.Citoyen;


@Local
public interface UserServiceLocal {
	void addUser(Citoyen user);

	void deleteUser(int userId);

	Citoyen findUserById(int userId);
}
