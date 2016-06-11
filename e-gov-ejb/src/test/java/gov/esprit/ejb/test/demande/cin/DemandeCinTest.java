package gov.esprit.ejb.test.demande.cin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.Query;

import org.junit.Test;

import gov.esprit.domain.Citoyen;
import gov.esprit.domain.Demande;
import gov.esprit.enums.Gouvernerat;
import gov.esprit.service.cin.DemandeCINServiceRemote;
import gov.esprit.service.citoyen.CitoyenServiceRemote;

/**
 * DemandeCinTest.
 * 
 * @author monta
 *
 */
public class DemandeCinTest {

	/**
	 * shouldAddDemandeCinValid.
	 */
	@Test
	public void shouldAddDemandeCinValid() {

		try {

			Context context = new InitialContext();

			DemandeCINServiceRemote cinService = (DemandeCINServiceRemote) context
					.lookup("e-gov-ear/e-gov-ejb/DemandeCINService!gov.esprit.service.cin.DemandeCINServiceRemote");

			CitoyenServiceRemote citoyenService = (CitoyenServiceRemote) context
					.lookup("e-gov-ear/e-gov-ejb/CitoyenService!gov.esprit.service.citoyen.CitoyenServiceRemote");

			// create a citoyen
			Citoyen citoyen = new Citoyen();
			citoyen.setNom("monta");
			citoyen.setPrenom("monta");
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String ds = sdf.format(new Date());
			Date date = sdf.parse(ds);
			citoyen.setDateNaissance(date);
			citoyen.setGouvernerat(Gouvernerat.TUNIS);
			citoyenService.add(citoyen);
			
			// request a new cin demande
			cinService.ajouter("monta", "monta", true, true, true, true, Gouvernerat.TUNIS, date);
			
			assertEquals(1, cinService.findAll().size());

		} catch (Exception e) {
			fail("Unexcepted error occurs!");

		}
	}
	
}
