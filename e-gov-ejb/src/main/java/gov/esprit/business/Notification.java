package gov.esprit.business;

public class Notification {
	
	private String content;

	public Notification(String content) {
		this.content = content;
	}

	public Notification() {
		
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Notification [content=" + content + "]";
	}
	
	

}
