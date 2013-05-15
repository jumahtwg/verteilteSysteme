package blatt5;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;

import forum.framework.IForumModel;
import forum.framework.IForumView;

public class LocalModelForwarder implements IForumModel {

	@Override
	public void deregisterView(String arg0) throws NotBoundException, IOException {
		LocalModelReceiver.getInstance().deregisterView(arg0);

	}
	
	@Override
	public void registerView(String arg0, IForumView arg1) throws AlreadyBoundException, IOException {
		LocalModelReceiver.getInstance().registerView(arg0, arg1);

	}

	@Override
	public void moveEast(String arg0) throws NotBoundException, IOException {
		LocalModelReceiver.getInstance().moveEast(arg0);
	}

	@Override
	public void moveNorth(String arg0) throws NotBoundException, IOException {
		LocalModelReceiver.getInstance().moveNorth(arg0);
	}

	@Override
	public void moveSouth(String arg0) throws NotBoundException, IOException {
		LocalModelReceiver.getInstance().moveSouth(arg0);
	}

	@Override
	public void moveWest(String arg0) throws NotBoundException, IOException {
		LocalModelReceiver.getInstance().moveWest(arg0);
	}
}
