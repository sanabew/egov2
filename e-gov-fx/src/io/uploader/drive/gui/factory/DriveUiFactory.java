
package io.uploader.drive.gui.factory;

import com.google.api.services.drive.model.File;

import javafx.stage.Stage;
import io.uploader.drive.gui.dlg.DriveDirectoryChooser;
import io.uploader.drive.util.Callback;

public interface DriveUiFactory {
	public DriveDirectoryChooser buildDriveDirectoryChooser (Stage owner, Callback<File> callback) ;
}
