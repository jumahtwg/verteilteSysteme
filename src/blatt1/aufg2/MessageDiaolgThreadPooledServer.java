package blatt1.aufg2;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MessageDiaolgThreadPooledServer extends JFrame implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4709494608963154841L;
	private ThreadPooledPrimeServer server;

	public MessageDiaolgThreadPooledServer(ThreadPooledPrimeServer server) {
		this.server = server;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread() + "von MessageDialog");
		JOptionPane.showMessageDialog(this, "Press OK button to stop server");
		server.setStopServer();
	}
}