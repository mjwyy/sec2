package connection.config;

/**
 * Created by kylin on 15/11/28.
 */
public class RMIConfig {

//    private static final HashMap<String,String> params;

    public static String serverIP;
    public static String port;

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
        //TODO RMI配置移出代码
        serverIP = "localhost";
        port = "1099";
    }

    public static String getServerIP() {
        return serverIP;
    }

    public static String getPort() {
        return port;
    }

    public static void setServerIP(String serverIP) {
        RMIConfig.serverIP = serverIP;
    }

    public static void setPort(String port) {
        RMIConfig.port = port;
    }
}
