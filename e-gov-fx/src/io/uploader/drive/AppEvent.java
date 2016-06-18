
package io.uploader.drive;

import java.util.Observable;

public class AppEvent extends Observable {

	public static enum Event {
		EXIT,
	}
	
	public void exit () {
		setChanged() ;
		notifyObservers(Event.EXIT) ;
	}
}
