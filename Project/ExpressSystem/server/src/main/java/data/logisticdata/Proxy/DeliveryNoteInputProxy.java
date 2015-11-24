package data.logisticdata.Proxy;

import dataservice.logisticdataservice.DeliveryNoteInputDataService;
import po.DeliveryNotePO;
import po.OrderPO;
import util.PresumedMsg;
import util.sendDocMsg;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/24.
 */
public class DeliveryNoteInputProxy extends UnicastRemoteObject implements DeliveryNoteInputDataService {

    public DeliveryNoteInputProxy() throws RemoteException {
    }

    @Override
    public sendDocMsg insert(DeliveryNotePO po) throws RemoteException, SQLException {
        return null;
    }

    @Override
    public PresumedMsg insertOrderPO(OrderPO po) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<DeliveryNotePO> find(DeliveryNotePO po) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<DeliveryNotePO> findAll() throws RemoteException {
        return null;
    }
}
