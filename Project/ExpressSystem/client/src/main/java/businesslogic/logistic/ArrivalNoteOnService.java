package businesslogic.logistic;

import businesslogicservice.logisticblservice.ArrivalNoteOnServiceBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.logisticdataservice.ArrivalNoteOnServiceDataService;
import po.ArrivalNoteOnServicePO;
import po.DeliverNoteOnServicePO;
import util.ResultMsg;
import vo.ArrivalNoteOnServiceVO;
import vo.DeliverNoteOnServiceVO;

import java.rmi.RemoteException;
import java.sql.SQLException;

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
        return arrialDocVO.checkFormat();
    }

    @Override
    public ResultMsg submitHallArrivalDoc(ArrivalNoteOnServiceVO arrialDocVO) {
        try {
            this.arrivalNoteOnServicePO = arrialDocVO.toPO();
            //从VO中获取营业员的名字与工作地点
            arrivalNoteOnServicePO.setOrganization(arrialDocVO.getOrganization());
            arrivalNoteOnServicePO.setUserName(arrialDocVO.getUserName());
            return this.dataService.insertArrivalNote(this.arrivalNoteOnServicePO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"提交营业厅到达单失败!");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
            return new ResultMsg(false,"输入的条形码对应订单不存在,请重新输入");
        } catch (InterruptWithExistedElementException e) {
            e.printStackTrace();
            return new ResultMsg(false,"添加营业厅到达单失败:单据编号已存在!");
        }
    }

    @Override
    public ResultMsg inputHallDeliverDoc(DeliverNoteOnServiceVO deliverDocVO) {
        return deliverDocVO.checkFormat();
    }

    @Override
    public ResultMsg submitHallDeliverDoc(DeliverNoteOnServiceVO deliverDocVO) {
        try {
            this.deliverNoteOnServicePO = deliverDocVO.toPO();
            this.deliverNoteOnServicePO.setOrganization(deliverDocVO.getOrganization());
            this.deliverNoteOnServicePO.setUserName(deliverDocVO.getUserName());
            return this.dataService.insertDeliverNote(this.deliverNoteOnServicePO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"提交营业厅装车单失败!");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
            return new ResultMsg(false,"输入的条形码对应订单不存在,请重新输入");
        } catch (InterruptWithExistedElementException e) {
            e.printStackTrace();
            return new ResultMsg(false,"提交营业厅装车单失败:单据编号已存在!");
        }
    }
}
