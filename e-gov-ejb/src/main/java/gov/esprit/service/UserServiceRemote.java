package interfaces;

import javax.ejb.Remote;

import gov.esprit.domain.Citoyen;

@Remote
public interface UserServiceRemote {
	void addUser(Citoyen user);

	void deleteUser(int userId);

	Citoyen findUserById(int userId);
}
