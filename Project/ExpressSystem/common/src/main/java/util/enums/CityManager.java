package util.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kylin on 15/11/26.
 */
public class CityManager {

    private final static HashMap<String, String> citys = new HashMap<>();
    private final static ArrayList<String> All_CITYS = new ArrayList<>();

    static {
        citys.put("北京", "beiJing");
        citys.put("南京", "nanJing");
        citys.put("广州", "guangZhou");
        citys.put("上海", "shangHai");
        All_CITYS.add("北京");
        All_CITYS.add("南京");
        All_CITYS.add("广州");
        All_CITYS.add("上海");
    }

    public static String getCityName(String senderAddress) {
        for (String regex : All_CITYS) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(senderAddress);
            if (matcher.find()) {
                return citys.get(regex);
            } else {
                continue;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(CityManager.getCityName("广州省南京市金山区金山铁路"));
    }
}
