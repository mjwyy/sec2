package connection;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import connection.connectionservice.RMIObjectProviderService;





public class RMIObjectProvider extends UnicastRemoteObject implements Serializable, RMIObjectProviderService {

	private static final long serialVersionUID = -7307932469937624078L;


	private HashMap<String,Serializable> objMap = new HashMap<String, Serializable>();
	
	RMIObjectProvider() throws RemoteException {		
		initiateMap();
	}

	
	private void initiateMap() {
//Put all avaliable objects into the map.
//		objMap.put("", );
		
	}


	@Override
	public Object getObjectByName(String name) {
		return objMap.get(name);
	}
}
