package blatt6;

import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Map;
import forum.framework.IForumView;
import forum.framework.Position;

public class RmiViewForwarder implements IForumView {

	// have to be static
	private static IForumView stub;
		
	public RmiViewForwarder(IForumView arg0) throws AccessException, RemoteException, NotBoundException {
		stub = arg0;
	}
	
	@Override
	public void notifyView(Map<String, Position> arg0) throws IOException {
		stub.notifyView(arg0);
	}

}
