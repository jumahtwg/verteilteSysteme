package blatt1.aufg2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import blatt1.ServerEndpoint;



public class ThreadedPoolPrimeServer {

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
    ExecutorService executor = Executors.newFixedThreadPool(10);
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
    }

}
