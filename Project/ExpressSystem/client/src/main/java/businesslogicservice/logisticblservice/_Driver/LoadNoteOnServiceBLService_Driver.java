package businesslogicservice.logisticblservice._Driver;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.logistic.LoadNoteOnService;
import businesslogicservice.logisticblservice.LoadNoteOnServiceBLService;
import businesslogicservice.logisticblservice._Stub.LoadNoteOnServiceBLService_Stub;
import connection.RMIHelper;
import po.LoadNoteOnServicePO;
import util.ResultMsg;
import vo.LoadNoteOnServiceVO;

public class LoadNoteOnServiceBLService_Driver {
	public static void main(String[] args) throws RemoteException, NotBoundException {
        RMIHelper.tryConnect();
		LoadNoteOnServiceBLService a=new LoadNoteOnService();
		LoadNoteOnServiceBLService_Driver b=new LoadNoteOnServiceBLService_Driver();
		b.driver(a);
	}
	public void driver(LoadNoteOnServiceBLService service){
        ArrayList<String> bar = new ArrayList<String>();
        bar.add("0000000001");
        bar.add("0000000002");
        bar.add("0000000003");
        bar.add("0000000004");
        LoadNoteOnServiceVO po1 = new LoadNoteOnServiceVO("2015-12-07", "0251002",
                "02510012015101300002", "北京", "025000000", "李明", "张三", bar);
        ResultMsg resultMsg = service.inputHallLoadDoc(po1);
        System.out.println(resultMsg.getMessage());
        if(resultMsg.isPass()){
            ResultMsg resultMsg1 = service.submitHallLoadDoc(po1);
            System.out.println(resultMsg1.isPass());
            System.out.println(resultMsg1.getMessage());
        }

	}
}
