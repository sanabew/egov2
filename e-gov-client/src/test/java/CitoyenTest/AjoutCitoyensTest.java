package CitoyenTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import gov.esprit.domain.Citoyen;
import gov.esprit.enums.Civilite;
import gov.esprit.enums.Sex;
import gov.esprit.service.citoyen.CitoyenServiceRemote;

public class AjoutCitoyensTest {

	public static void main(String[] args) {
		Context context;
		Citoyen citoyen = new Citoyen();
		Citoyen citoyen1 = new Citoyen();
		Citoyen citoyen2 = new Citoyen();
		Citoyen citoyen3 = new Citoyen();
		Citoyen citoyen4 = new Citoyen();
		
		citoyen1.setCin("1");
		citoyen1.setNom("sana");
		citoyen1.setPrenom("belwafi");
		citoyen1.setSex(Sex.FEMME);
		citoyen1.setCivilite(Civilite.CELIBATAIRE);
	
		citoyen.setCin("2");
		citoyen.setNom("marwa");
		citoyen.setPrenom("henchir");
		citoyen.setSex(Sex.FEMME);
		citoyen.setCivilite(Civilite.CELIBATAIRE);

		citoyen2.setCin("3");
		citoyen2.setNom("montassar");
		citoyen2.setPrenom("el behi");
		citoyen2.setSex(Sex.HOMME);
		citoyen2.setCivilite(Civilite.MARIE);
		
		citoyen3.setCin("4");
		citoyen3.setNom("hanen");
		citoyen3.setPrenom("majdi");
		citoyen3.setSex(Sex.FEMME);
		citoyen3.setCivilite(Civilite.MARIE);
		
		citoyen4.setCin("5");
		citoyen4.setNom("mohammed");
		citoyen4.setPrenom("haj");
		citoyen4.setSex(Sex.HOMME);
		citoyen4.setCivilite(Civilite.CELIBATAIRE);
		
		
		CitoyenServiceRemote citoyenservice;

		try {
			context = new InitialContext();
			citoyenservice = (CitoyenServiceRemote) context
					.lookup("e-gov-ear/e-gov-ejb/CitoyenService!gov.esprit.service.citoyen.CitoyenServiceRemote");
			System.out.println("step 1 : resolution jndi");
			citoyenservice.addCitoyen(citoyen);
			citoyenservice.addCitoyen(citoyen1);
			citoyenservice.addCitoyen(citoyen2);
			citoyenservice.addCitoyen(citoyen3);
			citoyenservice.addCitoyen(citoyen4);
			
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
