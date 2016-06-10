package PermisTest;

import javax.naming.Context;
import javax.naming.InitialContext;


import gov.esprit.business.TraiterDemandeInfo;
import gov.esprit.domain.Demande;
import gov.esprit.domain.EtapeCin;
import gov.esprit.domain.EtapePasseport;
import gov.esprit.domain.EtapePermis;
import gov.esprit.enums.EtatDemande;
import gov.esprit.service.demande.DemandeServiceRemote;
import gov.esprit.service.permis.PermisServiceRemote;

public class TraitementPermisTest {
	public static void main(String[] args) {
		
		EtapePermis etapes = new EtapePermis();
		etapes.setCertifMedicalPermis(true);
		etapes.setExamenPermis(true);
		etapes.setLivraisonPermis(false);
		etapes.setPhotosPermis(false);
		etapes.setImpressionPermis(false);
		
		
		
		try {

		
			TraiterDemandeInfo info = new TraiterDemandeInfo();
			EtapeCin etapes2 = new EtapeCin();
			etapes2.initialize();
			EtapePasseport etapes3 = new EtapePasseport();
			etapes3.initialize();
			info.setEtapeCin(etapes2);
			info.setEtapePasseport(etapes3);
			info.setEtapePermis(etapes);
			Context context;
			context = new InitialContext();
			DemandeServiceRemote demandeservice = (DemandeServiceRemote) context.lookup(
					"e-gov-ear/e-gov-ejb/DemandeService!gov.esprit.service.demande.DemandeServiceRemote");
			System.out.println("resolution jndi demande");
			
			Context context2;
			context2 = new InitialContext();
			PermisServiceRemote permisservice = (PermisServiceRemote) context2.lookup(
					"e-gov-ear/e-gov-ejb/PermisService!gov.esprit.service.permis.PermisServiceRemote");
			System.out.println("resolution jndi permis");
			Demande demande = demandeservice.rechercherDemande(1);
			demande.setEtapePermis(info.getEtapePermis());
			demande.setEtapeCin(info.getEtapeCin());
			demande.setEtapePasseport(info.getEtapePasseport());
			if (info.isConforme() == false) {
				demande.setEtat(EtatDemande.IRRIGULARITE);
			} else {

				if (demande.getEtapePermis().isLivraisonPermis()) {
					demande.setEtat(EtatDemande.DELIVREE);
				} else {
					if (demande.getEtapePermis().isImpressionPermis()
							&& demande.getEtapePermis().isCertifMedicalPermis()
							&& demande.getEtapePermis().isExamenPermis() && demande.getEtapePermis().isPhotosPermis()) {
						demande.setEtat(EtatDemande.PRET);
						System.out.println("correct");
						permisservice.attribuerPermis(1);
					} else {
						demande.setEtat(EtatDemande.EN_COURS);
					}

				}
			}
			demandeservice.updateDemande(demande);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
