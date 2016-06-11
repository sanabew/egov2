package eg.application.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import eg.application.MainApp;
import gov.esprit.domain.Citoyen;
import gov.esprit.domain.ContratMariage;
import gov.esprit.enums.Civilite;
import gov.esprit.enums.Gouvernerat;
import gov.esprit.enums.Sex;
import gov.esprit.exception.EgovException;
import gov.esprit.service.citoyen.CitoyenServiceRemote;
import gov.esprit.service.municipalite.ServiceMunicipaliteRemote;
import gov.esprit.service.user.UserServiceRemote;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;

public class SaveNewChildController {
	@FXML
	private Button retour;
	@FXML
	private Button btn_enregistre;
	@FXML
	private Button btn_verif;
	@FXML
	private TextField cin_pere;
	@FXML
	private TextField n_contrat;
	@FXML
	private TextField cin_mere;
	@FXML
	private TextField prenom_new_ne;
	@FXML
	private ChoiceBox<Gouvernerat> gouvernerat;
	@FXML
	private TextField date_naissance;
	@FXML
	private ChoiceBox<Integer> jour;
	@FXML
	private ChoiceBox<Integer> mois;
	@FXML
	private ChoiceBox<Integer> annee;
	@FXML
	private ChoiceBox<Sex> sex;
	
	@EJB
	private UserServiceRemote userservice;
	
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
	public SaveNewChildController() throws NamingException {

	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		
		
		
		List<Integer> list = new ArrayList();
		for(int i=1;i<32;i++){list.add(i);}
		ObservableList<Integer> liste = FXCollections.observableArrayList(list);
		jour.setItems(liste);
		List<Integer> listm = new ArrayList();
		for(int i=1;i<13;i++){listm.add(i);}
		ObservableList<Integer> listeM = FXCollections.observableArrayList(listm);
		mois.setItems(listeM);
		List<Integer> lista = new ArrayList();
		for(int i=1950;i<2016;i++){lista.add(i);}
		ObservableList<Integer> listeA = FXCollections.observableArrayList(lista);
		annee.setItems(listeA);
		
		sex.getItems().setAll(Sex.values());
		gouvernerat.getItems().setAll(Gouvernerat.values());
		
		
		
		btn_verif.setOnAction((event)->{
			Sex sexp;
			Sex sexm;
			List<ContratMariage> contrat = new ArrayList();
			try{
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("vérifier les données saisies. ");
			
			Context context2;
			context2 = new InitialContext();	
			CitoyenServiceRemote citoyenservice = (CitoyenServiceRemote) context2
					.lookup("e-gov-ear/e-gov-ejb/CitoyenService!gov.esprit.service.citoyen.CitoyenServiceRemote");
			sexp = citoyenservice.findByCin(cin_pere.getText()).getSex();
			sexm = citoyenservice.findByCin(cin_mere.getText()).getSex();
			
			Context context;
			context = new InitialContext();	
			ServiceMunicipaliteRemote municipaliteservice = (ServiceMunicipaliteRemote) context
					.lookup("e-gov-ear/e-gov-ejb/ServiceMunicipalite!gov.esprit.service.municipalite.ServiceMunicipaliteRemote");
			contrat = municipaliteservice.rechercherContrat(cin_pere.getText(), cin_mere.getText());
			
			
			
			
			if((sexp!=Sex.HOMME)||(sexm!=Sex.FEMME)){alert.setContentText(alert.getContentText()+" sex des parents incorrect");}
			if(contrat.isEmpty()){alert.setContentText(alert.getContentText()+" aucun contrat de mariage trouvé");}
			
			if((sexp!=Sex.HOMME)||(sexm!=Sex.FEMME)||(contrat.isEmpty()))
			{alert.show();
			}else{
				n_contrat.setText(String.valueOf(contrat.get(0).getId()));
				btn_verif.setVisible(true);
				}
			
			}catch(Exception e){
				
				
			}
			
			
		});
		
		
		retour.setOnAction((event) -> {

			try {
				MainApp.primaryStage.setTitle("Espace User");
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/FonctionaliteOne.fxml"));
				AnchorPane page = (AnchorPane) loader.load();
				Scene scene = new Scene(page);
				MainApp.primaryStage.setScene(scene);
				MainApp.primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		});

		
		btn_enregistre.setOnAction((event) -> {

			try{
			Citoyen c = new Citoyen();
			Context context2;
			context2 = new InitialContext();	
			CitoyenServiceRemote citoyenservice = (CitoyenServiceRemote) context2
					.lookup("e-gov-ear/e-gov-ejb/CitoyenService!gov.esprit.service.citoyen.CitoyenServiceRemote");
			Citoyen pere = citoyenservice.findByCin(cin_pere.getText());
			c.setPere(pere);
			Citoyen mere = citoyenservice.findByCin(cin_mere.getText());
			c.setMere(mere);
			Date date = new Date();
		
			
			date.setDate(jour.getValue());
			date.setMonth(mois.getValue()-1);
			date.setYear(annee.getValue()-1900);
			c.setDateNaissance(date);
			c.setSex(sex.getValue());
			c.setPrenom(prenom_new_ne.getText());
			c.setNom(pere.getNom());
			c.setGouvernerat(gouvernerat.getValue());
			c.setCivilite(Civilite.CELIBATAIRE);
			
			Context context;
			context = new InitialContext();	
			ServiceMunicipaliteRemote municipaliteservice = (ServiceMunicipaliteRemote) context
					.lookup("e-gov-ear/e-gov-ejb/ServiceMunicipalite!gov.esprit.service.municipalite.ServiceMunicipaliteRemote");
			municipaliteservice.enregistreNouvNee(c);
			
			}catch(Exception e ){
				
				e.printStackTrace();
				Alert alert = new Alert(AlertType.ERROR);
				
				if( e instanceof EgovException){
					EgovException ee = (EgovException)e;
					System.out.println("egov exeption");
					alert.setContentText(ee.getErrorCode().toString());
				
				}else{alert.setContentText("erreur inconnue");}
				alert.show();
				
			}
		    
		});

	}
}
