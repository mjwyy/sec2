package config;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.ObjectInputStream;

/**
 * Created by kylin on 15/11/28.
 */
public class ServerConfig {

    private static DatabaseConfig DATABASE_CONFIG = null;

    private static ConnectionConfig CONNECTION_CONFIG = null;

    private static final boolean IS_DEBUG = true;

    static {
        try {
            if (IS_DEBUG) {
                SAXReader reader = new SAXReader();
                Document document = reader.read("config/config.xml");
                Element server = document.getRootElement();
                DATABASE_CONFIG = new DatabaseConfig(server.element("database"));
              CONNECTION_CONFIG = new ConnectionConfig(server.element("connection"));
            }else{
            }
        }catch(DocumentException e){
            e.printStackTrace();
        }
    }

}
