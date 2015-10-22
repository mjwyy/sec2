package businesslogicservice.statisticblservice;

import businesslogic.util.ResultMsg;
import vo.CommodityInfoVO;
import vo.FinanceInfoVO;
import vo.InstitutionInfoVO;

/**
 * 期初建账逻辑接口
 * 
 * @author kylin
 *
 */
public interface BaseDataBuildingBLService {
	
	/**
	 * 无基础期初建账，输入全新的机构，库存，财务信息
	 * 
	 * @return
	 */
	public ResultMsg restartWithoutBasis();
	
	/**
	 * 无基础期初建账操作添加机构信息
	 * 
	 * @param institutionVO
	 * @return
	 */
	public ResultMsg addInstitutionInfo(InstitutionInfoVO institutionVO);
	
	/**
	 * 无基础期初建账操作添加库存信息
	 * 
	 * @param commodityInfoVO
	 * @return
	 */
	public ResultMsg addCommodityInfo(CommodityInfoVO commodityInfoVO);
	
	/**
	 * 无基础期初建账操作添加财务信息
	 * 
	 * @param financeInfoVO
	 * @return
	 */
	public ResultMsg addFinanceInfo(FinanceInfoVO financeInfoVO);
	
	/**
	 * 有基础期初建账，输入修改后的或者未修改的的机构，库存，财务信息
	 * 
	 */
	public ResultMsg restartWithBasis();
	
	/**
	 * 开始以上年为基础的期初建账操作，修改机构信息
	 * 
	 * @param institutionVO
	 * @return
	 */
	public ResultMsg changeInstitutionInfo(InstitutionInfoVO institutionVO);
	
	/**
	 * 开始以上年为基础的期初建账操作，修改库存信息
	 * 
	 * @param commodityInfoVO
	 * @return
	 */
	public ResultMsg changeCommodityInfo(CommodityInfoVO commodityInfoVO);
	
	/**
	 * 开始以上年为基础的期初建账操作，修改财务信息
	 * 
	 * @param financeInfoVO
	 * @return
	 */
	public ResultMsg changeFinanceInfo(FinanceInfoVO financeInfoVO);
}
