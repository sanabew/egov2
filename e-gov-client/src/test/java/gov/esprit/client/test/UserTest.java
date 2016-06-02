package gov.esprit.client.test;
import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import gov.esprit.domain.Citoyen;
import gov.esprit.service.user.UserServiceRemote;

public class UserTest {

	@Test
	public void test() throws NamingException {
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote) context
			.lookup("e-gov-ear/e-gov-ejb/UserService!gov.esprit.service.UserServiceRemote");

		Citoyen user = new Citoyen();
		user.setNom("test22");
		proxy.addUser(user);
			
		assertEquals(1, proxy.findAll().size());
	}

}
