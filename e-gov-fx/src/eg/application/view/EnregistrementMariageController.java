package eg.application.view;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import eg.application.MainApp;
import gov.esprit.exception.EgovException;
import gov.esprit.service.municipalite.ServiceMunicipaliteRemote;
import gov.esprit.service.poste.PosteServiceRemote;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class EnregistrementMariageController {
	@FXML
	private Button retour;
	@FXML
	private Button btn_enregistre;
	@FXML
	private TextField cin_mari;
	@FXML
	private TextField cin_marie;
	@FXML
	private ChoiceBox<Integer> jour;
	@FXML
	private ChoiceBox<Integer> mois;
	@FXML
	private ChoiceBox<Integer> annee;
    // Reference to the main application.
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */

	/**
	 * The constructor (is called before the initialize()-method).
	 * @throws NamingException 
	 */
	public EnregistrementMariageController() throws NamingException {

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
		liste = FXCollections.observableArrayList(listm);
		mois.setItems(liste);
		List<Integer> lista = new ArrayList();
		for(int i=1950;i<2017;i++){lista.add(i);}
		liste = FXCollections.observableArrayList(lista);
		annee.setItems(liste);
		
		btn_enregistre.setOnAction((event)->{
			try{
				Context context = new InitialContext();
				ServiceMunicipaliteRemote municipaliteservice = (ServiceMunicipaliteRemote) context
						.lookup("e-gov-ear/e-gov-ejb/ServiceMunicipalite!gov.esprit.service.municipalite.ServiceMunicipaliteRemote");
				Date date = new Date();
				date.setDate(jour.getValue());
				date.setMonth(mois.getValue()-1);
				date.setYear(annee.getValue()-1900);
				municipaliteservice.enregistrerMariage(cin_mari.getText(), cin_marie.getText(), date);
				System.out.println("ok");
			}catch(Exception e){
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
		
		
		
	
	}
}
