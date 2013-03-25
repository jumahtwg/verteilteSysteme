package blatt1;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

import javax.swing.JOptionPane;




public class AsyncPrimeClient {
    private final long number;
    
    AsyncPrimeClient(long number) {
	this.number = number;
    }
    
    public void run() throws InterruptedException {
		ClientEndpoint endpoint = new ClientEndpoint();
		SocketAddress server = new InetSocketAddress("localhost", 4711);
			
		endpoint.send(server, number);
	
		ExtThread waitT = new ExtThread(endpoint);
		waitT.start();
		Thread.sleep(500);
	
		System.out.print("Die Zahl " + number + " ist " );
		while(waitT.threadAnswer == null) {
			System.out.print(".");
			Thread.sleep(1000);
			continue;
		}
		if(waitT.threadAnswer == true) {
			System.out.println("eine Primzahl");
		} else {
			System.out.println("keine Primzahl");
		}

    }
    
    public static void main(String[] args) {
        int eingabe = JOptionPane.showConfirmDialog(null,
                "Geben Sie Ihr Einverständnis?",
                "Einverständnis",
                JOptionPane.YES_NO_CANCEL_OPTION);
        
    	for ( long i = 1000000000000000000L; i < 1000000000000000010L; i++ ) {
	    try {
			new AsyncPrimeClient(i).run();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    }
        
    
}
