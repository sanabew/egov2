package DemandeTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import gov.esprit.domain.Demande;
import gov.esprit.enums.EtatDemande;
import gov.esprit.service.demande.DemandeServiceRemote;

public class UpdateDemandeTest {

	public static void main(String[] args) {
		try {
			Context context;
			context = new InitialContext();
			DemandeServiceRemote demandeservice = (DemandeServiceRemote) context
					.lookup("e-gov-ear/e-gov-ejb/DemandeService!gov.esprit.service.demande.impl.DemandeServiceRemote");
			System.out.println("resolution jndi demande");
			Demande demande = demandeservice.rechercherDemande(1);
			demande.setEtat(EtatDemande.IRRIGULARITE);
			demandeservice.updateDemande(demande);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
