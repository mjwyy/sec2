package businesslogicservice.statisticblservice;

import businesslogic.util.ConstantType;
<<<<<<< HEAD
import businesslogic.util.PriceType;
=======
>>>>>>> master
import businesslogic.util.ResultMsg;

/**
 * 总经理调整业务数据的逻辑接口
 * 
 * @author kylin
 *
 */
public interface BusinessDataModificationBLService {
	
	/**
<<<<<<< HEAD
	 * 总经理选择修改业务数据类型
	 *
=======
	 * 前置条件：总经理要求修改业务数据
	 * 后置条件：系统提示总经理选择数据类别
	 * 
>>>>>>> master
	 * @param type
	 */
	public void selectConstantType(ConstantType type);
	
	/**
<<<<<<< HEAD
	 * 总经理要求价格常量
	 *
	 * @param price
	 * @return
	 */
	public ResultMsg inputPrice(PriceType type,double price);
	
	/**
	 * 总经理修改城市之间距离
	 *
=======
	 * 前置条件：总经理要求修改价格常量
	 * 后置条件：系统检查价格的格式正确性，如果错误给出相应提示
	 * 
	 * @param price
	 * @return
	 */
	public ResultMsg inputPrice(double price);
	
	/**
	 * 前置条件：总经理要求修改城市之间距离
	 * 后置条件：系统检查城市以及距离的格式和逻辑正确性，如果错误则给出相应提示
	 * 
>>>>>>> master
	 * @param city1
	 * @param city2
	 * @param distance
	 * @return
	 */
	public ResultMsg inputCityDistance(String city1,String city2,double distance);
	
	/**
<<<<<<< HEAD
	 * 总经理核对新的业务数据，要求提交
	 *
=======
	 * 前置条件：总经理核对新的业务数据，要求提交
	 * 后置条件：系统更新业务数据，只新的业务中采用新的数据
	 * 
>>>>>>> master
	 */
	public void submitChange();
}
