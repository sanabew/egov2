package MunicipaliteTest;

import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import gov.esprit.domain.Citoyen;
import gov.esprit.enums.Civilite;
import gov.esprit.enums.Sex;
import gov.esprit.service.municipalite.ServiceMunicipaliteRemote;

public class MariageTest {

	public static void main(String[] args) {

		Citoyen citoyen1 = new Citoyen();
		Citoyen citoyen2 = new Citoyen();
		citoyen2.setCin("5");
		citoyen2.setNom("mohammed");
		citoyen2.setPrenom("haj");
		citoyen2.setSex(Sex.HOMME);
		citoyen2.setCivilite(Civilite.CELIBATAIRE);
		
		citoyen1.setCin("1");
		citoyen1.setNom("sana");
		citoyen1.setPrenom("belwafi");
		citoyen1.setSex(Sex.FEMME);
		citoyen1.setCivilite(Civilite.CELIBATAIRE);
		Context context;
		try {
			context = new InitialContext();
			ServiceMunicipaliteRemote municipaliteservice = (ServiceMunicipaliteRemote) context
					.lookup("e-gov-ear/e-gov-ejb/ServiceMunicipalite!gov.esprit.service.municipalite.ServiceMunicipaliteRemote");
			System.out.println("jndi");
			Date date = new Date();
			municipaliteservice.enregistrerMariage(citoyen1.getCin(), citoyen2.getCin(), date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
