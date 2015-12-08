package connection.config;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kylin on 15/11/28.
 */
public class RMIConfig {

//    private static final HashMap<String,String> params;

    private static final String serverIP;
    private static final String port;

    public static boolean IS_DEBUG = false;

    static {
//            SAXReader reader = new SAXReader();
//        Document document = null;
//        try {
//            String root= System.getProperty("user.dir");
//            document = reader.read(root+"/config.xml");
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
//        Element common = document.getRootElement();
//            Element element = common.element("connection");
//            params = new HashMap<>();
//            @SuppressWarnings("unchecked")
//            List<Element> elements = element.elements("param");
//            for (Element e : elements){
//                params.put(e.attributeValue("key"),e.attributeValue("value"));
//            }
//            serverIP = params.get("serverIP");
//            port =  params.get("port");
        serverIP = "114.212.42.84";
        port = "1099";
    }

    public static String getServerIP() {
        return serverIP;
    }

    public static String getPort() {
        return port;
    }


}
