package blatt5;

import java.io.IOException;
import java.util.Map;

import forum.framework.ForumView;
import forum.framework.IForumView;
import forum.framework.Position;


// ??? brauch ich hier überhaupt Runnalbe, ist ja bei jedem Client nur ein Thread ???
public class LocalViewReceiver implements IForumView, Runnable {

	private ForumView view;
	
	public LocalViewReceiver() {
		this.view = new ForumView();
	}

	@Override
	public void run() {	}

	@Override
	public void notifyView(Map<String, Position> arg0) throws IOException {
		this.view.notifyView(arg0);
	}

}
