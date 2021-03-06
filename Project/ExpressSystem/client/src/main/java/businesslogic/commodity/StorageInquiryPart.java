package businesslogic.commodity;

import util.RuntimeUserInfo;
import util.FormatCheck;
import businesslogicservice.commodityblservice.StorageInquiryPartBLService;
import util.ResultMsg;
import vo.InventoryVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.InventoryPO;
import connection.RemoteObjectGetter;
import dataservice.commoditydataservice.InventoryDataService;

/**
 * Created by kylin on 15/11/17.
 * 
 * Finished.
 */
public class StorageInquiryPart implements StorageInquiryPartBLService {
	
	InventoryDataService dataService = null;
	
	ArrayList<InventoryVO> resultList = new ArrayList<>();
	
	public StorageInquiryPart() {
		RemoteObjectGetter getter = new RemoteObjectGetter();
		dataService = (InventoryDataService) getter.getObjectByName("InventoryDataService");
	}
	
    @Override
    public ResultMsg inputTime(String time1, String time2) {
        ResultMsg[] msg = new ResultMsg[2];
        
        msg[0] = FormatCheck.isInventoryTime(time1);
        msg[1] = FormatCheck.isInventoryTime(time2);
        
        for(int i=0;i<msg.length;i++) {
        	if(!msg[i].isPass()) return msg[i];
        }
        
        if(time1.compareTo(time2)>0) {
        	return new ResultMsg(false,"开始时间应该在结束时间之前~");
        }
        
        return new ResultMsg(true);
    }

    @Override
    public InventoryVO show(String time1, String time2) {
    	InventoryPO list = null;
    	
    	try {
    		list = dataService.findByTime(time1, time2, RuntimeUserInfo.getNum());
    	} catch(RemoteException e) {
    		System.err.println(e.getMessage());
    		return null;
    	}
    	
        return (InventoryVO) list.toVO();
    }
}
