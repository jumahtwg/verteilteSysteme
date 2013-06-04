package blatt6;

import java.io.IOException;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import forum.framework.ForumModel;
import forum.framework.IForumView;

// class which implements all remote methods
public class RmiModelReceiver implements IRemoteForumModel, Runnable {

	@Override
	public void deregisterView(String arg0) throws NotBoundException, IOException, RemoteException {
		ForumModel.INSTANCE.deregisterView(arg0);
	}

	@Override
	public void moveEast(String arg0) throws NotBoundException, IOException, RemoteException {
		ForumModel.INSTANCE.moveEast(arg0);
	}

	@Override
	public void moveNorth(String arg0) throws NotBoundException, IOException, RemoteException {
		ForumModel.INSTANCE.moveNorth(arg0);
	}

	@Override
	public void moveSouth(String arg0) throws NotBoundException, IOException, RemoteException {
		ForumModel.INSTANCE.moveSouth(arg0);
	}

	@Override
	public void moveWest(String arg0) throws NotBoundException, IOException, RemoteException {
		ForumModel.INSTANCE.moveWest(arg0);
	}

	@Override
	public void registerView(String arg0, IForumView arg1) throws AlreadyBoundException, IOException, RemoteException {
		try {
			ForumModel.INSTANCE.registerView(arg0, new RmiViewForwarder(arg1));
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
			IRemoteForumModel stub = (IRemoteForumModel) UnicastRemoteObject.exportObject(new RmiModelReceiver(), 0);
//			IRemoteForumView stub = (IRemoteForumView) UnicastRemoteObject.exportObject(new RmiViewForwarder(), 0);
			registry.rebind("model", stub);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
