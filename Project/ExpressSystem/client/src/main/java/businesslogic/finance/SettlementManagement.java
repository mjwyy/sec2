package businesslogic.finance;

import util.RuntimeUserInfo;
import businesslogicservice.financeblservice.SettlementManagementBLService;
import util.ResultMsg;
import vo.IncomeNoteVO;

import java.util.ArrayList;

import po.IncomeNotePO;
import connection.RemoteObjectGetter;
import dataservice.financedataservice.SettlementManagementDataService;

/**
 * Created by kylin on 15/11/17.
 * 
 * Finished.
 */
public class SettlementManagement implements SettlementManagementBLService {
	
	SettlementManagementDataService dataService = null;
	
	public SettlementManagement() {
		RemoteObjectGetter getter = new RemoteObjectGetter();
		dataService = (SettlementManagementDataService) getter.getObjectByName("SettlementManagementDataService");
	}
	
    @Override
    public ResultMsg addReceiveRecord(IncomeNoteVO vo) {
    	ResultMsg msg = vo.checkFormat();
    	if(!msg.isPass()){
    		return msg;
    	}
    	
    	try {
    		boolean b = dataService.addIncomeNote((IncomeNotePO) vo.toPO(),RuntimeUserInfo.getNum());
    		if(!b) {
    			return new ResultMsg(false, "发生未知错误，操作未完成");
    		}
    	} catch (Exception e) {
    		return new ResultMsg(false,e.getMessage());
    	}
    	
    	return new ResultMsg(true);
    }

    @Override
    public ArrayList<IncomeNoteVO> find(IncomeNoteVO vo) {
    	
    	ArrayList<IncomeNoteVO> result = new ArrayList<>();
    	ArrayList<IncomeNotePO> get = null;
    	try {
    		get = dataService.findAll();
    	} catch (Exception e) {
    		System.err.println("获取收款单失败：");
    		System.err.println(e.getMessage());
    		return result;
    	}
    	
    	for(IncomeNotePO po:get) {
    		result.add((IncomeNoteVO)po.toVO());
    	}
    	
    	
        return result;
    }
}
