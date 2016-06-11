package eg.application.view;



import java.io.IOException;

import eg.application.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;


/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 * 
 * @author Haj
 */
public class RootLayoutController {

    // Reference to the main application
    private MainApp mainApp;

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Creates an empty address book.
     */
    @FXML
    private void handleNew() {
        mainApp.getPersonData().clear();
    }




    /**
     * Opens an about dialog.
     */
    @FXML
    private void handleAbout() {
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
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
    
    /**
     * Opens the birthday statistics.
     */
    @FXML
    private void handleShowBirthdayStatistics() {
      mainApp.showBirthdayStatistics();
    }
    @FXML
    private void handleCreateNewChild() {
        mainApp.CreateNewChild();
      }
}