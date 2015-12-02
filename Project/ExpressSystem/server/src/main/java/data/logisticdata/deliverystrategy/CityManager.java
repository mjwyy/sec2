package data.logisticdata.deliverystrategy;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kylin on 15/11/30.
 */
public class CityManager {

    /**
     * 从一个详细的现实业务地址中获取有效的城市名称
     *
     * @param citys 公司业务已覆盖的所有城市
     * @param senderAddress 现实地址
     * @return 从地址中找到的城市(如果存在)
     */
    public String findCity(ArrayList<String> citys, String senderAddress) {
        for (String regex : citys) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(senderAddress);
            if (matcher.find())
                return regex;
        }
        return null;
    }
}
