package businesslogicservice.logisticblservice._Driver;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.logistic.ArrivalNoteOnTransit;
import businesslogicservice.logisticblservice.ArrivalNoteOnTransitBLService;
import businesslogicservice.logisticblservice._Stub.ArrivalNoteOnTransitBLService_Stub;
import connection.RMIHelper;
import po.ArrivalNoteOnTransitPO;
import util.BarcodeAndState;
import util.ResultMsg;
import util.enums.GoodsState;
import vo.ArrivalNoteOnTransitVO;

public class ArrivalNoteOnTransitBLService_Driver {
	public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        RMIHelper.tryConnect();
		ArrivalNoteOnTransitBLService a=new ArrivalNoteOnTransit();
		ArrivalNoteOnTransitBLService_Driver driver=new ArrivalNoteOnTransitBLService_Driver();
		driver.drive(a);
	}
	public void drive(ArrivalNoteOnTransitBLService arrivalNoteOnTransitBLService){
        BarcodeAndState bar=new BarcodeAndState( "0000000001",GoodsState.DAMAGED);
        BarcodeAndState bar2=new BarcodeAndState("0000000002",GoodsState.COMPLETE);
        BarcodeAndState bar3=new BarcodeAndState("0000000003",GoodsState.LOST);
        BarcodeAndState bar4=new BarcodeAndState("0000000004",GoodsState.DAMAGED);
        ArrayList<BarcodeAndState> BarcodeAndStates=new ArrayList<BarcodeAndState> ();
        BarcodeAndStates.add(bar);
        BarcodeAndStates.add(bar2);
        BarcodeAndStates.add(bar3);
        BarcodeAndStates.add(bar4);
        ArrivalNoteOnTransitVO centerArrivalDocVO = new ArrivalNoteOnTransitVO(
                "025001201512241230003", "025000", "2015-12-24", "北京", BarcodeAndStates);
        ResultMsg result=arrivalNoteOnTransitBLService.inputCenterArrivalDoc(
                centerArrivalDocVO);
        if(result.isPass()){
            System.out.println("输入的中转中心到达单格式正确");

            ResultMsg result1=arrivalNoteOnTransitBLService.submitCenterArrivalDoc(centerArrivalDocVO);
            if(result1.isPass())
                System.out.println("提交成功");
            else
                System.out.println("提交失败");
        }
        else{
            System.out.println("输入的中转中心到达单格式不正确");
            System.out.println(result.getMessage());
        }
    }

}
