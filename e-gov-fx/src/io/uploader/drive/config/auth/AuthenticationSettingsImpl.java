
package io.uploader.drive.config.auth;

import java.io.IOException;
import java.io.InputStream;

import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;

public class AuthenticationSettingsImpl implements HasAuthenticationSettings {

	private final GoogleClientSecrets clientSecrets ;
	
	public AuthenticationSettingsImpl(GoogleClientSecrets clientSecrets) {
		super();
		this.clientSecrets = clientSecrets;		
	}


	public static InputStream getClientSecretJson() throws IOException {
		InputStream in = AuthenticationSettingsImpl.class.getResourceAsStream("/client_secrets.json") ;
		if (in == null) {
			in = AuthenticationSettingsImpl.class.getResourceAsStream("/client_secrets_ori.json") ;
		}
		return in ;
	}
	
	
	@Override
	public synchronized String getClientId() {
		return clientSecrets.getDetails().getClientId() ;
	}

	
	@Override
	public synchronized String getClientSecret() {
		return clientSecrets.getDetails().getClientSecret() ;
	}
	

	@Override
	public String getCallBackUrl() {
		return clientSecrets.getDetails().getRedirectUris().get(0) ;
	}
}
