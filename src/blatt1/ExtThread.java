package blatt1;

public class ExtThread extends Thread {
	
	private ClientEndpoint endpoint;
	
	ExtThread(ClientEndpoint endpoint) {
		this.endpoint = endpoint;
	}
	
	public Boolean threadAnswer = null;
	
	public void run() {
		if (endpoint.blockingReceive() == false) {
			threadAnswer = false;
		} else {
			threadAnswer = true;
		}

	}

}
