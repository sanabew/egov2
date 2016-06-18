
package io.uploader.drive.util;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

public class ThreadUtils {

	private static final Logger logger = LoggerFactory.getLogger(ThreadUtils.class);
	
	private ThreadUtils () { super () ; throw new IllegalStateException () ; }
	
	public static void shutdownExecutor(ExecutorService executor) {
		Preconditions.checkNotNull(executor) ;
		logger.info("Shutdown executors") ;
		executor.shutdown() ;
		try {
			executor.awaitTermination(2, TimeUnit.SECONDS) ;
		} catch (InterruptedException e) {
			logger.error("Error occurred while awaiting threads termination", e) ;
		}
		List<Runnable> notStarted = executor.shutdownNow() ;
		if (!notStarted.isEmpty()) {
			logger.info("Unstarted tasks stopped (" + notStarted.size() + " tasks in total)") ;
		}
	}
}
