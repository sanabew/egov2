
package io.uploader.drive.util;

public interface Callback <T> {
	public void onSuccess (T result) ;
	public void onFailure (Throwable cause) ;
}
