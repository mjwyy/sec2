package po;

/**
 * 城市之间的距离po
 * @author kylin
 */
public class DistancePO {

	/**
	 * 城市1
	 */
	private String city1;
	
	/**
	 * 城市2
	 */
	private String city2;
	
	/**
	 * 城市1与2之间的距离
	 */
	private double distance;

	public DistancePO(String city1, String city2, double distance) {
		super();
		this.city1 = city1;
		this.city2 = city2;
		this.distance = distance;
	}

	public String getCity1() {
		return city1;
	}

	public String getCity2() {
		return city2;
	}

	public double getDistance() {
		return distance;
	}
	
}
