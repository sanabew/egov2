package eg.application;


import javax.websocket.MessageHandler;

import javafx.scene.control.TextArea;


public class NotifMessageHandler implements MessageHandler.Whole<String>{
	TextArea notif;
	
	

	public NotifMessageHandler(TextArea notif) {
		super();
		this.notif = notif;
	}



	@Override
	public void onMessage(String message) {
		notif.appendText(message+"\n");
		notif.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
		
	}

}
