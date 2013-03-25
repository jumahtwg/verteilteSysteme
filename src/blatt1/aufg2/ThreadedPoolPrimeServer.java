package blatt1.aufg2;

import java.awt.BorderLayout;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


import blatt1.ServerEndpoint;



public class ThreadedPoolPrimeServer {
	ExecutorService executor = Executors.newFixedThreadPool(10);
	private final ServerEndpoint endpoint;

	
    ThreadedPoolPrimeServer() {
	endpoint = new ServerEndpoint();
    }

    private boolean isPrime(long number) {
	for (long i = 2; i <= Math.sqrt(number); i++) {
	    if (number % i == 0) {
		return false;
	    }
	}
	return true;
    }
    
    
    while (true) {
	    executor.execute(new Runnable() {
		    public void run() {
		    	System.out.println("Serial PrimeServer up and running...");
			    ServerEndpoint.Request request = endpoint.blockingReceive();
			    boolean prime = isPrime(request.getNumber());
			    endpoint.send(request.getSender(), prime);
		    
		    }
	    });
    }
    executor.shutdown();
    
    public static void main(String[] args) {
	new ThreadedPoolPrimeServer().run();
    JOptionPane.showMessageDialog(null,
            "Sie müssen eine Ganzzahl eingeben",
            "Eine Nachricht",                                       
            JOptionPane.WARNING_MESSAGE);
    }

}
