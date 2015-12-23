package businesslogic.logistic;

import businesslogicservice.logisticblservice.ArrivalNoteOnTransitBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
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

    public ArrivalNoteOnTransit() {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService = (ArrivalNoteOnTransitDataService) getter.getObjectByName("ArrivalNoteOnTransitDataService");
    }

    @Override
    public ResultMsg inputCenterArrivalDoc(ArrivalNoteOnTransitVO centerArrivalDocVO) {
        return centerArrivalDocVO.checkFormat();
    }

    @Override
    public ResultMsg submitCenterArrivalDoc(ArrivalNoteOnTransitVO centerArrivalDocVO) {
        try {
            String city = centerArrivalDocVO.getDeparturePlace();
            if( !InfoManager.hasCity(city)){
                return new ResultMsg(false,"输入的城市不存在,请重新输入!");
            }
            this.po = centerArrivalDocVO.toPO();
            this.po.setUserName(centerArrivalDocVO.getUserName());
            this.po.setOrganization(centerArrivalDocVO.getOrganization());
            return this.dataService.insert(this.po);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"提交中转中心到达单失败!");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
            return new ResultMsg(false,"输入的条形码对应订单不存在,请重新输入");
        } catch (InterruptWithExistedElementException e) {
            e.printStackTrace();
            return new ResultMsg(false,"提交中转中心到达单失败!单据编号已存在!");
        }
    }
}
