package blatt4;

import java.util.UUID;

import blatt4.Message.MessageType;

public class BullyProcess extends Process {



	public BullyProcess(int id) {
		super(id);
	}

	@Override
	public void run() {
		 System.out.println("Thread: " + super.getID() + " starts");
		 Message msg = new Message(MessageType.ELECT, getID(), UUID.randomUUID());
		 if (getID() < destinations.size()) {
			 if( destinations.keySet() != null)
			 System.out.println("Number " + getID());
			 msgQueue.add(msg);
		 }

		
	}

	@Override
	public void startElection() {
		// TODO Auto-generated method stub
		
	}

}
