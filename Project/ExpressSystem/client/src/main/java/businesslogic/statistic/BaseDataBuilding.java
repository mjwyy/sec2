package businesslogic.statistic;

import businesslogicservice.statisticblservice.BaseDataBuildingBLService;
import dataservice.statisticdataservice.BaseDataBuildingDataService;
import util.ResultMsg;
import vo.CommodityInfoVO;
import vo.FinanceVO;
import vo.InstitutionInfoVO;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/17.
 */
public class BaseDataBuilding implements BaseDataBuildingBLService {

    private BaseDataBuildingDataService dataBuildingDataService;

    @Override
    public ResultMsg restartWithoutBasis() {
        try {
            dataBuildingDataService.startBaseDataBuilding(false);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"无法开始无基础期初建账!");
        }
        return new ResultMsg(true,"已开始无基础期初建账!");
    }

    @Override
    public ResultMsg restartWithBasis() {
        try {
            dataBuildingDataService.startBaseDataBuilding(true);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"无法开始有基础期初建账!");
        }
        return new ResultMsg(true,"已开始有基础期初建账!");
    }

    @Override
    public ResultMsg endDataBuilding() {
        try {
            dataBuildingDataService.endBaseDataBuilding();
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"无法结束期初建账!");
        }
        return new ResultMsg(true,"期初建账成功!");
    }
}
