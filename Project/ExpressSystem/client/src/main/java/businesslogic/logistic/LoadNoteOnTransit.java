package businesslogic.logistic;

import businesslogicservice.logisticblservice.LoadNoteOnTransitBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.logisticdataservice.LoadNoteOnTransitDataService;
import po.LoadNoteOnTransitPO;
import util.ResultMsg;
import vo.LoadNoteOnTransitVO;

import java.rmi.RemoteException;
import java.sql.SQLException;

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
        return centerLoadDocVO.checkFormat();
    }

    @Override
    public ResultMsg submitCenterLoadDoc(LoadNoteOnTransitVO centerLoadDocVO) {
        try {
            this.po = centerLoadDocVO.toPO();
            this.po.setUserName(centerLoadDocVO.getUserName());
            this.po.setOrganization(centerLoadDocVO.getOrganization());
            return this.dataService.insert(this.po);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"提交中转中心装车单失败!");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
            return new ResultMsg(false,"输入的条形码对应订单不存在,请重新输入");
        } catch (InterruptWithExistedElementException e) {
            e.printStackTrace();
            return new ResultMsg(false,"提交中转中心装车单失败!单据编号已存在!");
        }
    }
}
