
package io.uploader.drive.gui.factory;

import java.util.Observer;
import com.google.common.util.concurrent.ListeningExecutorService;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
import io.uploader.drive.drive.DriveDirectory;
import io.uploader.drive.drive.DriveOperations;
import io.uploader.drive.drive.DriveOperations.HasStatusReporter;
import io.uploader.drive.drive.DriveOperations.StopRequester;
import io.uploader.drive.task.DriveTask;

public interface DriveTaskFactory extends Observer {
	public DriveTask<DriveOperations.OperationResult> buildUploadDirectoryDriveTask(
			DriveDirectory driveDirectory, String srcDirectory, boolean overwrite,
			StopRequester stopRequester, HasStatusReporter statusReporter);
	
	public HasStatusReporter buildStatusReporter(DoubleProperty total,
			DoubleProperty current, StringProperty status);

	public ListeningExecutorService getExecutor () ;

	public StopRequester buildStopRequester(BooleanProperty stopRequested);
}
