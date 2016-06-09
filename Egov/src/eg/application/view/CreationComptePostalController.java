package eg.application.view;


import java.io.IOException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import eg.application.MainApp;
import gov.esprit.domain.Citoyen;
import gov.esprit.service.citoyen.CitoyenServiceRemote;
import gov.esprit.service.poste.PosteServiceRemote;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CreationComptePostalController {

	@FXML
	private Button retour;
	@FXML
	private Button btn_verifier;
	@FXML
	private Button btn_compte;
	@FXML
	private TextField cin;
	@FXML
	private TextField nom_prenom;
	@FXML
	private TextField num_compte;

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
	public CreationComptePostalController() throws NamingException {

	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {

		btn_compte.setVisible(false);

		btn_verifier.setOnAction((event) -> {
			Context context;
			Citoyen citoyenFound = new Citoyen();
			CitoyenServiceRemote citoyenservice;
			try {
				context = new InitialContext();
				citoyenservice = (CitoyenServiceRemote) context
						.lookup("e-gov-ear/e-gov-ejb/CitoyenService!gov.esprit.service.citoyen.CitoyenServiceRemote");
				System.out.println("step 1 : resolution jndi");
				System.out.println("step 2 : find by cin : "+cin.getText());
				String param = cin.getText();
				citoyenFound = (Citoyen) citoyenservice.findByCin(cin.getText());
				
				
				if (citoyenFound != null) {
					System.out.println("step 3 : boutton");
					btn_compte.setVisible(true);
					System.out.println(citoyenFound.toString());
					nom_prenom.setText(citoyenFound.getNom()+" "+citoyenFound.getPrenom());

				} else {

					System.out.println("step 5 : citoyen null");
					
				}
			} catch (Exception e) {
				System.out.println("step 4 : exception");
				e.printStackTrace();
			}
		});

		btn_compte.setOnAction((event) -> {
			Context context;
			try {
				context = new InitialContext();
				PosteServiceRemote posteservice = (PosteServiceRemote) context
						.lookup("e-gov-ear/e-gov-ejb/PosteService!gov.esprit.service.poste.PosteServiceRemote");

				int numeroCompte = posteservice.ouvrirCompte(cin.getText());
				num_compte.setText(String.valueOf(numeroCompte));

			} catch (Exception e) {

				System.out.println(e.getMessage());
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
