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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.naming.Context;
import javax.naming.InitialContext;

import eg.application.util.DateUtil;

/**
 * Dialog to edit details of a person.
 * 
 * @author Haj
 */
public class PersonEditDialogController {

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

	private Stage dialogStage;
	private Person person;
	private boolean okClicked = false;

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
	}

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
	public void setPerson(Person person) {
		this.person = person;

		firstNameField.setText(person.getFirstName());
		lastNameField.setText(person.getLastName());

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
				           
				Person user = new Person();
				user.setFirstName(firstNameField.getText());
				user.setLastName(lastNameField.getText());
				user.setLogin(login.getText());
				user.setMotDePasse(passwd.getText());
				user.setFonction(role.getValue().toString());
				proxy.addUser(user);
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