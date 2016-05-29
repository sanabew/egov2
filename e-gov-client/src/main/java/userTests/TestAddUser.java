package userTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import gov.esprit.domain.Citoyen;
import interfaces.UserServiceRemote;

public class TestAddUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
			UserServiceRemote proxy = (UserServiceRemote) context
				.lookup("e-gov-ear/e-gov-ejb/UserService!interfaces.UserServiceRemote");

	
				Citoyen user = new Citoyen();
	
		user.setNom("test");
		
		proxy.addUser(user);
	}

}
