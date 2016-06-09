package eg.application.view;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.Table;
import javax.swing.text.TabableView;

import eg.application.MainApp;
import gov.esprit.domain.Transaction;
import gov.esprit.enums.TypeTransacrion;
import gov.esprit.service.poste.PosteServiceRemote;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ExtraireComptePostalController {
	@FXML
	private Button retour;
	@FXML
	private TextField cin;
	@FXML
	private TextField num_compte;
	@FXML
	private TextField solde;
	@FXML
	private TableView table;
	@FXML
	private TableColumn date;
	@FXML
	private TableColumn debit;
	@FXML
	private TableColumn credit;
	@FXML
	private Button btn_valider;
	
	
	public  class Data {
		 
        private Date datedata;
        private float  debitdata;
        private float creditdata;
 
        private Data (Date date, float debitdata, float creditdata) {
            this.datedata = date;
            this.debitdata = debitdata;
            this.creditdata = creditdata;
        }
        private Data(){
        	
        }
		public Date getDatedata() {
			return datedata;
		}
		public void setDatedata(Date datedata) {
			this.datedata = datedata;
		}
		public float getDebitdata() {
			return debitdata;
		}
		public void setDebitdata(float debitdata) {
			this.debitdata = debitdata;
		}
		public float getCreditdata() {
			return creditdata;
		}
		public void setCreditdata(float creditdata) {
			this.creditdata = creditdata;
		}
        
        
	}
    // Reference to the main application.
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */

	/**
	 * The constructor (is called before the initialize()-method).
	 * @throws NamingException 
	 */
	public ExtraireComptePostalController() throws NamingException {

	}
	
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */

	
	
	@FXML
	private void initialize() {
		
		
		
		btn_valider.setOnAction((event)->{
			
			List<Transaction> releve = new ArrayList<Transaction>() ;
			try{
			Context context = new InitialContext();
			PosteServiceRemote posteservice = (PosteServiceRemote) context
					.lookup("e-gov-ear/e-gov-ejb/PosteService!gov.esprit.service.poste.PosteServiceRemote");
			releve = posteservice.extraireReleve(Integer.parseInt(num_compte.getText()), cin.getText());
			
			for(Transaction t : releve){
				Data data = new Data();
				data.setDatedata(t.getDate());
				if(t.getType()==TypeTransacrion.CREDIT){data.setCreditdata(t.getMontant());}
				if(t.getType()==TypeTransacrion.DEBIT){data.setDebitdata(t.getMontant());}
				
			}
			
			}catch(Exception e){
				e.printStackTrace();
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
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
		});
		
		
		
	
	}
}
