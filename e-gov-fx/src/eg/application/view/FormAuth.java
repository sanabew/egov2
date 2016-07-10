package eg.application.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import eg.application.MainApp;
import gov.esprit.domain.Person;
import gov.esprit.service.person.PersonServiceRemote;

public class FormAuth {

	@FXML
	private TextField login;
	@FXML
	private TextField password;
	@FXML
	private Button submit_auth;

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
	public FormAuth() throws NamingException {

	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {

		submit_auth.setOnAction((event) -> {

				

				
				
				Context context;
				try {
					context = new InitialContext();
					PersonServiceRemote proxy = (PersonServiceRemote) context
							.lookup("e-gov-ear/e-gov-ejb/PersonService!gov.esprit.service.person.PersonServiceRemote");
					           
					Person user = new Person();
				
					user=	proxy.authentificate(login.getText(), password.getText());		
					System.out.println(user.getFonction());
					
						if(	user.getFonction() != null && !	user.getFonction().isEmpty()){
							MainApp.primaryStage.setTitle("Espace User");
							FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/Dashbord.fxml"));
							AnchorPane page = (AnchorPane) loader.load();
							Scene scene = new Scene(page);
							MainApp.primaryStage.setScene(scene);
							MainApp.primaryStage.show();
						}
					
				} catch (Exception e) {
					Alert alert = new Alert(AlertType.ERROR);
		            Window dialogStage = null;
					alert.initOwner(dialogStage);
		            alert.setTitle("Invalid Login Or Password");
		            alert.setHeaderText("Please correct invalid fields");
		            alert.setContentText("Invalid Login Or Password");
		            
		            alert.showAndWait();
				}
				
				
	

		});

	}

}