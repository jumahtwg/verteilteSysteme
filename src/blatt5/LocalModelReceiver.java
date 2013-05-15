package blatt5;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;

import forum.framework.ForumModel;
import forum.framework.IForumModel;
import forum.framework.IForumView;

//Class is singleton
public class LocalModelReceiver implements IForumModel, Runnable {

	private static LocalModelReceiver instance = new LocalModelReceiver();
	
	private LocalModelReceiver() { }
	
	public static LocalModelReceiver getInstance() {	
		return instance;
	}
	
	@Override
	// isn't used in local implementation
	public void run() {	}
	
	@Override
	public void deregisterView(String arg0) throws NotBoundException,
			IOException {
		ForumModel.INSTANCE.deregisterView(arg0);
	}

	@Override
	public void registerView(String arg0, IForumView arg1)
			throws AlreadyBoundException, IOException {
		ForumModel.INSTANCE.registerView(arg0, arg1);
	}
	
	@Override
	public void moveEast(String arg0) throws NotBoundException, IOException {
		ForumModel.INSTANCE.moveEast(arg0);
	}

	@Override
	public void moveNorth(String arg0) throws NotBoundException, IOException {
		ForumModel.INSTANCE.moveNorth(arg0);
	}

	@Override
	public void moveSouth(String arg0) throws NotBoundException, IOException {
		ForumModel.INSTANCE.moveSouth(arg0);
	}

	@Override
	public void moveWest(String arg0) throws NotBoundException, IOException {
		ForumModel.INSTANCE.moveWest(arg0);
	}
}
