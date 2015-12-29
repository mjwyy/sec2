package connection;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DisconnectionCheckerObj extends UnicastRemoteObject implements Serializable, Remote {

	

	private static final long serialVersionUID = 1942765702646146757L;
	
	public int junkData = 5;
	
	protected DisconnectionCheckerObj() throws RemoteException {
		super();
	}
}
