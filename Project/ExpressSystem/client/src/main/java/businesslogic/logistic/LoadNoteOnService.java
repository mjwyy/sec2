package businesslogic.logistic;

import businesslogicservice.logisticblservice.LoadNoteOnServiceBLService;
import connection.RemoteObjectGetter;
import dataservice.logisticdataservice.LoadNoteOnServiceDataService;
import po.LoadNoteOnServicePO;
import util.ResultMsg;
import vo.LoadNoteOnServiceVO;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/17.
 */
public class LoadNoteOnService implements LoadNoteOnServiceBLService {

    private LoadNoteOnServiceDataService dataService;

    private LoadNoteOnServicePO po;

    public LoadNoteOnService(LoadNoteOnServiceDataService dataService) {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService = (LoadNoteOnServiceDataService) getter.getObjectByName("LoadNoteOnServiceDataService");
    }

    @Override
    public ResultMsg inputHallLoadDoc(LoadNoteOnServiceVO hallLoadDocVO) {
        ResultMsg formatCheck = hallLoadDocVO.checkFormat();
        if(formatCheck.isPass())
            this.submitHallLoadDoc(hallLoadDocVO);
        return formatCheck;
    }

    @Override
    public ResultMsg submitHallLoadDoc(LoadNoteOnServiceVO hallLoadDocVO) {
        try {
            this.po = hallLoadDocVO.toPO();
            this.dataService.insert(this.po);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return new ResultMsg(true,"营业厅装车单已提交!");
    }
}
