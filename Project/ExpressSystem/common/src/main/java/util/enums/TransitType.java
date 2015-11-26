package util.enums;

/**
 * Created by kylin on 15/11/26.
 */
public enum TransitType {

    Car("汽车"),
    Train("火车"),
    Aircraft("飞机");

    private String type;

    TransitType(String s) {
        this.type = s;
    }

    @Override
    public String toString() {
        return this.type;
    }

}
