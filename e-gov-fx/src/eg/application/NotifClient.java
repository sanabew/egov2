package eg.application;



import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javafx.scene.control.TextArea;



@ClientEndpoint
public class NotifClient extends Endpoint{

  TextArea table;
  private Session session;
	public NotifClient(TextArea table) throws URISyntaxException, DeploymentException, IOException {
		URI uRI = new URI("ws://localhost:8080/e-gov-web/notif");
		ContainerProvider.getWebSocketContainer().connectToServer(this, uRI);
		session.addMessageHandler(new NotifMessageHandler(table));
	}
	
	
	
	
	


	public NotifClient() {
	
	}







	public void sendNotification(String notification){
		
		try {
			System.out.println("text to send : "+notification);
			this.session.getBasicRemote().sendText(notification);
			
		} catch (Exception e) {
			System.out.println("sending exception");
			e.printStackTrace();
		}
	}
	
	 @OnMessage
	    public void onMessage(String message) {
	        System.out.println("received  : "+message);
	       
	    }

	       
	    @OnOpen
	    public void onOpen(Session s, EndpointConfig ec){
	    this.session=s;
	    	
	    }
	    @OnClose
	    public void closedConnection(Session session, CloseReason closeReason) {
	    	 
	        /* Remove this connection from the queue */
	        this.session=null;
	        //logger.log(Level.INFO, "Connection closed.");
	        System.out.println("session closed: "+closeReason.getCloseCode());
	    }
	    
}
