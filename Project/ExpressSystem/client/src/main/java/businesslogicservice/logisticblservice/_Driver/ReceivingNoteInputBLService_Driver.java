package businesslogicservice.logisticblservice._Driver;

import businesslogic.logistic.ReceivingNoteInput;
import businesslogicservice.logisticblservice.ReceivingNoteInputBLService;
import businesslogicservice.logisticblservice._Stub.ReceivingNoteInputBLService_Stub;
import connection.RMIHelper;
import util.ResultMsg;
import vo.ReceivingNoteVO;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ReceivingNoteInputBLService_Driver {
	public static void main(String[] args) throws RemoteException, NotBoundException {
        RMIHelper.tryConnect();
		ReceivingNoteInputBLService a=new ReceivingNoteInput();
		ReceivingNoteInputBLService_Driver b=new ReceivingNoteInputBLService_Driver();
		b.driver(a);
	}
	public void driver(	ReceivingNoteInputBLService a){

		ReceivingNoteVO receiveDocVO=new ReceivingNoteVO("0000000002", "收件人二","2011-12-7 13:25");
        receiveDocVO.setUserName("派件员1号");
        receiveDocVO.setOrganization("南京栖霞营业厅");
		ResultMsg result=a.inputReceiveDoc(receiveDocVO);
		if(result.isPass()){
			System.out.println("输入的收件单格式正确");
            ResultMsg result1=a.submitReceiveDoc(receiveDocVO);
            if(result1.isPass())
                System.out.println("提交成功");
            else
                System.out.println("提交失败");
        }
		else
			System.out.println("输入的收件单格式不正确");

	}
}
