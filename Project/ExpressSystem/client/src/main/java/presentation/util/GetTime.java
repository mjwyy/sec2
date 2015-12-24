package presentation.util;

/**
 * Created by kylin on 15/12/24.
 */
public class GetTime {
    public static String getTime(String date) {
    	String result = new String();
		for(int i = 0;i<date.length();i++){
			if(date.charAt(i) != '-')
				result+=date.charAt(i);
		}
		return result;
    }
}
