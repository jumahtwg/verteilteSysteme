package blatt6;

import java.io.IOException;

import forum.framework.ForumClient;

public class RmiForumClient {
	
	public static void main(String[] args) throws IOException, Exception {
		new ForumClient(new RmiModelForwarder()).register();
		new ForumClient(new RmiModelForwarder()).register();
//		new ForumClient(new RmiModelForwarder()).register();
	}
}
