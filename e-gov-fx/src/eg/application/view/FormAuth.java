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

import javax.naming.NamingException;

import eg.application.MainApp;

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

			try {
				System.out.println("oki" + login.getText());

				System.out.println("oki" + password.getText());

				if (login.getText().equals("admin") && password.getText().equals("admin")) {

					MainApp.primaryStage.setTitle("Espace User");
					FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/Dashbord.fxml"));
					AnchorPane page = (AnchorPane) loader.load();
					Scene scene = new Scene(page);
					MainApp.primaryStage.setScene(scene);
					MainApp.primaryStage.show();
				} else {
					 Alert alert = new Alert(AlertType.ERROR);
			            Window dialogStage = null;
						alert.initOwner(dialogStage);
			            alert.setTitle("Invalid Login Or Password");
			            alert.setHeaderText("Please correct invalid fields");
			            alert.setContentText("Invalid Login Or Password");
			            
			            alert.showAndWait();
			            
			           
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		});

	}

}