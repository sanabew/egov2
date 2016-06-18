
package io.uploader.drive.drive.largefile;

import java.io.IOException;

import io.uploader.drive.config.HasConfiguration;
import io.uploader.drive.drive.DriveUtils.HasDescription;
import io.uploader.drive.drive.DriveUtils.HasId;
import io.uploader.drive.drive.DriveUtils.HasMimeType;
import io.uploader.drive.util.FileUtils.InputStreamProgressFilter.StreamProgressCallback;

public class GDriveUploader extends GDriveUpload {

	public GDriveUploader(HasConfiguration config, String title,
			HasDescription description, HasId parentId, HasMimeType mimeType,
			String filename, StreamProgressCallback progressCallback) {
		super(config, title, description, parentId, mimeType, filename,
				progressCallback);
	}

	public String uploadFile() throws IOException {
		return uploadFile (false) ;
	}
}
