package data.financedata;

import dataservice.financedataservice.SettlementManagementDataService;
import po.IncomeNotePO;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/16.
 */
public class SettlementManagementData implements SettlementManagementDataService {
    @Override
    public boolean addIncomeNote(IncomeNotePO note) throws RemoteException {
        return false;
    }
}
