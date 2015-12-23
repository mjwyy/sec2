package businesslogic.logistic;

import businesslogicservice.logisticblservice.TransitNoteInputBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.logisticdataservice.TransitNoteInputDataService;
import po.TransitNotePO;
import util.ResultMsg;
import vo.TransitNoteOnTransitVO;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/17.
 */
public class TransitNoteInput implements TransitNoteInputBLService {

    private TransitNoteInputDataService dataService;

    private TransitNotePO po;

    public TransitNoteInput() {
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
            if( !InfoManager.isStaffInDB(centerTransitDocVO.getSupercargoMan()) )
                return new ResultMsg(false,"输入的监装员信息不存在,请重新输入!");

            String city1 = centerTransitDocVO.getDeparturePlace();
            String city2 = centerTransitDocVO.getDesitination();
            if( (!InfoManager.hasCity(city1)) || (!InfoManager.hasCity(city2))){
                return new ResultMsg(false,"输入的城市不存在,请重新输入!");
            }
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
        } catch (InterruptWithExistedElementException e) {
            e.printStackTrace();
            return new ResultMsg(false,"提交中转单失败!单据编号已存在!");
        }
    }
}
