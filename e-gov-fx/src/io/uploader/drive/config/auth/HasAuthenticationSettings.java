
package io.uploader.drive.config.auth;

public interface HasAuthenticationSettings {
	public String getClientId () ;
	public String getClientSecret () ;
	public String getCallBackUrl () ;
}
