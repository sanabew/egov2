package CitoyenTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import gov.esprit.domain.Citoyen;
import gov.esprit.enums.Civilite;
import gov.esprit.enums.Gouvernerat;
import gov.esprit.enums.Sex;
import gov.esprit.service.citoyen.CitoyenServiceRemote;

public class AjoutCitoyensTest {

	public static void main(String[] args) throws ParseException {
		Context context;
		Citoyen citoyen = new Citoyen();
		Citoyen citoyen1 = new Citoyen();
		Citoyen citoyen2 = new Citoyen();
		Citoyen citoyen3 = new Citoyen();
		Citoyen citoyen4 = new Citoyen();
		
		citoyen1.setCin("1");
		citoyen1.setNom("ben ali");
		citoyen1.setPrenom("souha");
		citoyen1.setSex(Sex.FEMME);
		citoyen1.setCivilite(Civilite.CELIBATAIRE);
		
	
	
		citoyen.setNom("ben salah");
		citoyen.setPrenom("asma");
		citoyen.setSex(Sex.FEMME);
		citoyen.setCivilite(Civilite.CELIBATAIRE);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String ds = sdf.format(new Date());
		Date date = sdf.parse(ds);
		citoyen.setDateNaissance(date);
		citoyen.setGouvernerat(Gouvernerat.TUNIS);

		citoyen2.setCin("4");
		citoyen2.setNom("riahi");
		citoyen2.setPrenom("youssef");
		citoyen2.setSex(Sex.HOMME);
		citoyen2.setCivilite(Civilite.MARIE);
		
		citoyen3.setCin("3");
		citoyen3.setNom("ayoub");
		citoyen3.setPrenom("feyka");
		citoyen3.setSex(Sex.FEMME);
		citoyen3.setCivilite(Civilite.MARIE);
		
		citoyen4.setCin("2");
		citoyen4.setNom("ayyari");
		citoyen4.setPrenom("belhacem");
		citoyen4.setSex(Sex.HOMME);
		citoyen4.setCivilite(Civilite.CELIBATAIRE);
		
		
		CitoyenServiceRemote citoyenservice;

		try {
			context = new InitialContext();
			citoyenservice = (CitoyenServiceRemote) context
					.lookup("e-gov-ear/e-gov-ejb/CitoyenService!gov.esprit.service.citoyen.CitoyenServiceRemote");
			System.out.println("step 1 : resolution jndi");
			citoyenservice.add(citoyen);
			citoyenservice.add(citoyen1);
			citoyenservice.add(citoyen2);
			citoyenservice.add(citoyen3);
			citoyenservice.add(citoyen4);
			
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
