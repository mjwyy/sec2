package businesslogicservice.statisticblservice._driver;

import businesslogicservice.statisticblservice.OrderInquiryBLService;
import dataservice.exception.ElementNotFoundException;
import util.ResultMsg;
import vo.OrderVO;

import java.rmi.RemoteException;

public class OrderInquiryBLService_Driver {

	public void drive(OrderInquiryBLService service) throws ElementNotFoundException, RemoteException {
		ResultMsg result = service.inputBarcode("0123456789");
		if(result.isPass())
			System.out.println("barcode is correct!");
		else
			System.out.println("barcode is wrong!");
		service.submitBarcode("0123456789");
		ResultMsg result2 = service.inputBarcode("0123456790");
		System.out.println("barcode is correct!");
		if(result2.isPass())
			System.out.println("barcode is correct!");
		else
			System.out.println("barcode is wrong!");
		OrderVO history = service.submitBarcode("0123456790");
		System.out.println(history.getStateOfTransport());
	}
	
}
