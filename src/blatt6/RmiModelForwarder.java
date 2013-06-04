package blatt6;

import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import forum.framework.IForumModel;
import forum.framework.IForumView;

public class RmiModelForwarder implements IForumModel {

	// have to be static
	private static IForumModel stub;
	
	public RmiModelForwarder() throws AccessException, RemoteException, NotBoundException {
		// ??? Vielleicht muss man da noch den Namen eingeben ???
		Registry registry = LocateRegistry.getRegistry();
		// ??? Müssen die Namen unterschiedlich sein ???
		stub = (IForumModel) registry.lookup("model");
	}
	
	@Override
	public void registerView(String arg0, IForumView arg1) throws AlreadyBoundException, IOException {
		stub.registerView(arg0, new RmiViewReceiver(arg1));
		System.out.println("test");
	}
	
	@Override
	public void deregisterView(String arg0) throws NotBoundException,
			IOException {
		stub.deregisterView(arg0);
	}

	@Override
	public void moveEast(String arg0) throws NotBoundException, IOException {
		stub.moveEast(arg0);
	}

	@Override
	public void moveNorth(String arg0) throws NotBoundException, IOException {
		stub.moveNorth(arg0);
	}

	@Override
	public void moveSouth(String arg0) throws NotBoundException, IOException {
		stub.moveSouth(arg0);
	}

	@Override
	public void moveWest(String arg0) throws NotBoundException, IOException {
		stub.moveWest(arg0);
	}
}
