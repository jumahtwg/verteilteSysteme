package blatt6;

import java.rmi.Remote;
import forum.framework.IForumModel;

// Remote interface which includes all methods from IForumModel.
// This methods can be called by a remote System.
// Every remote interface has to extends the Remote interface.
public interface IRemoteForumModel extends IForumModel, Remote {

}
