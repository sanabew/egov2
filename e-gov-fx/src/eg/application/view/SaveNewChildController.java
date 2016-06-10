package eg.application.view;

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
import eg.application.util.DateUtil;
import gov.esprit.domain.Citoyen;
import gov.esprit.service.user.UserServiceRemote;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
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
	private TextField lieu_naissance;
	@FXML
	private TextField date_naissance;
	@FXML
	private RadioButton radio_homme;
	@FXML
	private RadioButton radio_femme;
	@EJB
	private UserServiceRemote userservice;
	
	// Reference to the main application.
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */


	 private boolean isInputValid() {
	        String errorMessage = "";

	        if (date_naissance.getText() == null || date_naissance.getText().length() == 0) {
	            errorMessage += "No valid birthday!\n";
	        } else {
	            if (!DateUtil.validDate(date_naissance.getText())) {
	                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
	            }
	        }

	        if (errorMessage.length() == 0) {
	            return true;
	        } else {
	            // Show the error message.
	            Alert alert = new Alert(AlertType.ERROR);
	            Window dialogStage = null;
				alert.initOwner(dialogStage);
	            alert.setTitle("Invalid Fields");
	            alert.setHeaderText("Please correct invalid fields");
	            alert.setContentText(errorMessage);
	            
	            alert.showAndWait();
	            
	            return false;
	        }
	    }
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

		btn_verif.setOnAction((event) -> {

			System.out.println("oki" + cin_pere.getText());
			System.out.println("oki" + cin_mere.getText());
			System.out.println("oki" + n_contrat.getText());

		});
		btn_enregistre.setOnAction((event) -> {

			System.out.println("oki" + radio_homme.getText());
			System.out.println("oki" + prenom_new_ne.getText());
			System.out.println("oki" + lieu_naissance.getText());
			System.out.println("oki" + date_naissance.getText());

			Context context;
			try {
				context = new InitialContext();
				UserServiceRemote proxy = (UserServiceRemote) context
						.lookup("e-gov-ear/e-gov-ejb/UserService!gov.esprit.service.user.UserServiceRemote");

				Citoyen user = new Citoyen();
				user.setNom(prenom_new_ne.getText());

				user.setPrenom("prenom");

				
				if(isInputValid()){
					DateFormat format = new SimpleDateFormat("dd.mm.yyyy", Locale.ENGLISH);
					Date date = format.parse(date_naissance.getText());
					user.setDateNaissance(date);
				proxy.addUser(user);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			/**
		     * Called when the user clicks ok.
		     */
		    
		});

	}
}
