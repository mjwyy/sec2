package businesslogicservice.logisticblservice._Driver;

import connection.RMIHelper;
import connection.RemoteObjectGetter;
import dataservice.statisticdataservice.OrderInquiryDataService;
import util.SendDocMsg;
import util.enums.PackageType;
import vo.DeliveryNoteVO;
import businesslogicservice.logisticblservice.DeliveryNoteInputBLService;
import businesslogicservice.logisticblservice._Stub.DeliveryNoteInputBLService_Stub;
import util.ResultMsg;
import util.enums.DeliverCategory;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class DeliveryNoteInputBLService_Driver {
	public static void main(String [] args) throws RemoteException, NotBoundException {
        RMIHelper.tryConnect();
        RemoteObjectGetter getter = new RemoteObjectGetter();
        OrderInquiryDataService order = (OrderInquiryDataService)
                getter.getObjectByName("OrderInquiryDataService");
        boolean result = order.insertOrderPO("1231231231","货物已被快递员 +deliveryMan+ 签收;");
        System.out.println(result);
	}
	public void driver(DeliveryNoteInputBLService a) throws RemoteException {

		DeliveryNoteVO sendDocVO1=new DeliveryNoteVO("王二狗","江苏省南京市栖霞区南京大学仙林校区","150052120000",
                "Tom Hanks","江苏省徐州市沛县第三中学语文组","19883490000","爆炸物",10,
                10,2,DeliverCategory.EXPRESS, PackageType.Bag,"0000000001");
		ResultMsg result=a.inputSendDoc(sendDocVO1);
		if(result.isPass()==true)
			System.out.println("输入的寄件单格式正确");
		else
			System.out.println("输入的寄件单格式不正确");
        SendDocMsg result2 = a.submitSendDoc(sendDocVO1);
        if(result2.isPass()==true)
			System.out.println("提交成功");
		else
			System.out.println("提交失败");
	}
}
