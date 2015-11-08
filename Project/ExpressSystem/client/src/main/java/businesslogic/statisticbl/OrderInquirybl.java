package businesslogic.statisticbl;

import java.rmi.RemoteException;

import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.OrderInquiryDataService;
import po.OrderPO;
import businesslogicservice.statisticblservice.OrderInquiryBLService;
import util.ResultMsg;
import vo.OrderVO;

public class OrderInquirybl implements OrderInquiryBLService {
	private ResultMsg res;
	private OrderInquiryDataService orderInquiryDataService;
	private OrderPO po;
	
	
	
	public OrderInquirybl() {
		//orderInquiryDataService = RMIHelper.getOrderInquiryDataService();
	}

	/**
	 * 输入订单条形码，返回格式检查结果
	 * @param inputBarcode
	 * @return
	 */
	public ResultMsg inputBarcode(String inputBarcode){
		int isNum = 1;
		if(inputBarcode.length()!=10)
			res = new ResultMsg(false,"条形码位数应为10位");
		else{
			for(int i = 0;i<10;i++){
				if(!(inputBarcode.charAt(i)>='0'&&inputBarcode.charAt(i)<='9')){
					isNum = 0;
					break;
				}
			}
			
			if(isNum == 0)
				res = new ResultMsg(false,"条形码应为10位0～9的数字");
			else
				res = new ResultMsg(true,null);		
		}
		
		return res;
	}

	@Override
	public OrderVO submitBarcode(String inputBarcode){
		
		try{
		po = orderInquiryDataService.findOrder(inputBarcode);
		}catch(RemoteException e){
			e.printStackTrace();
		} catch (ElementNotFoundException e) {
			
			e.printStackTrace();
		}
		
		OrderVO vo = new OrderVO(po.getBarcode(),po.getStateOfTransport(),po.getHistory());
		
		return vo;
	}

}
