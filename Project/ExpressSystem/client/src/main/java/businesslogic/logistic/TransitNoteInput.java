package businesslogic.logistic;

import businesslogicservice.logisticblservice.TransitNoteInputBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.TransitNoteInputDataService;
import po.TransitNotePO;
import util.ResultMsg;
import vo.TransitNoteOnTransitVO;

import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * Created by kylin on 15/11/17.
 */
public class TransitNoteInput implements TransitNoteInputBLService {

    private TransitNoteInputDataService dataService;

    private TransitNotePO po;

    public TransitNoteInput(TransitNoteInputDataService dataService) {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService = (TransitNoteInputDataService) getter.getObjectByName("TransitNoteInputDataService");
    }

    @Override
    public ResultMsg inputCenterTransitDoc(TransitNoteOnTransitVO centerTransitDocVO) {
        return centerTransitDocVO.checkFormat();
    }

    @Override
    public ResultMsg submitCenterTransitDoc(TransitNoteOnTransitVO centerTransitDocVO) {
        try {
            this.po = (TransitNotePO) centerTransitDocVO.toPO();
            this.po.setUserName(centerTransitDocVO.getUserName());
            this.po.setOrganization(centerTransitDocVO.getOrganization());
            return this.dataService.insert(this.po);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"提交中转单失败!");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
            return new ResultMsg(false,"输入的条形码对应订单不存在,请重新输入");
        }
    }
}
