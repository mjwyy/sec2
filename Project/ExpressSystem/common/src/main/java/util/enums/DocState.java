package util.enums;

public enum DocState {
    NONCHECKED(0), // 未审批
    PASSED(1), //通过
    FAILED(2); // 不通过

    private int intState;

    DocState(int i) {
        this.intState = i;
    }

    public int getIntState() {
        return intState;
    }

    public static DocState getDocState(int i) {
        for (DocState state : values()) {
            if (state.intState == i)
                return state;
        }
        return null;
    }
}
