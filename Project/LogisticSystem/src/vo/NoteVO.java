package vo;

/**
 * 所有单据VO的父类
 * 
 * @author kylin
 *
 */
public abstract class NoteVO {
	// 创建这个单据的业务员信息
	private String userName;
	
	// 总经理是否已经通过该单据的审批
	private boolean appproved;

	public String getUserName() {
		return userName;
	}

	public boolean isAppproved() {
		return appproved;
	}
}
