package data.financedata;

import dataservice.financedataservice.SettlementManagementDataService;
import po.IncomeNotePO;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/16.
 */
public class SettlementManagementData implements SettlementManagementDataService {
	
	private static final long serialVersionUID = -5692094959798049197L;
	
	private Connection connection;
	
	public SettlementManagementData() {
		super();
	}
	
    @Override
    public boolean addIncomeNote(IncomeNotePO note, String staffID) throws RemoteException {
    	//注意审批、修改银行账户余额
        return false;
    }

	@Override
	public ArrayList<IncomeNotePO> findAll() throws RemoteException {
		//返回所有的，因为总部只有一个
		return null;
	}
}
