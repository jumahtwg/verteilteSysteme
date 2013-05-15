package blatt5;

import java.io.IOException;

import forum.framework.ForumClient;
import forum.framework.ForumServer;

public class LocalForumSetup {
	public static void main(String[] args) throws IOException, Exception {
		new ForumServer(LocalModelReceiver.getInstance());
//		try {
			new ForumClient(new LocalModelForwarder()).register();
			new ForumClient(new LocalModelForwarder()).register();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
