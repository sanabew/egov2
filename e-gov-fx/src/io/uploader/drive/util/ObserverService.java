
package io.uploader.drive.util;

import io.uploader.drive.AppEvent;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.concurrent.Service;

public abstract class ObserverService <T> extends Service <T> implements Observer {

	private static final Logger logger = LoggerFactory.getLogger(ObserverService.class);
	
	public ObserverService () {
		this (5) ;
	}
	
	public ObserverService (int threadPoolSize) {
		super () ;
		if (threadPoolSize <= 0) {
			throw new IllegalArgumentException () ;
		}
		setExecutor(Executors.newFixedThreadPool(threadPoolSize)) ;
	}
	
	@Override
	public void update(Observable o, Object arg) {

		if (arg != null) {
			if (arg instanceof AppEvent.Event) {
				if (((AppEvent.Event)arg) == AppEvent.Event.EXIT)
				{
					logger.info("Exit Event") ;
					cancel() ;
					Executor exe = getExecutor() ;
					if (exe != null && exe instanceof ExecutorService) {
						ThreadUtils.shutdownExecutor((ExecutorService) exe) ;
					}
				}
			}
		}
	}
}
