package blatt1.aufg2;

import java.net.SocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import blatt1.ServerEndpoint;

public class ThreadPooledPrimeServer {
	private ExecutorService executor;
	private volatile ServerEndpoint endpoint;
	private volatile boolean stopServer = false;

	// inner class
	public class Worker implements Runnable {
		private long number;
		private SocketAddress sender;

		public Worker(long number, SocketAddress sender) {
			this.sender = sender;
			this.number = number;
		}

		public void run() {
			boolean prime = isPrime(number);
			endpoint.send(sender, prime);
		}
	}

	// end inner class

	// constructor
	public ThreadPooledPrimeServer(int number) {
		executor = Executors.newFixedThreadPool(number);
		endpoint = new ServerEndpoint();
	}

	public void setStopServer() {
		this.stopServer = true;
	}


	public void run() {
		System.out.println(Thread.currentThread() + "von Thread Pool Server");
		System.out.println("ThreadPooledPrimeServer up and running...");

		executor.execute(new MessageDiaolgThreadPooledServer(this));
		executor.execute(new PoisonPill());
		// Message Dialog
		while (stopServer == false) {
			// Muss man im MainThread machen
			ServerEndpoint.Request request = endpoint.blockingReceive();

			// Poison-Pill
			if (request.getNumber() == 0) {
				break;
			}

			executor.execute(new Worker(request.getNumber(), request
					.getSender()));
		}
		executor.shutdownNow();
		System.out.println("Shutdown");
	}

	private boolean isPrime(long number) {
		for (long i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		new ThreadPooledPrimeServer(3).run();
	}
}
