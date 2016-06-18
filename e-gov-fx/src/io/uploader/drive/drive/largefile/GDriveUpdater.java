
package io.uploader.drive.drive.largefile;

import java.io.IOException;

import io.uploader.drive.config.HasConfiguration;
import io.uploader.drive.drive.DriveUtils.HasId;
import io.uploader.drive.drive.DriveUtils.HasMimeType;
import io.uploader.drive.util.FileUtils.InputStreamProgressFilter.StreamProgressCallback;

public class GDriveUpdater extends GDriveUpload {

	public GDriveUpdater(HasConfiguration config, HasId fileId,
			HasMimeType mimeType, String filename,
			StreamProgressCallback progressCallback) {
		super(config, fileId, mimeType, filename, progressCallback);
	}
	
	public String updateFile() throws IOException {
		return uploadFile (true) ;
	}
}
