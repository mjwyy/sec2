package vo;

public class VehicleInfoVO {
	
	/**
	 * 车辆代号
	 */
	private String vehiclecode;
	
	/**
	 * 车牌号
	 */
	private String platenumber;
	
	/**
	 * 服役实现
	 */
	private String serviceTimeLimit;
	
	/**
	 * 
	 * @param vehiclecode
	 * @param platenumber
	 * @param serviceTimeLimit
	 */
	public VehicleInfoVO(String vehiclecode,String platenumber,String serviceTimeLimit){
		this.vehiclecode = vehiclecode;
		this.platenumber = platenumber;
		this.serviceTimeLimit =serviceTimeLimit;
	}

	public String getVehiclecode() {
		return vehiclecode;
	}

	public String getPlatenumber() {
		return platenumber;
	}

	public String getServiceTimeLimit() {
		return serviceTimeLimit;
	}
}
