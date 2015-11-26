package util.enums;

/**
 * 货物到达状态常量
 * 
 * @author kylin
 *
 */
public enum GoodsState {
    COMPLETE("完整"),
    DAMAGED("损坏"),
    LOST("丢失"),
    RECEIVED("已收件");

    GoodsState(String s) {
        this.string = s;
    }

    String string;

    @Override
    public String toString() {
        return this.string;
    }

    public static void main(String[] args) {
        System.out.println(GoodsState.RECEIVED.toString());
    }
}
