package businesslogicservice.statisticblservice;

import businesslogic.logistic.deliverystrategy.PriceInfo;
import util.ResultMsg;
import util.enums.PriceType;
import vo.DistanceVO;
import vo.PriceVO;

import java.util.ArrayList;

/**
 * 总经理调整业务数据的逻辑接口
 * 
 * @author kylin
 *
 */
public interface BusinessDataModificationBLService {

    /**
     * 获取数据库中所有的价格信息
     * @return 价格的类型与数量
     */
    ArrayList<PriceVO> getAllPrices();

    /**
     * 总经理要求价格常量
     *
     * @param price
     * @return
     */
    ResultMsg inputPrice(PriceType type,double price);

    /**
     * 总经理核对新的业务数据，要求提交
     *
     */
    ResultMsg submitPrice(PriceType type, double price);

    /**
     * 查询所有的城市间距离信息
     *
     * @return 城市1城市2与距离
     */
    ArrayList<DistanceVO> getAllDistanceInfo();

    /**
     * 总经理输入欲修改的城市之间距离信息
     *
     * @param city1 城市1
     * @param city2 城市2
     * @param distance 城市间距离
     * @return 格式检查结果
     */
    ResultMsg inputCityDistance(String city1,String city2,double distance);

    /**
     * 总经理提交修改的城市之间距离信息
     *
     * @param city1 城市1
     * @param city2 城市2
     * @param distance 城市间距离
     * @return 距离信息修改结果
     */
    ResultMsg submitCityDistance(String city1, String city2, double distance);
}
