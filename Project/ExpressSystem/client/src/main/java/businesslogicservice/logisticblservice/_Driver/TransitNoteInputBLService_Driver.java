package businesslogicservice.logisticblservice._Driver;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.logistic.TransitNoteInput;
import connection.RMIHelper;
import po.TransitNotePO;
import util.BarcodesAndLocation;
import util.enums.TransitType;
import vo.TransitNoteOnTransitVO;
import businesslogicservice.logisticblservice.TransitNoteInputBLService;
import businesslogicservice.logisticblservice._Stub.TransitNoteInputBLService_Stub;
import util.ResultMsg;

public class TransitNoteInputBLService_Driver {
	public static void main(String [] args) throws RemoteException, NotBoundException {
        RMIHelper.tryConnect();
		TransitNoteInputBLService a=new TransitNoteInput();
		TransitNoteInputBLService_Driver b=new TransitNoteInputBLService_Driver();
		b.driver(a);
	}
	public void driver(TransitNoteInputBLService a) {
        ArrayList<String> bar = new ArrayList<String>();
        bar.add("1234567890");
        ArrayList<BarcodesAndLocation> list = new ArrayList<BarcodesAndLocation>();
        list.add(new BarcodesAndLocation("0000000001", 1, 2, 3, 4));
        list.add(new BarcodesAndLocation("0000000002", 1, 2, 3, 5));
        list.add(new BarcodesAndLocation("0000000003", 1, 2, 3, 6));
        list.add(new BarcodesAndLocation("0000000004", 1, 2, 3, 7));
        TransitNoteOnTransitVO transitNoteOnTransitVO = new TransitNoteOnTransitVO(
                "2015-12-07", "025000201510120000011",
                "MF8190", TransitType.Aircraft, "北京",
                "南京", "张三", list);
        ResultMsg result = a.inputCenterTransitDoc(transitNoteOnTransitVO);
        if (result.isPass() == true) {
            System.out.println("输入的中转单格式正确");
            ResultMsg result2 = a.submitCenterTransitDoc(transitNoteOnTransitVO);
            if (result2.isPass() == true)
                System.out.println("提交成功");
            else
                System.out.println("提交失败");
        } else{
            System.out.println("输入的中转单格式不正确");
            System.out.println(result.getMessage());
        }
    }
}
