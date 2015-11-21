package businesslogic.logistic;

import businesslogicservice.logisticblservice.LoadNoteOnTransitBLService;
import connection.RemoteObjectGetter;
import dataservice.logisticdataservice.LoadNoteOnTransitDataService;
import po.LoadNoteOnTransitPO;
import util.ResultMsg;
import vo.LoadNoteOnTransitVO;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/17.
 */
public class LoadNoteOnTransit implements LoadNoteOnTransitBLService {

    private LoadNoteOnTransitDataService dataService;

    private LoadNoteOnTransitPO po;

    public LoadNoteOnTransit(LoadNoteOnTransitDataService dataService) {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService = (LoadNoteOnTransitDataService) getter.getObjectByName("LoadNoteOnTransitDataService");
    }

    @Override
    public ResultMsg inputCenterLoadDoc(LoadNoteOnTransitVO centerLoadDocVO) {
        ResultMsg formatCheck = centerLoadDocVO.checkFormat();
        if(formatCheck.isPass())
            this.submitCenterLoadDoc(centerLoadDocVO);
        return formatCheck;
    }

    @Override
    public ResultMsg submitCenterLoadDoc(LoadNoteOnTransitVO centerLoadDocVO) {
        try {
            this.po = centerLoadDocVO.toPO();
            this.dataService.insert(this.po);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return new ResultMsg(true,"中转中心装车单已提交!");
    }
}
