package blatt5;

import java.io.IOException;
import java.util.Map;

import forum.framework.IForumView;
import forum.framework.Position;

public class LocalViewForwarder implements IForumView {

	private LocalViewReceiver receiver;
	
	public LocalViewForwarder() {
		this.receiver = new LocalViewReceiver();
	}
	
	@Override
	public void notifyView(Map<String, Position> arg0) throws IOException {
		this.receiver.notifyView(arg0);
	}
}
