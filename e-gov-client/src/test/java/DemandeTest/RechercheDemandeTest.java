package DemandeTest;

import javax.naming.Context;
import javax.naming.InitialContext;

import gov.esprit.domain.Citoyen;
import gov.esprit.domain.Demande;
import gov.esprit.service.demande.DemandeServiceRemote;

public class RechercheDemandeTest {

	public static void main(String[] args) {
		
		try{
		Context context;
		context = new InitialContext();
		DemandeServiceRemote demandeservice = (DemandeServiceRemote)context.lookup(
				"e-gov-ear/e-gov-ejb/DemandeService!gov.esprit.service.demande.impl.DemandeServiceRemote");
		System.out.println("resolution jndi demande");
		Demande demande = demandeservice.rechercherDemande(1);
		Citoyen c = demande.getCitoyen();
		System.out.println(c.toString());
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
