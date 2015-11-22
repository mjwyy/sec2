package businesslogic.finance;

import businesslogicservice.financeblservice.SettlementManagementBLService;
import util.ResultMsg;
import vo.IncomeNoteVO;

import java.util.ArrayList;

/**
 * Created by kylin on 15/11/17.
 */
public class SettlementManagement implements SettlementManagementBLService {
    @Override
    public ResultMsg addReceiveRecord(IncomeNoteVO vo) {
        return null;
    }

    @Override
    public ArrayList<IncomeNoteVO> find(IncomeNoteVO vo) {
        return null;
    }
}
