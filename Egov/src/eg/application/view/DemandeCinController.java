package eg.application.view;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import eg.application.MainApp;
import gov.esprit.enums.Gouvernerat;
import gov.esprit.exception.EgovErrorCode;
import gov.esprit.exception.EgovException;
import gov.esprit.service.cin.DemandeCINServiceRemote;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
	private CheckBox naissance; 
	@FXML
	private CheckBox residance; 
	@FXML
	private CheckBox timbre; 
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
		
		deposer_la_demande.setOnAction(event -> {
			Context context;
			try {
				context = new InitialContext();
				DemandeCINServiceRemote proxy = (DemandeCINServiceRemote) context
						.lookup("e-gov-ear/e-gov-ejb/DemandeCINService!gov.esprit.service.cin.DemandeCINServiceRemote");

				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Date date = sdf.parse(date_de_naissance.getText());
				
				proxy.ajouter(nom.getText(), prenom.getText(), att_dinscription.isSelected(),
						naissance.isSelected(), residance.isSelected(), 
						att_detravail.isSelected(), Gouvernerat.TUNIS, date);
				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.initOwner(null);
				alert.setTitle("Demande CIN Valide");
				alert.setContentText("La demande CIN est deposée avec succès");
				alert.showAndWait();
			} catch (EgovException e) {
				Alert alert = new Alert(AlertType.ERROR);
	            Window dialogStage = null;
				alert.initOwner(dialogStage);
				String contentText = null;
				if (e.getErrorMessage().equals(EgovErrorCode.DOES_NOT_EXIST_ITEM.name()+"_CITOYEN")){
					contentText = "Citoyen inexistant";
				} else {
					contentText = "Documents demandés manquants";
				}
	            alert.setTitle("Demande CIN Invalide");
	            alert.setHeaderText("Merci de vérifier l'existance du Citoyen ou que les documents demandés soient tous fournis.");
	            alert.setContentText(contentText);
	            
	            alert.showAndWait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
