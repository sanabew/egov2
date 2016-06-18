package TransportTest;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import gov.esprit.domain.Station;
import gov.esprit.enums.TypeTrajet;
import gov.esprit.service.abonnement.AbonnementServiceRemote;

public class DetailTrajetTest {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			AbonnementServiceRemote  abonnementservice = (AbonnementServiceRemote) context
					.lookup("e-gov-ear/e-gov-ejb/AbonnementService!gov.esprit.service.abonnement.AbonnementServiceRemote");
			System.out.println("step 1 : resolution jndi");
			
			List<Station> list = new ArrayList<>();
			list=abonnementservice.detailTrajet(TypeTrajet.TRAIN_URBAIN_NORD);
			System.out.println(list.size());
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
