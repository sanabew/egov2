
package io.uploader.drive.config.proxy;

import org.apache.http.client.CredentialsProvider;

public interface HasProxySettings {
	public boolean isActive () ;
	public String getProtocol () ;
	public String getUsername () ;
	public String getPassword () ;
	public String getHost () ;
	public int getPort () ;
	public CredentialsProvider getCredentialsProvider () ;
}
