package eg.application;

import java.net.URI;
import javax.websocket.ContainerProvider;

import javax.websocket.WebSocketContainer;

import javafx.scene.control.TableView;

public class testNotification {

	public static void main(String[] args) {
		try {
			NotifClient test = new NotifClient();
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			container.connectToServer(test, new URI("ws://localhost:8080/e-gov-web/notif"));
			test.sendNotification("hi sana!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
