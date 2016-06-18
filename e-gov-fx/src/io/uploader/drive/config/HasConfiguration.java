
package io.uploader.drive.config;

import com.google.api.client.auth.oauth2.Credential;

import io.uploader.drive.config.auth.HasAuthenticationSettings;
import io.uploader.drive.config.proxy.HasProxySettings;
import io.uploader.drive.config.proxy.Proxy;

public interface HasConfiguration {
	public String getAppName () ;
	public String getAppVersion () ;
	public String getDataStoreDirectory () ;
	public HasProxySettings getHttpProxySettings () ;
	public HasProxySettings getHttpsProxySettings () ;
	public void updateProxy (Proxy newProxy) ;
	public String getTmpDirectory() ;
	public Credential getCredential () ;
	public HasAuthenticationSettings getAuthenticationSettings () ;
}
