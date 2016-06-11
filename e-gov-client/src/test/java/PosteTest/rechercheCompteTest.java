package PosteTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import gov.esprit.domain.Compte;
import gov.esprit.exception.EgovException;
import gov.esprit.service.poste.PosteServiceRemote;

public class rechercheCompteTest {

	public static void main(String[] args) throws EgovException {
		Context context;
		Compte compte = new Compte();
		try {
			context = new InitialContext();
			PosteServiceRemote posteservice = (PosteServiceRemote) context
					.lookup("e-gov-ear/e-gov-ejb/PosteService!gov.esprit.service.poste.PosteServiceRemote");
			System.out.println("step 1 : resolution jndi");
			compte = posteservice.rechercherCompteParNum(1);
			
			if (compte != null) {
				System.out.println(compte.getProprietaire().toString());
			} else {
				System.out.println("compte null");
			}
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
