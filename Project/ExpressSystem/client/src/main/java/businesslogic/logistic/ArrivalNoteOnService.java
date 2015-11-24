package businesslogic.logistic;

import businesslogicservice.logisticblservice.ArrivalNoteOnServiceBLService;
import connection.RemoteObjectGetter;
import dataservice.logisticdataservice.ArrivalNoteOnServiceDataService;
import po.ArrivalNoteOnServicePO;
import po.DeliverNoteOnServicePO;
import util.ResultMsg;
import vo.ArrivalNoteOnServiceVO;
import vo.DeliverNoteOnServiceVO;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/17.
 */
public class ArrivalNoteOnService implements ArrivalNoteOnServiceBLService {

    private ArrivalNoteOnServiceDataService dataService;

    private ArrivalNoteOnServicePO arrivalNoteOnServicePO;
    private DeliverNoteOnServicePO deliverNoteOnServicePO;

    public ArrivalNoteOnService() {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService = (ArrivalNoteOnServiceDataService) getter.getObjectByName("ArrivalNoteOnServiceDataService");
    }

    @Override
    public ResultMsg inputHallArrivalDoc(ArrivalNoteOnServiceVO arrialDocVO) {
        ResultMsg formatCheck = arrialDocVO.checkFormat();
        if(formatCheck.isPass())
            this.submitHallArrivalDoc(arrialDocVO);
        return formatCheck;
    }

    @Override
    public ResultMsg submitHallArrivalDoc(ArrivalNoteOnServiceVO arrialDocVO) {
        try {
            this.arrivalNoteOnServicePO = arrialDocVO.toPO();
            this.dataService.insertArrivalNote(this.arrivalNoteOnServicePO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,e.getMessage());
        }
        return new ResultMsg(true,"营业厅到达单已提交!");
    }

    @Override
    public ResultMsg inputHallDeliverDoc(DeliverNoteOnServiceVO deliverDocVO) {
        ResultMsg formatCheck = deliverDocVO.checkFormat();
        if(formatCheck.isPass())
            this.submitHallDeliverDoc(deliverDocVO);
        return formatCheck;
    }

    @Override
    public ResultMsg submitHallDeliverDoc(DeliverNoteOnServiceVO deliverDocVO) {
        try {
            this.deliverNoteOnServicePO = deliverDocVO.toPO();
            this.dataService.insertDeliverNote(this.deliverNoteOnServicePO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,e.getMessage());
        }
        return new ResultMsg(true,"营业厅装车单已提交!");
    }
}
