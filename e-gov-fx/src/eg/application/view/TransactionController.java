package eg.application.view;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import eg.application.MainApp;

import gov.esprit.enums.TypeTransacrion;
import gov.esprit.exception.EgovException;
import gov.esprit.service.poste.PosteServiceRemote;
import javafx.application.Preloader.ErrorNotification;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class TransactionController {
	@FXML
	private Button retour;
	@FXML
	private Button btn_valider;
	@FXML
	private TextField cin;
	@FXML
	private TextField num_compte;
	@FXML
	private RadioButton versement;
	@FXML
	private RadioButton retrait;
	@FXML
	private TextField montant;

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
	public TransactionController() throws NamingException {

	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		
		retrait.setOnAction((event) -> {
			versement.setSelected(false);
		});
		versement.setOnAction((event) -> {
			retrait.setSelected(false);
		});

		btn_valider.setOnAction((event) -> {
			TypeTransacrion type = TypeTransacrion.CREDIT;		
			if (retrait.isSelected()) {
				type = TypeTransacrion.DEBIT;
			}
			if (versement.isSelected()) {
				type = TypeTransacrion.CREDIT;
			}		
			try{
				Context context = new InitialContext();
				PosteServiceRemote posteservice = (PosteServiceRemote) context
						.lookup("e-gov-ear/e-gov-ejb/PosteService!gov.esprit.service.poste.PosteServiceRemote");
			posteservice.effectuerTransaction(Integer.parseInt(num_compte.getText()), Float.parseFloat(montant.getText()), cin.getText(), type);
			}
			
			catch(Exception e){
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
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/FonctionaliteThree.fxml"));
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
