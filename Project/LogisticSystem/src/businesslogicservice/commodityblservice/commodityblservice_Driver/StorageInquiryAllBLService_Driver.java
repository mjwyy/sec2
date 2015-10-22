package businesslogicservice.commodityblservice;

import businesslogic.util.ResultMsg;

public class StorageInquiryAllBLService_Driver {
public static void main(String[] args){
	StorageInquiryAllBLService a=new StorageInquiryAllBLService_Stub();
	StorageInquiryAllBLService_Driver b=new StorageInquiryAllBLService_Driver();
	b.drive(a);
}
public void drive(StorageInquiryAllBLService a){
	a.show();
	a.inputFirst("2011-11-11");
	ResultMsg result=a.request();
	if(result.isPass()==true)
		System.out.println("success");
	else
		System.out.println("fail");
}
}
