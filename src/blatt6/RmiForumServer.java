package blatt6;

import forum.framework.ForumServer;

public class RmiForumServer {

	public static void main(String[] args) throws Exception {
		new ForumServer(new RmiModelReceiver()).run();
	}

}
