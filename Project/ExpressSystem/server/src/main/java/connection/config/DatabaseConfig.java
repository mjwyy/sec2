package connection.config;

import org.dom4j.Element;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kylin on 15/11/28.
 */
public class DatabaseConfig {

    private final HashMap<String,String> params;

    /**
     * 大家文件读写总是有错误,搞不懂
     *
     * @param element
     */
    public DatabaseConfig(Element element){
        this.params = new HashMap<String, String>();
        @SuppressWarnings("unchecked")
        List<Element> elements = element.elements("param");
        for (Element e : elements){
            this.params.put(e.attributeValue("key"),e.attributeValue("value"));
        }
    }

    /**
     * 测试用写死
     */
    public DatabaseConfig(){
        this.params = new HashMap<String, String>();
        params.put("dbDriver","com.mysql.jdbc.Driver");
        params.put("dbLocation","jdbc:mysql://localhost:3306/Express");
        params.put("dbUnicode","useUnicode=true");
        params.put("dbEncoding","characterEncoding=UTF-8");
        params.put("dbUser","root");
        params.put("dbPassword","861910");
    }

    public HashMap<String, String> getParams() {
        return params;
    }

}
