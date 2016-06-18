
package io.uploader.drive.task;

import io.uploader.drive.drive.DriveOperations.HasStatusReporter;
import io.uploader.drive.drive.DriveOperations.StopRequester;

import java.util.concurrent.Callable;

public abstract class DriveTask<T> implements Callable<T> {
	
	private final HasStatusReporter statusReporter ; 
	private final StopRequester stopRequester ; 
	
	public abstract boolean isSameTaskAs (DriveTask<T> task) ;
	
	public DriveTask (StopRequester stopRequester, HasStatusReporter statusReporter) {
		super () ;
		this.statusReporter = statusReporter ;
		this.stopRequester = stopRequester ;
	}

	public HasStatusReporter getStatusReporter() {
		return statusReporter;
	}

	public StopRequester getStopRequester() {
		return stopRequester;
	}
}
