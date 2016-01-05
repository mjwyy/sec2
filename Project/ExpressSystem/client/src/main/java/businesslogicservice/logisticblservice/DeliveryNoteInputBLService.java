package businesslogicservice.logisticblservice;

import businesslogic.logistic.deliverystrategy.PriceStrategy;
import businesslogic.logistic.deliverystrategy.TimeStrategy;
import util.ResultMsg;
import vo.DeliveryNoteVO;

/**
 * 输入寄件单逻辑接口
 * 
 * @author kylin
 *
 */
public interface DeliveryNoteInputBLService {

	/**
	 * 快递员输入寄件单信息
	 *
	 * @param sendDocVO 寄件单VO
	 * @return 单据信息格式检查结果
	 */
	public ResultMsg inputSendDoc(DeliveryNoteVO sendDocVO);
	
	/**
	 * 快递员核对信息后要求提交单据
	 * 
	 * @param sendDocVO 寄件单VO
	 * @return 寄件报价、预计到达日期信息
	 */
    public ResultMsg submitSendDoc(DeliveryNoteVO sendDocVO);

    /**
     * 更改运费价格计算策略
     *
     * @param timeStrategy 价格计算策略
     */
    void setTimeStrategy(TimeStrategy timeStrategy);

    /**
     * 更改预计到达日期预测策略
     *
     * @param priceStrategy 日期预测策略
     */
    void setPriceStrategy(PriceStrategy priceStrategy);
}
