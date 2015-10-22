package po;

import java.io.Serializable;

public class ChartPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4037472160296700871L;
	
	public static final int COST_AND_PROFIT = 0;
	public static final int BUSINESS_STATE = 1;
	
	int type = -1;
	String startTime = null;
	String endTime = null;
		
}
