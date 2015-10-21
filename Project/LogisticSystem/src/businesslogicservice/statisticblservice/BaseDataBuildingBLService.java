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
	 * 前置条件：财务人员要求进行无基础建账操作
	 * 后置条件：系统提示期初建账成功，更新相应信息，生成待查副本，记录日志
	 * 
	 * @return
	 */
	public ResultMsg restartWithoutBasis();
	
	/**
	 * 前置条件：财务人员开始无基础期初建账操作
	 * 后置条件：系统存储机构信息，并反馈机构信息保存成功
	 * 
	 * @param institutionVO
	 * @return
	 */
	public ResultMsg addInstitutionInfo(InstitutionInfoVO institutionVO);
	
	/**
	 * 前置条件：系统已存储机构信息
	 * 后置条件：系统存储各个仓库当前库存信息，反馈库存信息保存成功，并要求输入初始银行账户信息
	 * 
	 * @param commodityInfoVO
	 * @return
	 */
	public ResultMsg addCommodityInfo(CommodityInfoVO commodityInfoVO);
	
	/**
	 * 前置条件：系统已存储库存信息
	 * 后置条件：系统存储财务信息，提示期初建账成功，自动生成待查副本，记录系统日志记录
	 * 
	 * @param financeInfoVO
	 * @return
	 */
	public ResultMsg addFinanceInfo(FinanceInfoVO financeInfoVO);
	
	/**
	 * 有基础期初建账，输入修改后的或者未修改的的机构，库存，财务信息
	 * 前置条件：财务人员要求进行以上年为基础的建账操作
	 * 后置条件：系统提示期初建账成功，更新相应信息，生成待查副本，记录日志
	 * 
	 * @param institutionVO
	 * @param commodityInfoVO
	 * @param financeInfoVO
	 * @return
	 */
	public ResultMsg restartWithBasis();
	
	/**
	 * 前置条件：财务人员开始以上年为基础的期初建账操作
	 * 后置条件：系统存储新的机构信息，并反馈机构信息保存成功
	 * 
	 * @param institutionVO
	 * @return
	 */
	public ResultMsg changeInstitutionInfo(InstitutionInfoVO institutionVO);
	
	/**
	 * 前置条件：系统已存储机构信息
	 * 后置条件：系统存储各个仓库新的库存信息，反馈库存信息保存成功，并要求输入初始银行账户信息
	 * 
	 * @param commodityInfoVO
	 * @return
	 */
	public ResultMsg changeCommodityInfo(CommodityInfoVO commodityInfoVO);
	
	/**
	 * 前置条件：系统已存储库存信息
	 * 后置条件：系统存储新的财务信息，提示期初建账成功，自动生成待查副本，记录系统日志记录
	 * 
	 * @param financeInfoVO
	 * @return
	 */
	public ResultMsg changeFinanceInfo(FinanceInfoVO financeInfoVO);
}
