package eg.application.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import javafx.stage.Stage;
import gov.esprit.domain.Citoyen;
import gov.esprit.domain.Person;
import gov.esprit.service.person.PersonServiceRemote;
import javafx.scene.control.Button;

import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.awt.Button;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javafx.stage.*;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.image.ImageView;
import javax.naming.Context;
import javax.naming.InitialContext;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import eg.application.MainApp;
import eg.application.util.DateUtil;

/**
 * Dialog to edit details of a person.
 * 
 * @author Haj
 */
public class PersonEditDialogController  {

	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField login;
	@FXML
	private TextField passwd;

	@FXML
	private ChoiceBox role;
	@FXML
	private Button BtnUplode;
	@FXML
	private ImageView ImgView;
	private Stage dialogStage;
	private Person person;
	private boolean isEdit;
	private boolean okClicked = false;
    private Path target;
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	

	/**
	 * Sets the stage of this dialog.
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;

		// Set the dialog icon.
		this.dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));
	}

	/**
	 * Sets the person to be edited in the dialog.
	 * 
	 * @param person
	 */
	public void setPerson(Person person, boolean isEdit) {
		this.person = person;

		firstNameField.setText(person.getFirstName());
		lastNameField.setText(person.getLastName());
		Image image = new Image("file:build/dist/resources/images/"+person.getPhoto());
		 ImgView.setImage(image);
		 this.isEdit= isEdit;

	}

	/**
	 * Returns true if the user clicked OK, false otherwise.
	 * 
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Called when the user clicks ok.
	 */
	
	private void UplodeFile (ActionEvent event)
	{
		System.out.println("test uplode");
	}
	
	@FXML
	private void initialize() {
		//  this.ImgView  = new ImageView(new Image("file:../../../../build/dist/resources/images/address_book_32.png"));
		BtnUplode.setOnAction((event)->{
			FileChooser fc = new FileChooser();
			fc.setTitle("choisissez une photo");
			//fc.getInitialDirectory(new File("")
			fc.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("All Images", "*.*"),
					new FileChooser.ExtensionFilter("JPG", "*.jpg"),
					new FileChooser.ExtensionFilter("GIF", "*.gif"),
					new FileChooser.ExtensionFilter("BMP","*.bmp"),
					new FileChooser.ExtensionFilter("PNG", "*.png")
					);
			
			File selectedFile= fc.showOpenDialog(null);
			if(selectedFile !=null)
			{
				//ImgView.setImage(selectedFile.toURI().toURL());
				System.out.println(selectedFile.getAbsolutePath());
			//	String path ="C:\\javaEE\\"+selectedFile.getName();
				String fileName = selectedFile.getName();
				
				String currentDir = System.getProperty("user.dir");
				String path =currentDir+"/build/dist/resources/images";
				  target = Paths.get(path, fileName);
				
				  
			      
				  try {
				if(	Files.notExists(target))
				{
					Files.copy(selectedFile.toPath(),target );
				}
					//System.out.println(target.toString());
				
					Image image = new Image("file:build/dist/resources/images/"+target.getFileName());
					 ImgView.setImage(image);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
						//"file:resources/images/"+selectedFile.getName();
			//	copy(selectedFile.getAbsolutePath(), path);
				//SaveFile("file:resources/images/", selectedFile);
				// Image image = new Image(selectedFile.getAbsolutePath());
				// ImgView.setImage(image);
				
			}
			else
				System.out.println("File not valide");
		});
	}
	
	public void copy(String from, String to) {
	    FileReader fr = null;
	    FileWriter fw = null;
	    try {
	        fr = new FileReader(from);
	        fw = new FileWriter(to);
	        int c = fr.read();
	        while(c!=-1) {
	            fw.write(c);
	            c = fr.read();
	        }
	    } catch(IOException e) {
	        e.printStackTrace();
	    } finally {
	        close(fr);
	        close(fw);
	    }
	}
	public static void close(Closeable stream) {
	    try {
	        if (stream != null) {
	            stream.close();
	        }
	    } catch(IOException e) {
	        //...
	    }
	}
	 
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			person.setFirstName(firstNameField.getText());
			person.setLastName(lastNameField.getText());

			System.out.println("oki" + firstNameField.getText());
			System.out.println("oki" + lastNameField.getText());
			System.out.println("oki" + login.getText());
			System.out.println("oki" + passwd.getText());
			System.out.println("oki" + role.getValue());

			Context context;
			try {
				context = new InitialContext();
				PersonServiceRemote proxy = (PersonServiceRemote) context
						.lookup("e-gov-ear/e-gov-ejb/PersonService!gov.esprit.service.person.PersonServiceRemote");
				if(isEdit)
				{
					person.setFirstName(firstNameField.getText());
					person.setLastName(lastNameField.getText());
					person.setLogin(login.getText());
					person.setMotDePasse(passwd.getText());
					person.setFonction(role.getValue().toString());
					person.setPhoto(target.getFileName().toString());
					proxy.updateUser(person);
				}
				else
				{
				Person user = new Person();
				user.setFirstName(firstNameField.getText());
				user.setLastName(lastNameField.getText());
				user.setLogin(login.getText());
				user.setMotDePasse(passwd.getText());
				user.setFonction(role.getValue().toString());
				user.setPhoto(target.getFileName().toString());
				proxy.addUser(user);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		okClicked = true;
		dialogStage.close();
		}
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	/**
	 * Validates the user input in the text fields.
	 * 
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
			errorMessage += "No valid first name!\n";
		}
		if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
			errorMessage += "No valid last name!\n";
		}
		if (login.getText() == null || login.getText().length() == 0) {
			errorMessage += "No valid Login!\n";
		}

		if (passwd.getText() == null || passwd.getText().length() == 0) {
			errorMessage += "No valid Password!\n";
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}

	

}