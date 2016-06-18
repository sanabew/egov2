package TransportTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import gov.esprit.domain.AbonnementTransport;
import gov.esprit.domain.Station;
import gov.esprit.enums.TypeHoraire;
import gov.esprit.enums.TypeTrajet;
import gov.esprit.service.abonnement.AbonnementServiceRemote;
import gov.esprit.service.abonnement.impl.AbonnementService;
import gov.esprit.service.citoyen.CitoyenServiceRemote;
import gov.esprit.service.person.PersonServiceRemote;

public class AjoutAbonnementTest {

	public static void main(String[] args) {
		AbonnementTransport ab = new AbonnementTransport();
		AbonnementTransport ab1 = new AbonnementTransport();
		AbonnementTransport ab2 = new AbonnementTransport();
		AbonnementTransport ab3 = new AbonnementTransport();
		
		ab.setHoraire(TypeHoraire.SEPT_JOURS);
		ab.setTrajet(TypeTrajet.TRAIN_URBAIN_SUD);
		ab.setPrix(210);
		
		ab1.setHoraire(TypeHoraire.SEPT_JOURS);
		ab1.setTrajet(TypeTrajet.TRAIN_URBAIN_NORD);
		ab1.setPrix(200);

		ab2.setHoraire(TypeHoraire.SIX_JOURS);
		ab2.setTrajet(TypeTrajet.TRAIN_URBAIN_SUD);
		ab2.setPrix(170);
		
		ab3.setHoraire(TypeHoraire.SIX_JOURS);
		ab3.setTrajet(TypeTrajet.TRAIN_URBAIN_NORD);
		ab3.setPrix(100);
		
		try {
			Context context = new InitialContext();
			AbonnementServiceRemote  abonnementservice = (AbonnementServiceRemote) context
					.lookup("e-gov-ear/e-gov-ejb/AbonnementService!gov.esprit.service.abonnement.AbonnementServiceRemote");
			System.out.println("step 1 : resolution jndi");
			abonnementservice.addAbonnement(ab);
			abonnementservice.addAbonnement(ab1);
			abonnementservice.addAbonnement(ab2);
			abonnementservice.addAbonnement(ab3);
			
			
			System.out.println("ajouté");
			
			Station s1 = new Station();
			s1.setLat(36.8012077);
			s1.setLon(10.1911199);
			s1.setType(TypeTrajet.TRAIN_URBAIN_NORD);
			abonnementservice.addStation(s1);
			Station s2 = new Station();
			s2.setLat(36.8183322);
			s2.setLon(10.3010703);
			s2.setType(TypeTrajet.TRAIN_URBAIN_NORD);
			abonnementservice.addStation(s2);
			Station s3 = new Station();
			s3.setLat(36.820196);
			s3.setLon(10.3043104);
			s3.setType(TypeTrajet.TRAIN_URBAIN_NORD);
			abonnementservice.addStation(s3);
			Station s4 = new Station();
			s4.setLat(36.8260618);
			s4.setLon(10.3089131);
			s4.setType(TypeTrajet.TRAIN_URBAIN_NORD);
			abonnementservice.addStation(s4);
			Station s5 = new Station();
			s5.setLat(36.8312874);
			s5.setLon(10.3120137);
			s5.setType(TypeTrajet.TRAIN_URBAIN_NORD);
			abonnementservice.addStation(s5);
			Station s6 = new Station();
			s6.setLat(36.8365942);
			s6.setLon(10.315168);
			s6.setType(TypeTrajet.TRAIN_URBAIN_NORD);
			abonnementservice.addStation(s6);
			Station s7 = new Station();
			s7.setLat(36.8430169);
			s7.setLon(10.318451);
			s7.setType(TypeTrajet.TRAIN_URBAIN_NORD);
			abonnementservice.addStation(s7);
			Station s8 = new Station();
			s8.setLat(36.8516884);
			s8.setLon(10.3250385);
			s8.setType(TypeTrajet.TRAIN_URBAIN_NORD);
			abonnementservice.addStation(s8);
			Station s9 = new Station();
			s9.setLat(10.3250385);
			s9.setLon(10.334158);
			s9.setType(TypeTrajet.TRAIN_URBAIN_NORD);
			abonnementservice.addStation(s9);
			Station s10 = new Station();
			s10.setLat(36.8704703);
			s10.setLon(10.3392864);
			s10.setType(TypeTrajet.TRAIN_URBAIN_NORD);
			abonnementservice.addStation(s10);
			Station s11 = new Station();
			s11.setLat(36.8822968);
			s11.setLon(10.3325916);
			s11.setType(TypeTrajet.TRAIN_URBAIN_NORD);
			abonnementservice.addStation(s11);
		
			
			Station x1 = new Station();
			x1.setLat(36.7952396);
			x1.setLon(10.1788915);
			x1.setType(TypeTrajet.TRAIN_URBAIN_SUD);
			abonnementservice.addStation(x1);
			x1.setLat(36.7808419);
			x1.setLon(10.1936363);
			x1.setType(TypeTrajet.TRAIN_URBAIN_SUD);
			abonnementservice.addStation(x1);
			x1.setLat(36.7744738);
			x1.setLon(10.2147569);
			x1.setType(TypeTrajet.TRAIN_URBAIN_SUD);
			abonnementservice.addStation(x1);
			x1.setLat(36.7698067);
			x1.setLon(10.2350279);
			x1.setType(TypeTrajet.TRAIN_URBAIN_SUD);
			abonnementservice.addStation(x1);
			x1.setLat(36.767862);
			x1.setLon(10.2551775);
			x1.setType(TypeTrajet.TRAIN_URBAIN_SUD);
			abonnementservice.addStation(x1);
			x1.setLat(36.7579919);
			x1.setLon(10.2783616);
			x1.setType(TypeTrajet.TRAIN_URBAIN_SUD);
			abonnementservice.addStation(x1);
			x1.setLat(36.7383939);
			x1.setLon(10.313684);
			x1.setType(TypeTrajet.TRAIN_URBAIN_SUD);
			abonnementservice.addStation(x1);
			
			
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
