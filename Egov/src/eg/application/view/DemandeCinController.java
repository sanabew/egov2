package eg.application.view;

import java.awt.Checkbox;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import eg.application.MainApp;
import gov.esprit.domain.Citoyen;
import gov.esprit.enums.Gouvernerat;
import gov.esprit.service.cin.DemandeCINServiceRemote;
import gov.esprit.service.user.UserServiceRemote;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Labeled;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;

public class DemandeCinController {

	@FXML
	private Button retour;
	@FXML
	private TextField nom;
	@FXML
	private TextField date_de_naissance;
	@FXML
	private TextField prenom;
	@FXML
	private TextField gouvernerat;
	@FXML
	private CheckBox att_detravail; 
	@FXML
	private CheckBox att_dinscription; 
	@FXML
	private CheckBox photo; 
	@FXML
	private Button deposer_la_demande;
	
	
    // Reference to the main application.
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */

	/**
	 * The constructor (is called before the initialize()-method).
	 * @throws NamingException 
	 */
	public DemandeCinController() throws NamingException {

	}
	
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {

		
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
		
		deposer_la_demande.setOnAction((event) -> {
			Context context;
			try {
				context = new InitialContext();
				DemandeCINServiceRemote proxy = (DemandeCINServiceRemote) context
						.lookup("e-gov-ear/e-gov-ejb/DemandeCINService!gov.esprit.service.cin.DemandeCINServiceRemote");

				
				
					DateFormat format = new SimpleDateFormat("dd.mm.yyyy", Locale.ENGLISH);
					Date date = format.parse(date_de_naissance.getText());
				//	proxy.ajouter("med", "med", true, true, true, true, Gouvernerat.TUNIS);
				
			} catch (Exception e) {
			
				System.out.println(	e.getMessage());
			}
			
			
	    	
		});
	
	}
}
