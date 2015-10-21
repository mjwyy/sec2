package po;

import java.io.Serializable;

public class UserPO implements Serializable {

	private static final long serialVersionUID = 3758641678884304726L;

	String account = null;
	String password = null;
	
	//用枚举需要前后统一
	String authority = null;
	
	
}
