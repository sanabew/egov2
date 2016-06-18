

package io.uploader.drive.drive.largefile;

import io.uploader.drive.config.proxy.HasProxySettings;

import org.apache.http.HttpHost;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.api.client.repackaged.com.google.common.base.Preconditions;

public class HttpClientUtils {

	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);
	
    public static CloseableHttpClient getHttpClient (HasProxySettings proxySetting) {
    	// http://hc.apache.org/httpcomponents-client-ga/tutorial/html/connmgmt.html#d5e475
    	
    	CloseableHttpClient httpclient = null ;
    	if (proxySetting != null && proxySetting.isActive()) {
    		logger.info("Set the http proxy (" + proxySetting.getHost() + ":" + proxySetting.getPort() + ")") ;
    		CredentialsProvider credsProvider = Preconditions.checkNotNull(proxySetting.getCredentialsProvider()) ;
        	HttpHost proxy = new HttpHost(proxySetting.getHost(), proxySetting.getPort());
        	DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
        	httpclient = HttpClients.custom()
        	        .setRoutePlanner(routePlanner).setDefaultCredentialsProvider(credsProvider)
        	        .build();
    	} else {
    		httpclient = HttpClients.createDefault();
    	}
    	return httpclient ;
    }
}
