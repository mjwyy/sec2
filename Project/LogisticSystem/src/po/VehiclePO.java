package po;

import java.io.File;
import java.io.Serializable;

public class VehiclePO implements Serializable {

	private static final long serialVersionUID = -843114324702086467L;

	String carNumber = null;
	String hallNumber = null;
	File picture = null;
	
	/*
	 * 用开始使用时间代替已使用时间
	 */
	String firstUseTime = null;
	
}
