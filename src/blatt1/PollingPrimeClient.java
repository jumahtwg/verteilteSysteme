package blatt1;

import java.net.InetSocketAddress;
import java.net.SocketAddress;




public class PollingPrimeClient {
    private final long number;
    
    PollingPrimeClient(long number) {
	this.number = number;
    }
    
    public void run() {
	ClientEndpoint endpoint = new ClientEndpoint();
	SocketAddress server = new InetSocketAddress("localhost", 4711);
		
	endpoint.send(server, number);
	Boolean isPrime;
	System.out.print("Die Zahl " + number + " ist ");
	while((isPrime = endpoint.nonBlockingReceive()) == null) {
		System.out.print(".");
		try {
			Thread.sleep(1000);
			continue;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
	
	
	}
	if (isPrime == true) {
		System.out.println("eine Primzahl");
	}else{
	System.out.println("keine Primzahl");
	}

    }
    
    public static void main(String[] args) {
	for ( long i = 1000000000000000000L; i < 1000000000000000010L; i++ ) {
	    new PollingPrimeClient(i).run();
	}
    }
        
    
}