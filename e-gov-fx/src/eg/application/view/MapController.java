package eg.application.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.Initializable;

public class MapController implements Initializable {

	 private Application app;
	  private static Process scriptProcess;
	  
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	  public void setApp(Application a) {
		    app = a;
		  }

		  public static Process getScriptProcess() {
		    return scriptProcess;
		  }

}
