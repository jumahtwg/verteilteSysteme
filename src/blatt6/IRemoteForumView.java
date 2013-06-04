package blatt6;

import java.rmi.Remote;
import forum.framework.IForumView;

// Remote interface which includes all methods from IForumView.
// This methods can be called by a remote System.
// Every remote interface has to extends the Remote interface.
public interface IRemoteForumView extends IForumView, Remote {

}
