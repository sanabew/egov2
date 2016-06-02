package eg.application.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import javax.naming.NamingException;

import eg.application.MainApp;



public class ValidateNewChildController {
	@FXML
    private TextField cin_conjointe_id;
	@FXML
    private TextField wedding_contract_id;
	@FXML
    private TextField cin_conjoint_id;
	@FXML
	private Button add_child;
    // Reference to the main application.
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */

	/**
	 * The constructor (is called before the initialize()-method).
	 * @throws NamingException 
	 */
	public ValidateNewChildController() throws NamingException {

	}
	
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {

		
	
		add_child.setOnAction((event) -> {
			  MainApp mainApp = new MainApp();
			  mainApp.initRootLayout();
			  mainApp.showPersonOverview();
		});
		
		
	
	}
	
}