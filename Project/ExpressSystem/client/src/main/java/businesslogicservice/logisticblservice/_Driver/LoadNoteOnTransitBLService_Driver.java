package businesslogicservice.logisticblservice._Driver;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.logistic.LoadNoteOnTransit;
import businesslogicservice.logisticblservice.LoadNoteOnTransitBLService;
import businesslogicservice.logisticblservice._Stub.LoadNoteOnTransitBLService_Stub;
import connection.RMIHelper;
import po.LoadNoteOnTransitPO;
import util.ResultMsg;
import vo.LoadNoteOnTransitVO;

public class LoadNoteOnTransitBLService_Driver {
	public static void main(String[] args) throws RemoteException, NotBoundException {
        RMIHelper.tryConnect();
		LoadNoteOnTransitBLService a=new LoadNoteOnTransit();
		LoadNoteOnTransitBLService_Driver b=new LoadNoteOnTransitBLService_Driver();
		b.driver(a);
	}
	public void driver(LoadNoteOnTransitBLService a){
        ArrayList<String> bar = new ArrayList<String>();
        bar.add("0000000001");
        bar.add("0000000003");
        bar.add("0000000004");
        bar.add("0000000002");
        LoadNoteOnTransitVO centerLoadDocVO = new LoadNoteOnTransitVO(
                "2015-12-07", "025000201509090000011", "北京", "025000001",
                "张三", "张三", bar);
        centerLoadDocVO.setOrganization("南京中转中心");
        centerLoadDocVO.setUserName("中转中心装车人员");
		ResultMsg result=a.inputCenterLoadDoc(centerLoadDocVO);
		if(result.isPass()){
			System.out.println("输入的中转中心装车单格式正确");
            ResultMsg result1=a.submitCenterLoadDoc(centerLoadDocVO);
            if(result1.isPass())
                System.out.println("提交成功");
            else
                System.out.println("提交失败");
        }
		else{
			System.out.println("输入的中转中心装车单格式不正确");
            System.out.println(result.getMessage());
        }

	}
}
