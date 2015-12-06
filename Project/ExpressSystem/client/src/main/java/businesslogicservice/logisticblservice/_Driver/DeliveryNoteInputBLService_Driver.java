package businesslogicservice.logisticblservice._Driver;

import businesslogic.logistic.DeliveryNoteInput;
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
        DeliveryNoteInputBLService_Driver driver = new DeliveryNoteInputBLService_Driver();
        DeliveryNoteInputBLService service = new DeliveryNoteInput();
        driver.driver(service);
	}
	public void driver(DeliveryNoteInputBLService service) throws RemoteException {
		DeliveryNoteVO sendDocVO1=new DeliveryNoteVO("王二狗","江苏省南京市栖霞区南京大学仙林校区",
                "15005212000", "王二狗","上海市第三中学语文组",
                "15005212000","爆炸物",10, 10,2,
                DeliverCategory.EXPRESS, PackageType.Bag,"0000000004");
		ResultMsg result = service.inputSendDoc(sendDocVO1);
		if(result.isPass()){
			System.out.println("输入的寄件单格式正确");
            SendDocMsg result2 = service.submitSendDoc(sendDocVO1);
            if(result2.isPass())
                System.out.println("提交成功");
            else
                System.out.println("提交失败");
            System.out.println(result2.getPrice());
            System.out.println(result2.getPredectedDate());
        }
		else{
			System.out.println("输入的寄件单格式不正确");
			System.out.println(result.getMessage());
        }

    }
}
