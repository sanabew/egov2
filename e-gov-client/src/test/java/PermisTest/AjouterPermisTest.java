package PermisTest;

import javax.naming.Context;
import javax.naming.InitialContext;

import gov.esprit.service.permis.PermisServiceRemote;

public class AjouterPermisTest {

	public static void main(String[] args) {

		try {
			Context context;
			context = new InitialContext();
			
			PermisServiceRemote permisservice = (PermisServiceRemote) context
					.lookup("e-gov-ear/e-gov-ejb/PermisService!gov.esprit.service.permis.PermisServiceRemote");

			permisservice.attribuerPermis(1);
		;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
