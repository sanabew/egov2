package main.webapp;


import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;





@ServerEndpoint(value="/notif")
@Startup
@Singleton
public class NotifServer {
	
	
	public static Set<Session> peers = null; 
	static {
		peers = Collections.synchronizedSet(new HashSet());
	}
	
	@OnOpen
    public void initOpen(Session session) {
		peers.add(session);
    }
 
    @OnClose
    public void closeWebSocket(Session session) {
        peers.remove(session);
    }
    
    @OnMessage
	public void onMessage(String message) {
		try {

			for (Session peer : peers) {
				peer.getBasicRemote().sendText(message);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	

}
