/**
 * NOTEPO
 * 所有单据的父类
 * @author wqy
 * @date 2015/10/17
 */
package po;

import java.io.Serializable;

import businesslogic.util.DocState;

public class NotePO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5768739830941620932L;
<<<<<<< HEAD
	
=======
	// 创建这个单据的业务员信息
	private String userName;
>>>>>>> wqy
	private DocState state;

	public DocState getState() {
		return state;
	}

	public void setState(DocState state) {
		this.state = state;
	}
<<<<<<< HEAD
=======

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUserName() {
		return userName;
	}
>>>>>>> wqy

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
