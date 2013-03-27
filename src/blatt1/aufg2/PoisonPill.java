package blatt1.aufg2;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Scanner;

import blatt1.ClientEndpoint;

public class PoisonPill implements Runnable {
	private Scanner scanner;
	private int input;
	private SocketAddress server;
	private ClientEndpoint endpoint;

	public PoisonPill() {
		scanner = new Scanner(System.in);
		endpoint = new ClientEndpoint();
		server = new InetSocketAddress("localhost", 4711);
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(Thread.currentThread() + "von Poison Pill");
			System.out.println("Server beenden: 1 + ENTER");
			input = scanner.nextInt();
			if (input == 1) {
				endpoint.send(server, 0);
				break;
			}
		}
	}
}