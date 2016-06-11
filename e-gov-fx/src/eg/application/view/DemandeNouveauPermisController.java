package eg.application.view;


import java.io.IOException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import eg.application.MainApp;
import gov.esprit.enums.TypePermis;
import gov.esprit.service.permis.PermisServiceRemote;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class DemandeNouveauPermisController {

	@FXML
	private Button retour;
	@FXML
	private TextField cin;
	@FXML
	private CheckBox certif_medical; 
	@FXML
	private CheckBox photo; 
	@FXML
	private Button deposer_la_demande;
	@FXML
	private ChoiceBox<TypePermis> type= new ChoiceBox<>();
	
	
    // Reference to the main application.
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */

	/**
	 * The constructor (is called before the initialize()-method).
	 * @throws NamingException 
	 */
	public DemandeNouveauPermisController() throws NamingException {

	}
	
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		type.getItems().setAll(TypePermis.values());
		

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
		
		
		
		deposer_la_demande.setOnAction((event) -> {
			
			
			try {
				Context context;
				context = new InitialContext();
				PermisServiceRemote permisservice = (PermisServiceRemote) context
						.lookup("e-gov-ear/e-gov-ejb/PermisService!gov.esprit.service.permis.PermisServiceRemote");
				System.out.println("resolution jndi");
				permisservice.demanderPermis(cin.getText(),type.getValue());
				System.out.println("permis service");				

			} catch (Exception e) {
				System.out.println("exception");
				System.out.println(e.getMessage());
			}
			
		});
	
	}
}
