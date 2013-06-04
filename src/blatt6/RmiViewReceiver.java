package blatt6;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import forum.framework.IForumView;
import forum.framework.Position;

//class which implements all remote methods
public class RmiViewReceiver extends UnicastRemoteObject implements IRemoteForumView, Runnable {

	private IForumView view;
	
	public RmiViewReceiver(IForumView arg0) throws RemoteException {
		this.view = arg0;
	}
	
	@Override
	public void notifyView(Map<String, Position> arg0) throws IOException, RemoteException {
		this.view.notifyView(arg0);
	}

	@Override
	public void run() {
		try {
			Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
			IRemoteForumView stub = (IRemoteForumView) UnicastRemoteObject.exportObject(new RmiModelReceiver(), 0);
			registry.rebind("view", stub);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
