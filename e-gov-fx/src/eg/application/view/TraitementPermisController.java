package eg.application.view;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import eg.application.MainApp;
import gov.esprit.business.TraiterDemandeInfo;
import gov.esprit.domain.Demande;
import gov.esprit.domain.EtapeCin;
import gov.esprit.domain.EtapePasseport;
import gov.esprit.domain.EtapePermis;
import gov.esprit.enums.EtatDemande;
import gov.esprit.service.demande.DemandeServiceRemote;
import gov.esprit.service.permis.PermisServiceRemote;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class TraitementPermisController {
	@FXML
	private Button retour;
	@FXML
	private Button valider;
	@FXML
	private Button select;
	@FXML
	private TextField num_demande;
	@FXML
	private TextArea demandeur;
	@FXML
	private CheckBox examen;
	@FXML
	private CheckBox impression;
	@FXML
	private CheckBox nette_photo;
	@FXML
	private CheckBox certif_medical;
	@FXML
	private CheckBox recup_par_citoyen;
	@FXML
	private CheckBox irrigularite;
	@FXML
	private Label etat;

	public Demande demande = new Demande();
	public EtapePermis etapes = new EtapePermis();
	public EtapeCin etapes2 = new EtapeCin();
	public EtapePasseport etapes3 = new EtapePasseport();
	public TraiterDemandeInfo demandeInfo = new TraiterDemandeInfo();
	// Reference to the main application.
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */

	/**
	 * The constructor (is called before the initialize()-method).
	 * 
	 * @throws NamingException
	 */
	public TraitementPermisController() {
			
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {

		etapes.initialize();
		select.setOnAction((event) -> {
			try {
			
				Context context;
				context = new InitialContext();
				PermisServiceRemote permisservice = (PermisServiceRemote) context
						.lookup("e-gov-ear/e-gov-ejb/PermisService!gov.esprit.service.permis.PermisServiceRemote");
				System.out.println("resolution jndi");
			
				demande = permisservice.rechercherDemandePermis(Integer.parseInt(num_demande.getText()));
				demandeur.setText(demande.getCitoyen().toString());
				System.out.println("recupération demande en cours");
				examen.setSelected(demande.getEtapePermis().isExamenPermis());
				nette_photo.setSelected(demande.getEtapePermis().isPhotosPermis());
				impression.setSelected(demande.getEtapePermis().isImpressionPermis());
				recup_par_citoyen.setSelected(demande.getEtapePermis().isLivraisonPermis());
				certif_medical.setSelected(demande.getEtapePermis().isCertifMedicalPermis());

				if (demande.getEtat() == EtatDemande.DELIVREE) {
					etat.setText("permis delivré au client");
				}
				if (demande.getEtat() == EtatDemande.EN_COURS) {
					etat.setText("demande en cours de traitement");
				}
				if (demande.getEtat() == EtatDemande.PRET) {
					etat.setText("permis pret");
				}
				if (demande.getEtat() == EtatDemande.EN_ATTENTE) {
					etat.setText("demande en attente");
				}
				if (demande.getEtat() == EtatDemande.IRRIGULARITE) {
					etat.setText("irrugalirité");
				}
				System.out.println("initialisation checklist");
			} catch (Exception e) {
				System.out.println("exception");
				e.printStackTrace();
			}
			
		});

		examen.setOnAction((event) -> {
			demande.getEtapePermis().setExamenPermis(examen.isSelected());
		});
		certif_medical.setOnAction((event) -> {
			demande.getEtapePermis().setCertifMedicalPermis(certif_medical.isSelected());
		});
		nette_photo.setOnAction((event) -> {
			demande.getEtapePermis().setPhotosPermis(nette_photo.isSelected());
		});
		impression.setOnAction((event) -> {
			demande.getEtapePermis().setImpressionPermis(impression.isSelected());
		});
		recup_par_citoyen.setOnAction((event) -> {
			demande.getEtapePermis().setLivraisonPermis(recup_par_citoyen.isSelected());
		});

		valider.setOnAction((event) -> {
			
			etapes.setCertifMedicalPermis(certif_medical.isSelected());
			etapes.setExamenPermis(examen.isSelected());
			etapes.setImpressionPermis(impression.isSelected());
			etapes.setLivraisonPermis(recup_par_citoyen.isSelected());
			etapes.setPhotosPermis(nette_photo.isSelected());
			System.out.println("debut initialisation demande info");
			
			
			etapes2.initialize();
			etapes3.initialize();
			demandeInfo.setEtapeCin(etapes2);
			demandeInfo.setEtapePasseport(etapes3);
			demandeInfo.setEtapePermis(etapes);
			demandeInfo.setConforme(irrigularite.isSelected());
			
			System.out.println("fin initialisation demandeinfo");
			try{
			Context context;
			context = new InitialContext();
			PermisServiceRemote servicepermis = (PermisServiceRemote) context
					.lookup("e-gov-ear/e-gov-ejb/PermisService!gov.esprit.service.permis.PermisServiceRemote");
			if (demandeInfo.isConforme() == true) {
				demande.setEtat(EtatDemande.IRRIGULARITE);
			} else {

				if (demande.getEtapePermis().isLivraisonPermis()) {
					demande.setEtat(EtatDemande.DELIVREE);
				} else {
					if (demande.getEtapePermis().isImpressionPermis()
							&& demande.getEtapePermis().isCertifMedicalPermis()
							&& demande.getEtapePermis().isExamenPermis() && demande.getEtapePermis().isPhotosPermis()) {
						demande.setEtat(EtatDemande.PRET);
						servicepermis.attribuerPermis(demande.getId());
					} else {
						demande.setEtat(EtatDemande.EN_COURS);
					}

				}
			}
			Context context2;
			context2 = new InitialContext();
			DemandeServiceRemote servicedemande = (DemandeServiceRemote) context2
					.lookup("e-gov-ear/e-gov-ejb/DemandeService!gov.esprit.service.demande.DemandeServiceRemote");
			servicedemande.updateDemande(demande);
			
			if (demande.getEtat() == EtatDemande.DELIVREE) {
				etat.setText("permis delivré au client");
			}
			if (demande.getEtat() == EtatDemande.EN_COURS) {
				etat.setText("demande en cours de traitement");
			}
			if (demande.getEtat() == EtatDemande.PRET) {
				etat.setText("permis pret");
			}
			if (demande.getEtat() == EtatDemande.EN_ATTENTE) {
				etat.setText("demande en attente");
			}
			if (demande.getEtat() == EtatDemande.IRRIGULARITE) {
				etat.setText("irrugalirité");
			}
			
			}catch(Exception e){
				e.printStackTrace();
			}
			
			/*try {
				Context context;
				context = new InitialContext();
				PermisServiceRemote permisservice = (PermisServiceRemote) context.lookup("e-gov-ear/e-gov-ejb/PermisService!gov.esprit.service.permis.PermisServiceRemote");
				System.out.println("resolution jndi");
				System.out.println(demandeInfo.getEtapePermis().toString());
				permisservice.traiterDemandePermis(demandeInfo, Integer.parseInt(num_demande.getText()));
				System.out.println("traitement demande");
				
			} catch (Exception e) {
				System.out.println("exception");
				e.printStackTrace();
			}*/

		});

		retour.setOnAction((event) -> {

			try {
				MainApp.primaryStage.setTitle("Espace User");
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/FonctionaliteFour.fxml"));
				AnchorPane page = (AnchorPane) loader.load();
				Scene scene = new Scene(page);
				MainApp.primaryStage.setScene(scene);
				MainApp.primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		});

	}
}
