
package io.uploader.drive.gui.dlg;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AboutDialog extends AbstractDialog {

	public AboutDialog (Stage owner) throws IOException {
		super (owner) ;
		
		initStyle(StageStyle.UTILITY);
		setTitle("About");
		initOwner(owner);
		initModality (Modality.WINDOW_MODAL );
		
		final FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AboutView.fxml"));
		final Parent parent = (Parent) loader.load();

		setMinHeight(300.0);
		setMinWidth(350.0);
		
		setMaxHeight(400.0);
		setMaxWidth(450.0);
	
		setHeight(300.0);
		setWidth(350.0);
		
		setScene(new Scene(parent));
	}
}
