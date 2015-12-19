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
        bar.add("0000000001");
        bar.add("0000000002");
        TransitNoteOnTransitVO transitNoteOnTransitVO = new TransitNoteOnTransitVO(
                "2015-12-19", "025000201510120000099",
                "G8888", TransitType.Aircraft, "南京市栖霞区南京大学",
                "北京市", "张三", bar);
        ResultMsg result = a.inputCenterTransitDoc(transitNoteOnTransitVO);

        if (result.isPass()) {
            System.out.println("输入的中转单格式正确");
            ResultMsg result2 = a.submitCenterTransitDoc(transitNoteOnTransitVO);
            if (result2.isPass())
                System.out.println("提交成功");
            else{
                System.out.println("提交失败");
                System.out.println(result2.getMessage());
            }
        } else{
            System.out.println("输入的中转单格式不正确");
            System.out.println(result.getMessage());
        }
    }
}
