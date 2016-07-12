package eg.application.view;

import eg.application.MainApp;
import eg.application.MapApp;
import eg.application.NotifClient;
import gov.esprit.service.abonnement.AbonnementServiceRemote;
import io.uploader.drive.DriveUploader;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.websocket.DeploymentException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;


public class DashbordController  {

	@FXML
	private TextField password;
	@FXML
	private Button btn_mon_profil;
	@FXML
	private Button btn_fonctionalite_three;
	@FXML
	private Button btn_fonctionalite_tow;
	@FXML
	private Button btn_fonctionalite_one;
	@FXML
	private Button btn_fonctionalite_four;
	@FXML
	private Button btn_logout;
	@FXML
	private Button gestionuser;
	@FXML
	private TextArea output_textarea;
	@FXML
	private Button send;
	@FXML
	private TextField saisie_notif;


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
	public DashbordController() throws NamingException {

	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 * @throws IOException 
	 * @throws DeploymentException 
	 * @throws URISyntaxException 
	 */
	@FXML
	private void initialize() throws URISyntaxException, DeploymentException, IOException {
		
		/*
		output_textarea.appendText("\n Bienvenu \n");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy   H:M");
		String laDateDuJour = sdf.format(new java.util.Date());
		output_textarea.appendText("Ajourd'hui le :" + laDateDuJour);
		}*/
	
	/*	final NotifClient notifclien = new NotifClient(output_textarea);
        
		output_textarea.setEditable(false);
		
		output_textarea.setOnMouseClicked(event->{
			output_textarea.setStyle("-fx-border-color: black ; -fx-border-width: 2px ;");
		});*/
		
		btn_logout.setOnAction((event) -> {
			Alert alert = new Alert(AlertType.ERROR);
            Window dialogStage = null;
			alert.initOwner(dialogStage);
            alert.setTitle("Logout");
            alert.setHeaderText("Merci Pour Votre Connexion");
            alert.setContentText("à bientot");
            
            alert.showAndWait();
			
			try {
				MainApp.primaryStage.setTitle("Espace User");
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/FormAuth.fxml"));
				AnchorPane page = (AnchorPane) loader.load();
				Scene scene = new Scene(page);
				MainApp.primaryStage.setScene(scene);
				MainApp.primaryStage.show();

			} catch (IOException e) {
				e.printStackTrace();
			}

		});

		btn_fonctionalite_one.setOnAction((event) -> {

			try {
				MainApp.primaryStage.setTitle("Espace User");
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/FonctionaliteOne.fxml"));
				AnchorPane page = (AnchorPane) loader.load();
				Scene scene = new Scene(page);
				MainApp.primaryStage.setScene(scene);
				MainApp.primaryStage.show();

			} catch (IOException e) {
				e.printStackTrace();
			}

		});
		gestionuser.setOnAction((event) -> {

			MainApp.primaryStage.setTitle("Login");
			// Set the application icon.
			MainApp.primaryStage.getIcons().add(new Image("file:resources/images/address_book_32.png"));
			MainApp mainApp = new MainApp();
			mainApp.initRootLayout();
			mainApp.showPersonOverview();

		});
		btn_fonctionalite_tow.setOnAction((event) -> {

			try {
				MainApp.primaryStage.setTitle("Espace Ministère de l'intérieur");
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/FonctionaliteTwo.fxml"));
				AnchorPane page = (AnchorPane) loader.load();
				Scene scene = new Scene(page);
				MainApp.primaryStage.setScene(scene);
				MainApp.primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		});
		
		btn_fonctionalite_three.setOnAction((event) -> {

			try {
				MainApp.primaryStage.setTitle("Espace Poste");
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/FonctionaliteThree.fxml"));
				AnchorPane page = (AnchorPane) loader.load();
				Scene scene = new Scene(page);
				MainApp.primaryStage.setScene(scene);
				MainApp.primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		});
		btn_fonctionalite_four.setOnAction((event) -> {

			try {
				MainApp.primaryStage.setTitle("Espace Transport");
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/FonctionaliteFour.fxml"));
				AnchorPane page = (AnchorPane) loader.load();
				Scene scene = new Scene(page);
				MainApp.primaryStage.setScene(scene);
				MainApp.primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		});
		btn_logout.setOnAction((event) -> {
			Alert alert = new Alert(AlertType.ERROR);
            Window dialogStage = null;
			alert.initOwner(dialogStage);
            alert.setTitle("Logout");
            alert.setHeaderText("Merci Pour Votre Connexion");
            alert.setContentText("à bientot");
            
            alert.showAndWait();
			
			try {
				MainApp.primaryStage.setTitle("Espace User");
				FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/FormAuth.fxml"));
				AnchorPane page = (AnchorPane) loader.load();
				Scene scene = new Scene(page);
				MainApp.primaryStage.setScene(scene);
				MainApp.primaryStage.show();

			} catch (IOException e) {
				e.printStackTrace();
			}

		});
		
		send.setOnAction((event) -> {
		
			
		/*		try {
					notifclien.sendNotification(saisie_notif.getText());
					
				} catch (Exception e) {
					e.printStackTrace();
				}*/

			
		});

		}

}
