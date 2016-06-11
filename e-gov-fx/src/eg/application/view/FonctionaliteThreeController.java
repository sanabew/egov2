package eg.application.view;

import java.io.IOException;

import javax.naming.NamingException;

import eg.application.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class FonctionaliteThreeController {
	@FXML
	private Button ouverture_compte;
	@FXML
	private Button transaction;
	@FXML
	private Button releve;
	@FXML
	private Button btn_back;

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
	public FonctionaliteThreeController() throws NamingException {

	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {

		btn_back.setOnAction((event) -> {

			try {
				MainApp.primaryStage.setTitle("Espace User");
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/Dashbord.fxml"));
				AnchorPane page = (AnchorPane) loader.load();
				Scene scene = new Scene(page);
				MainApp.primaryStage.setScene(scene);
				MainApp.primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		});
		ouverture_compte.setOnAction((event) -> {

			try {
				MainApp.primaryStage.setTitle("Creation compte postal");
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/CreationComptePostal.fxml"));
				AnchorPane page = (AnchorPane) loader.load();
				Scene scene = new Scene(page);
				MainApp.primaryStage.setScene(scene);
				MainApp.primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		});
		
		releve.setOnAction((event) -> {

			try {
				MainApp.primaryStage.setTitle("releve compte postal");
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/ExtraireComptePostal.fxml"));
				AnchorPane page = (AnchorPane) loader.load();
				Scene scene = new Scene(page);
				MainApp.primaryStage.setScene(scene);
				MainApp.primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		});

		transaction.setOnAction((event) -> {

			try {
				MainApp.primaryStage.setTitle("Demande CIN");
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/Transaction.fxml"));
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
