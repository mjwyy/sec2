/**
 * NOTEPO
 * 所有单据的父类
 * @author wqy
 * @date 2015/10/17
 */
package po;

import java.io.Serializable;

import util.enums.DocState;

public class NotePO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5768739830941620932L;
	// 创建这个单据的业务员信息
	private String userName;
	private DocState state;

	public DocState getState() {
		return state;
	}

	public void setState(DocState state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUserName() {
		return userName;
	}

}
