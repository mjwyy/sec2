package businesslogic.commodity;

import util.FormatCheck;
import businesslogic.info.RuntimeUserInfo;
import businesslogicservice.commodityblservice.StorageInquiryAllBLService;
import util.ResultMsg;
import vo.InventoryVO;

import java.rmi.RemoteException;

import po.IncomeNotePO;
import po.InventoryPO;
import connection.RemoteObjectGetter;
import dataservice.commoditydataservice.InventoryDataService;

/**
 * Created by kylin on 15/11/17.
 * 
 * 
 */
public class StorageInquiryAll implements StorageInquiryAllBLService {
	
	InventoryDataService dataService = null;
	
	/*
	 * 应该作为盘点起始时间的字符串，由inputFirst获得
	 */
	String lastTime = null;
	
	public StorageInquiryAll() {
		RemoteObjectGetter getter = new RemoteObjectGetter();
		dataService = (InventoryDataService) getter.getObjectByName("InventoryDataService");
	}
	
    @Override
    public ResultMsg inputFirst(String firstTime) {
    	
        ResultMsg msg = FormatCheck.isDate(firstTime);
        
        if(!msg.isPass()) {
        	return msg;
        }
        
        try {
        	boolean b = dataService.setRecentTime(firstTime, RuntimeUserInfo.getNum());
        	if(!b) {
        		return new ResultMsg(false, "发生未知错误，操作失败，请重试。");
        	}
        } catch (RemoteException e) {
        	return new ResultMsg(false,e.getMessage());
        }
        
        return new ResultMsg(true);
        
    }

    @Override
    public InventoryVO request() throws Exception {
    	
    	InventoryPO get = null;
    	
    	try {
    		get = dataService.findAll(RuntimeUserInfo.getNum());
    		if(get==null) {
    			throw new Exception("服务器出现异常，无法获得数据。");
    		}
    	} catch (RemoteException e) {
    		throw e;
    	}
    	
    	InventoryVO result = (InventoryVO) get.toVO();
    	
        return result;
    }
}
