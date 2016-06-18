

package io.uploader.drive.auth;

import io.uploader.drive.auth.webbrowser.Browser;
import io.uploader.drive.auth.webbrowser.SimpleBrowserImpl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Platform;
import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.java6.auth.oauth2.VerificationCodeReceiver;
import com.google.common.base.Preconditions;

// https://code.google.com/p/google-oauth-java-client/source/browse/google-oauth-client-java6/src/main/java/com/google/api/client/extensions/java6/auth/oauth2/AuthorizationCodeInstalledApp.java?r=2c0510b314d24701810aa277f5d803a4368b2e20

public class DriveUploaderAuthorizationCodeInstalledApp extends
		AuthorizationCodeInstalledApp {
	
	@SuppressWarnings("unused")
	final private static Logger logger = LoggerFactory.getLogger(SimpleBrowserImpl.class);
	
	private final Browser browser ;

	public DriveUploaderAuthorizationCodeInstalledApp(
			AuthorizationCodeFlow flow, VerificationCodeReceiver receiver, Browser browser) {
		super(flow, receiver);
		Preconditions.checkNotNull(browser) ;
		this.browser = browser ;
	}


	@Override
	protected void onAuthorization(AuthorizationCodeRequestUrl authorizationUrl)
			throws IOException {

		final String url = authorizationUrl.build() ;
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				logger.info("Authorization url: " + url);
				browser.show();
				browser.goTo(url) ;
			}
		});
	}
}
