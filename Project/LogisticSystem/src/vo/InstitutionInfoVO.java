package vo;

import java.util.Hashtable;

/**
 * 期初建账使用的机构及其人员，车辆信息VO
 * 
 * @author kylin
 *
 */
public class InstitutionInfoVO {
	
	/**
	 * 机构名称
	 */
	private String name;
	
	/**
	 * 机构下设的职务与担任相应职务的人数
	 */
	private Hashtable<String,Integer> staff;

	/**
	 * 机构附属的车辆属性与相应车辆数目
	 */
	private Hashtable<String,Integer> cars;

	public InstitutionInfoVO(String name, Hashtable<String, Integer> staff, Hashtable<String, Integer> cars) {
		super();
		this.name = name;
		this.staff = staff;
		this.cars = cars;
	}
}
