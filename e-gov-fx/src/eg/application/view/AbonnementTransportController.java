package eg.application.view;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import eg.application.MainApp;
import eg.application.MapApp;
import gov.esprit.enums.TypeHoraire;
import gov.esprit.enums.TypeTrajet;
import gov.esprit.service.abonnement.AbonnementServiceRemote;
import gov.esprit.service.abonnement.impl.AbonnementService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AbonnementTransportController {
	
	
	@FXML
    private TextField  
    prix;
	@FXML
	private Button retour;
	@FXML
	private Button valider;
	@FXML
	private Button map;
	@FXML
	private Button verif_prix;
	@FXML
	private ChoiceBox<TypeTrajet> type_trajet;
	@FXML
	private ChoiceBox<TypeHoraire> type_horaire;
    // Reference to the main application.
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */

	/**
	 * The constructor (is called before the initialize()-method).
	 * @throws NamingException 
	 */
	public AbonnementTransportController() throws NamingException {

	}
	
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		type_horaire.getItems().setAll(TypeHoraire.values());
		type_trajet.getItems().setAll(TypeTrajet.values());
		
	
		verif_prix.setOnAction(event->{
			Context context;
			try {
				context = new InitialContext();
				AbonnementService ab = (AbonnementService) context
						.lookup("e-gov-ear/e-gov-ejb/AbonnementService!gov.esprit.service.citoyen.AbonnementServiceRemote");
				System.out.println("step 1 : resolution jndi");
				
				prix.setText(String.valueOf(ab.getPrix(type_trajet.getValue(), type_horaire.getValue())));}
			catch(Exception e){e.printStackTrace();}
		});
		
verif_prix.setOnAction(event->{
	
	try{
		Context context = new InitialContext();
		AbonnementServiceRemote  abonnementservice = (AbonnementServiceRemote) context
				.lookup("e-gov-ear/e-gov-ejb/AbonnementService!gov.esprit.service.abonnement.AbonnementServiceRemote");
		System.out.println("step 1 : resolution jndi");
		prix.setText(String.valueOf(abonnementservice.getPrix(type_trajet.getValue(), type_horaire.getValue())));
		
	}catch(Exception e){
		e.printStackTrace();
		}
	
});
		
map.setOnAction((event) -> {
			
	 new Thread() {
         @Override
         public void run() {
             javafx.application.Application.launch(MapApp.class);
         }
     }.start();
     MapApp map = new MapApp();
     
    
     try {
    	 Context context = new InitialContext();
			AbonnementServiceRemote  abonnementservice = (AbonnementServiceRemote) context
					.lookup("e-gov-ear/e-gov-ejb/AbonnementService!gov.esprit.service.abonnement.AbonnementServiceRemote");
			System.out.println("step 1 : resolution jndi");
			map.start(MainApp.primaryStage);
		map.stationList=abonnementservice.detailTrajet(type_trajet.getValue());
		map.mapInitialized();
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
     
	    	
		});
		
		retour.setOnAction((event) -> {
			
			try {
				MainApp.primaryStage.setTitle("Espace User");
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/FonctionaliteTwo.fxml"));
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
