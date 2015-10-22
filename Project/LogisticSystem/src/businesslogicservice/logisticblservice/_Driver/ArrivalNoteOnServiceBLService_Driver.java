package businesslogicservice.logisticblservice;

import java.util.ArrayList;

import vo.ArrivalNoteOnServiceVO;
import vo.DeliverNoteOnServiceVO;
import businesslogic.util.GoodsState;
import businesslogic.util.ResultMsg;

public class ArrivalNoteOnServiceBLService_Driver {
	public static void main(String[] args){
		ArrivalNoteOnServiceBLService a=new ArrivalNoteOnServiceBLService_Stub();
		ArrivalNoteOnServiceBLService_Driver b=new ArrivalNoteOnServiceBLService_Driver();
		b.drive(a);
	}


		public void drive(ArrivalNoteOnServiceBLService arrivalNoteOnServiceBLService){
			ArrayList<String> bar=new ArrayList<String>();
			bar.add("1234567890");
			ArrivalNoteOnServiceVO arrialDocVO=new ArrivalNoteOnServiceVO("2015-11-11", GoodsState.COMPLETE, bar, "0123456789");
			DeliverNoteOnServiceVO deliverDocVO=new DeliverNoteOnServiceVO("2015-11-11", bar, "李明");
			ResultMsg result=arrivalNoteOnServiceBLService.inputHallArrivalDoc(arrialDocVO);
			if(result.isPass()==true)
				System.out.println("输入的到达单格式正确");
			else
				System.out.println("输入的到达单格式不正确");
			ResultMsg result1=arrivalNoteOnServiceBLService.submitHallArrivalDoc(arrialDocVO);
			if(result1.isPass()==true)
				System.out.println("提交成功");
			else
				System.out.println("提交失败");
			ResultMsg result2=arrivalNoteOnServiceBLService.inputHallDeliverDoc(deliverDocVO);
			if(result.isPass()==true)
				System.out.println("输入的派送单格式正确");
			else
				System.out.println("输入的派送单格式不正确");
			ResultMsg result3=arrivalNoteOnServiceBLService.submitHallDeliverDoc(deliverDocVO);
			if(result1.isPass()==true)
				System.out.println("提交成功");
			else
				System.out.println("提交失败");
		}

	}
