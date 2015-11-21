package connection;

import data.dao.DatabaseFactory;
import data.infodata.SystemUserManagementData;
import data.infodata.UserDAOProxy;
import dataservice.infodataservice.SystemUserManagementDataService;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kylin on 15/11/10.
 */
public class RMIObjectProvider extends UnicastRemoteObject implements RMIObjectProviderService {

    private static final long serialVersionUID = -7307932469937624078L;

    private HashMap<String, Serializable> objMap =
            new HashMap<>();

    public RMIObjectProvider() throws RemoteException {
        initiateMap();
    }

    private void initiateMap() throws RemoteException {
        //Put all available objects into the map.
        //TODO RMI
//        objMap.put("SystemUserManagementDataService", UserDAOProxy.class);
//
//        for(Map.Entry<String, Class<? extends UnicastRemoteObject>> entry: objMap.entrySet()){
//            String name = entry.getKey();
//            Class<? extends UnicastRemoteObject> clazz = entry.getValue();
//            UnicastRemoteObject proxy = null;
//            try {
//                proxy = clazz.newInstance();
//                Naming.rebind(name, proxy);
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//
//        }
        SystemUserManagementDataService dataService = DatabaseFactory.getSystemUserManagementDataInstance();
        objMap.put("SystemUserManagementDataService", dataService);
        System.out.println("RMIObjectProvider 初始化完毕");
    }

    @Override
    public Object getObjectByName(String name) throws RemoteException {
        return objMap.get(name);
    }
}
