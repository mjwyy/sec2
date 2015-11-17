package businesslogic.statistic;

import businesslogicservice.statisticblservice.BaseDataBuildingBLService;
import util.ResultMsg;
import vo.CommodityInfoVO;
import vo.FinanceVO;
import vo.InstitutionInfoVO;

/**
 * Created by kylin on 15/11/17.
 */
public class BaseDataBuilding implements BaseDataBuildingBLService {
    @Override
    public ResultMsg restartWithoutBasis() {
        return null;
    }

    @Override
    public ResultMsg addInstitutionInfo(InstitutionInfoVO institutionVO) {
        return null;
    }

    @Override
    public ResultMsg addCommodityInfo(CommodityInfoVO commodityInfoVO) {
        return null;
    }

    @Override
    public ResultMsg addFinanceInfo(FinanceVO financeInfoVO) {
        return null;
    }

    @Override
    public ResultMsg restartWithBasis() {
        return null;
    }

    @Override
    public ResultMsg changeInstitutionInfo(InstitutionInfoVO institutionVO) {
        return null;
    }

    @Override
    public ResultMsg changeCommodityInfo(CommodityInfoVO commodityInfoVO) {
        return null;
    }

    @Override
    public ResultMsg changeFinanceInfo(FinanceVO financeInfoVO) {
        return null;
    }

    @Override
    public ResultMsg endDataBuilding() {
        return null;
    }
}
