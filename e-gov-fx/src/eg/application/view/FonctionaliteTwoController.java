package eg.application.view;

import java.io.IOException;

import javax.naming.NamingException;

import eg.application.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class FonctionaliteTwoController {
	@FXML
	private Button demande_cin;
	@FXML
	private Button demande_passport;
	@FXML
	private Button demande_perte_cin;
	@FXML
	private Button demande_perte_passport;
	@FXML
	private Button demande_extrait_bulletin;
	@FXML
	private Button renouv_passp;
	@FXML
	private Button traitement_demande_cin;
	@FXML
	private Button trait_demande_passport;
	@FXML
	private Button attestation_de_residence;
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
	public FonctionaliteTwoController() throws NamingException {

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
		demande_passport.setOnAction((event) -> {

			try {
				MainApp.primaryStage.setTitle("Demande CIN");
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/DemandePassport.fxml"));
				AnchorPane page = (AnchorPane) loader.load();
				Scene scene = new Scene(page);
				MainApp.primaryStage.setScene(scene);
				MainApp.primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		});

		demande_cin.setOnAction((event) -> {

			try {
				MainApp.primaryStage.setTitle("Demande CIN");
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/DemandeCin.fxml"));
				AnchorPane page = (AnchorPane) loader.load();
				Scene scene = new Scene(page);
				MainApp.primaryStage.setScene(scene);
				MainApp.primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		});
		demande_perte_cin.setOnAction((event) -> {

			try {
				MainApp.primaryStage.setTitle("Declaration Perte CIN");
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/DeclarationPerteCIN.fxml"));
				AnchorPane page = (AnchorPane) loader.load();
				Scene scene = new Scene(page);
				MainApp.primaryStage.setScene(scene);
				MainApp.primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		});
		demande_perte_passport.setOnAction((event) -> {

			try {
				MainApp.primaryStage.setTitle("Declaration Perte Passport");
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/DeclarationPertePassport.fxml"));
				AnchorPane page = (AnchorPane) loader.load();
				Scene scene = new Scene(page);
				MainApp.primaryStage.setScene(scene);
				MainApp.primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		});
		demande_extrait_bulletin.setOnAction((event) -> {

			try {
				MainApp.primaryStage.setTitle("Demande Bulletin N°3");
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/DemandeBulletin.fxml"));
				AnchorPane page = (AnchorPane) loader.load();
				Scene scene = new Scene(page);
				MainApp.primaryStage.setScene(scene);
				MainApp.primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		});
		renouv_passp.setOnAction((event) -> {

			try {
				MainApp.primaryStage.setTitle("Renouvellement Passport");
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/RenouvellemntPassport.fxml"));
				AnchorPane page = (AnchorPane) loader.load();
				Scene scene = new Scene(page);
				MainApp.primaryStage.setScene(scene);
				MainApp.primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		});
		traitement_demande_cin.setOnAction((event) -> {

			try {
				MainApp.primaryStage.setTitle("Liste des demandes CIN");
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/ListeDemandeCin.fxml"));
				AnchorPane page = (AnchorPane) loader.load();
				Scene scene = new Scene(page);
				MainApp.primaryStage.setScene(scene);
				MainApp.primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		});
		
		trait_demande_passport.setOnAction((event) -> {

			try {
				MainApp.primaryStage.setTitle("Liste des demandes Passport");
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/ListeDemandePassport.fxml"));
				AnchorPane page = (AnchorPane) loader.load();
				Scene scene = new Scene(page);
				MainApp.primaryStage.setScene(scene);
				MainApp.primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		});
		attestation_de_residence.setOnAction((event) -> {

			try {
				MainApp.primaryStage.setTitle("Attestation de residence");
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/AtestationResidence.fxml"));
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
