package vo;

/**
 * Created by kylin on 15/12/9.
 */
public class DistanceVO {

    String city1;

    String city2;

    double distance;

    public DistanceVO(String city1, String city2, double d) {
        super();
        this.city1 = city1;
        this.city2 = city2;
        this.distance = d;
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
