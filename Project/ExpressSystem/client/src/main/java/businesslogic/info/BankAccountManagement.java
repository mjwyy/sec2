package businesslogic.info;

import businesslogicservice.infoblservice.BankAccountManagementBLService;
import util.ResultMsg;
import vo.BankAccountVO;

import java.util.ArrayList;

import connection.RemoteObjectGetter;
import dataservice.commoditydataservice.StorageInDataService;
import dataservice.infodataservice.BankAccountManagementDataService;

/**
 * Created by kylin on 15/11/17.
 */
public class BankAccountManagement implements BankAccountManagementBLService {
	
	BankAccountManagementDataService dataService = null;
	
	public BankAccountManagement() {
		RemoteObjectGetter getter = new RemoteObjectGetter();
		dataService = (BankAccountManagementDataService) getter.getObjectByName("BankAccountManagementDataService");
	}
	
    @Override
    public ArrayList<BankAccountVO> find(BankAccountVO vo) {
        return null;
    }

    @Override
    public ResultMsg add(BankAccountVO vo) {
        return null;
    }

    @Override
    public ResultMsg delete(BankAccountVO vo) {
        return null;
    }

    @Override
    public ResultMsg update(BankAccountVO vo) {
        return null;
    }

    @Override
    public ArrayList<BankAccountVO> show() {
        return null;
    }
}
