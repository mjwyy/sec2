package businesslogic.logistic;

import businesslogicservice.logisticblservice.ArrivalNoteOnTransitBLService;
import connection.RemoteObjectGetter;
import dataservice.logisticdataservice.ArrivalNoteOnTransitDataService;
import po.ArrivalNoteOnTransitPO;
import util.ResultMsg;
import vo.ArrivalNoteOnTransitVO;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/17.
 */
public class ArrivalNoteOnTransit implements ArrivalNoteOnTransitBLService {

    private ArrivalNoteOnTransitDataService dataService;

    private ArrivalNoteOnTransitPO po;

    public ArrivalNoteOnTransit(ArrivalNoteOnTransitDataService dataService) {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService = (ArrivalNoteOnTransitDataService) getter.getObjectByName("ArrivalNoteOnTransitDataService");
    }

    @Override
    public ResultMsg inputCenterArrivalDoc(ArrivalNoteOnTransitVO centerArrivalDocVO) {
        ResultMsg formatCheck = centerArrivalDocVO.checkFormat();
        if(formatCheck.isPass())
            this.submitCenterArrivalDoc(centerArrivalDocVO);
        return formatCheck;
    }

    @Override
    public ResultMsg submitCenterArrivalDoc(ArrivalNoteOnTransitVO centerArrivalDocVO) {
        try {
            this.po = centerArrivalDocVO.toPO();
            this.dataService.insert(this.po);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return new ResultMsg(true,"中转中心到达单已提交!");
    }
}
