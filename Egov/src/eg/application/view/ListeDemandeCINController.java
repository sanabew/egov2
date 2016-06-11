package eg.application.view;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import gov.esprit.domain.Demande;
import gov.esprit.service.cin.DemandeCINServiceRemote;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListeDemandeCINController {
//	@FXML
//	private Button retour;
	@FXML
	private TableView<Demande> tableDemandeCin;
	@FXML
	private TableColumn<Demande, String> numero;
	@FXML
	private TableColumn<Demande, String> date;
    // Reference to the main application.
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */

	/**
	 * The constructor (is called before the initialize()-method).
	 * @throws NamingException 
	 */
	public ListeDemandeCINController() throws NamingException {

	}
	
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		
		 numero.setCellValueFactory(new PropertyValueFactory<Demande, String>("id"));
	     date.setCellValueFactory(new PropertyValueFactory<Demande, String>("date"));
		tableDemandeCin.getItems().setAll(parseUserList());
		
//		retour.setOnAction((event) -> {
//			
//			try {
//				MainApp.primaryStage.setTitle("Espace User");
//				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/FonctionaliteOne.fxml"));
//				AnchorPane page = (AnchorPane) loader.load();
//				Scene scene = new Scene(page);
//				MainApp.primaryStage.setScene(scene);
//				MainApp.primaryStage.show();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//	    	
//		});
		
		
		
	
	}

	private List<Demande> parseUserList() {
		
		Context context;
		List<Demande> result = new ArrayList<>();
		try {
			context = new InitialContext();
			DemandeCINServiceRemote demandeCinService = (DemandeCINServiceRemote) context
					.lookup("e-gov-ear/e-gov-ejb/DemandeCINService!gov.esprit.service.cin.DemandeCINServiceRemote");
			result = demandeCinService.findAll();
		
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return result;
		
		
	}
}
