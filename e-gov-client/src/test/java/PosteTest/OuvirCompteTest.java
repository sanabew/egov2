package PosteTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import gov.esprit.domain.Citoyen;
import gov.esprit.exception.EgovException;
import gov.esprit.service.citoyen.CitoyenServiceRemote;
import gov.esprit.service.poste.PosteServiceRemote;

public class OuvirCompteTest {

	public static void main(String[] args) {
		Context context;
		
		Citoyen citoyen = new Citoyen();
		Citoyen citoyen2 = new Citoyen();
		
		citoyen.setCin("2");
		citoyen.setNom("abir");
		citoyen.setPrenom("bel wafi");

		CitoyenServiceRemote citoyenservice;
		PosteServiceRemote posteservice;
		try {
			context = new InitialContext();
			citoyenservice = (CitoyenServiceRemote) context
					.lookup("e-gov-ear/e-gov-ejb/CitoyenService!gov.esprit.service.citoyen.CitoyenServiceRemote");
			System.out.println("step 1 : resolution jndi");
			citoyenservice.addCitoyen(citoyen);
			citoyen2 = citoyenservice.findByCin(citoyen.getCin());
			if (citoyen2 != null) {
				System.out.println(citoyen2.toString());
			} else {
				System.out.println("citoyen null");
			}
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			context = new InitialContext();
			posteservice = (PosteServiceRemote) context
					.lookup("e-gov-ear/e-gov-ejb/PosteService!gov.esprit.service.poste.PosteServiceRemote");
			System.out.println("step 1 : resolution jndi Poste");
			posteservice.ouvrirCompte(citoyen2.getCin());
			System.out.println("step 2 : ouvrir compte");
		} catch (EgovException egov) {
			System.out.println("step 3 : egov exception");
		} catch (NamingException e) {
			System.out.println("step 4 : naming exception");
			e.printStackTrace();
		}

	}

}
