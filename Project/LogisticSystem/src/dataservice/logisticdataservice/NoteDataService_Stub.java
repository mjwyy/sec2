<<<<<<< HEAD
package dataservice.logisticdataservice;

import po.NotePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class NoteDataService_Stub implements NoteDataService {

    private NotePO po1;
    private NotePO po2;
    private ArrayList<NotePO> pos;

    public NoteDataService_Stub() {
        po1 = new NotePO();
        po2 = new NotePO();
        pos = new ArrayList<NotePO>();
        pos.add(po1);
        pos.add(po2);
    }

    @Override
    public void insert(NotePO po) throws RemoteException {
        System.out.println("insert succeed!");
    }

    @Override
    public void delete(NotePO po) throws RemoteException {
        System.out.println("delete succeed!");
    }

    @Override
    public void update(NotePO po) throws RemoteException {
        System.out.println("update succeed!");
    }

    @Override
    public ArrayList<NotePO> find(String name) throws RemoteException {
        System.out.println("find succeed!");
        return pos;
    }

    @Override
    public ArrayList<NotePO> findAll() throws RemoteException {
        System.out.println("find All succeed!");
        return pos;
    }

    @Override
    public void init() throws RemoteException {
        System.out.println("init succeed!");
    }

    @Override
    public void finish() throws RemoteException {
        System.out.println("finish succeed!");
    }
}
=======
package dataservice.logisticdataservice;

import po.NotePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class NoteDataService_Stub implements NoteDataService {

    private NotePO po1;
    private NotePO po2;
    private ArrayList<NotePO> pos;

    public NoteDataService_Stub() {
        po1 = new NotePO();
        po2 = new NotePO();
        pos = new ArrayList<NotePO>();
        pos.add(po1);
        pos.add(po2);
    }

    @Override
    public void insert(NotePO po) throws RemoteException {
        System.out.println("insert succeed!");
    }

    @Override
    public void delete(NotePO po) throws RemoteException {
        System.out.println("delete succeed!");
    }

    @Override
    public void update(NotePO po) throws RemoteException {
        System.out.println("update succeed!");
    }

    @Override
    public NotePO findByName(String name) throws RemoteException {
        System.out.println("findByName succeed!");
        return po1;
    }

    @Override
    public ArrayList<NotePO> show() throws RemoteException {
        System.out.println("show succeed!");
        return pos;
    }

    @Override
    public void init() throws RemoteException {
        System.out.println("init succeed!");
    }

    @Override
    public void finish() throws RemoteException {
        System.out.println("finish succeed!");
    }
}
>>>>>>> master
