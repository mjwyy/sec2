package businesslogic.logistic;

import businesslogicservice.logisticblservice.LoadNoteOnServiceBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.logisticdataservice.LoadNoteOnServiceDataService;
import po.LoadNoteOnServicePO;
import util.ResultMsg;
import vo.LoadNoteOnServiceVO;

import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * Created by kylin on 15/11/17.
 */
public class LoadNoteOnService implements LoadNoteOnServiceBLService {

    private LoadNoteOnServiceDataService dataService;

    private LoadNoteOnServicePO po;

    public LoadNoteOnService() {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService = (LoadNoteOnServiceDataService) getter.getObjectByName("LoadNoteOnServiceDataService");
    }

    @Override
    public ResultMsg inputHallLoadDoc(LoadNoteOnServiceVO hallLoadDocVO) {
        return hallLoadDocVO.checkFormat();
    }

    @Override
    public ResultMsg submitHallLoadDoc(LoadNoteOnServiceVO hallLoadDocVO) {
        try {
            this.po = hallLoadDocVO.toPO();
            this.po.setOrganization(hallLoadDocVO.getOrganization());
            this.po.setUserName(hallLoadDocVO.getUserName());
            return this.dataService.insert(this.po);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"提交营业厅装车单失败!");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
            return new ResultMsg(false,"输入的条形码对应订单不存在,请重新输入");
        } catch (InterruptWithExistedElementException e) {
            e.printStackTrace();
            return new ResultMsg(false,"提交营业厅装车单失败!单据编号已存在!");
        }
    }
}
