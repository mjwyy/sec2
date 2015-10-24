<<<<<<< HEAD:Project/LogisticSystem/src/dataservice/logisticdataservice/_Stub/LoadNoteOnServiceDataService_Stub.java
package dataservice.logisticdataservice._Stub;

import dataservice.logisticdataservice.LoadNoteOnServiceDataService;
import po.LoadNoteOnServicePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class LoadNoteOnServiceDataService_Stub implements LoadNoteOnServiceDataService {

    private LoadNoteOnServicePO po1;
    private LoadNoteOnServicePO po2;
    private ArrayList<LoadNoteOnServicePO> pos;

    public LoadNoteOnServiceDataService_Stub() {
        ArrayList<String> codes = new ArrayList<String>();
        codes.add("0000000001");
        codes.add("0000000002");
        codes.add("0000000003");
        po1 = new LoadNoteOnServicePO("2015-10-22","0251001","0251001201510220001","上海","苏A 00001","泰勒",
                "小李子",codes);
        po2 = new LoadNoteOnServicePO("2015-10-23","0251001","0251001201510220002","上海","苏A 00002","Tom Hanks",
                "Bridy",codes);
        pos = new ArrayList<LoadNoteOnServicePO>();
        pos.add(po1);
        pos.add(po2);
    }

    @Override
    public void insert(LoadNoteOnServicePO po) throws RemoteException {
        System.out.println("insert succeed!");
    }

    @Override
    public void delete(LoadNoteOnServicePO po) throws RemoteException {
        System.out.println("delete succeed!");
    }

    @Override
    public void update(LoadNoteOnServicePO po) throws RemoteException {
        System.out.println("update succeed!");
    }

    @Override
    public ArrayList<LoadNoteOnServicePO> find(String name) throws RemoteException {
        System.out.println("find succeed!");
        return pos;
    }

    @Override
    public ArrayList<LoadNoteOnServicePO> findAll() throws RemoteException {
        System.out.println("show succeed!");
        return pos;
    }
}
=======
package dataservice.logisticdataservice;

import po.LoadNoteOnServicePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class LoadNoteOnServiceDataService_Stub implements LoadNoteOnServiceDataService {

    private LoadNoteOnServicePO po1;
    private LoadNoteOnServicePO po2;
    private ArrayList<LoadNoteOnServicePO> pos;

    public LoadNoteOnServiceDataService_Stub() {
        ArrayList<String> codes = new ArrayList<String>();
        codes.add("0000000001");
        codes.add("0000000002");
        codes.add("0000000003");
        po1 = new LoadNoteOnServicePO("2015-10-22","0251001","0251001201510220001","上海","苏A 00001","泰勒",
                "小李子",codes);
        po2 = new LoadNoteOnServicePO("2015-10-23","0251001","0251001201510220002","上海","苏A 00002","Tom Hanks",
                "Bridy",codes);
        pos = new ArrayList<LoadNoteOnServicePO>();
        pos.add(po1);
        pos.add(po2);
    }

    @Override
    public void insert(LoadNoteOnServicePO po) throws RemoteException {
        System.out.println("insert succeed!");
    }

    @Override
    public void delete(LoadNoteOnServicePO po) throws RemoteException {
        System.out.println("delete succeed!");
    }

    @Override
    public void update(LoadNoteOnServicePO po) throws RemoteException {
        System.out.println("update succeed!");
    }

    @Override
    public LoadNoteOnServicePO findByName(String name) throws RemoteException {
        System.out.println("findByName succeed!");
        return po1;
    }

    @Override
    public ArrayList<LoadNoteOnServicePO> show() throws RemoteException {
        System.out.println("show succeed!");
        return pos;
    }
}
>>>>>>> parent of 2d8eb69... 10.22这个世界没有锟斤拷版本:Project/LogisticSystem/src/dataservice/logisticdataservice/LoadNoteOnServiceDataService_Stub.java
