package eg.application.view;

import java.io.IOException;

import javax.naming.NamingException;

import eg.application.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
    // Reference to the main application.
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */

	/**
	 * The constructor (is called before the initialize()-method).
	 * @throws NamingException 
	 */
	public TraitementPermisController() throws NamingException {

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
