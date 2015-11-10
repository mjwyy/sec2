package dataservice.logisticdataservice._Stub;

import dataservice.logisticdataservice.DeliveryNoteInputDataService;
import po.DeliveryNotePO;
import util.enums.DeliverCategory;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class DeliveryNoteInputDataService_Stub implements DeliveryNoteInputDataService {

    private DeliveryNotePO po1;
    private DeliveryNotePO po2;
    private ArrayList<DeliveryNotePO> pos;

    public DeliveryNoteInputDataService_Stub() {
        po1 = new DeliveryNotePO("王二狗","江苏省南京市栖霞区南京大学仙林校区","南京大学仙林校区",
                "150052120000","1",0.5,20,"离散数学", DeliverCategory.EXPRESS,5,"1234567890");
        po2 = new DeliveryNotePO("kylin","江苏省南京市栖霞区南京大学仙林校区","南京大学仙林校区",
                "150052126666","1",0.5,20,"head first java",DeliverCategory.EXPRESS,5,"1234567891");
        pos = new ArrayList<DeliveryNotePO>();
        pos.add(po1);
        pos.add(po2);
    }

     
    public boolean insert(DeliveryNotePO po) throws RemoteException {
        System.out.println("insert succeed!");
		return true;
    }

     
    public boolean delete(DeliveryNotePO po) throws RemoteException {
        System.out.println("delete succeed!");
		return true;
    }

     
    public boolean update(DeliveryNotePO po) throws RemoteException {
        System.out.println("update succeed!");
		return true;
    }

     
    public ArrayList<DeliveryNotePO> find(DeliveryNotePO po) throws RemoteException {
        System.out.println("find succeed!");
        return pos;
    }

     
    public ArrayList<DeliveryNotePO> findAll() throws RemoteException {
        System.out.println("find all succeed!");
        return pos;
    }
}
