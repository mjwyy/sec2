package util;

//TODO 多客户端并发这个类的信息被覆盖
public class RuntimeUserInfo {

    /**
     * 用户的姓名
     */
    private static String userName = null;

    /**
     * 用户所在机构的名称
     */
    private static String userOrgName = null;
	
	private RuntimeUserInfo() {	}
	
	public static void setUserName(String num) {
		userName = num;
	}
	
	public static String getNum() {
		return userName;
	}

    public static String getUserOrgName() {
        return userOrgName;
    }

    public static void setUserOrgName(String userOrgName) {
        RuntimeUserInfo.userOrgName = userOrgName;
    }
}
