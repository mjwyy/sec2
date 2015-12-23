package connection.config;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;

/**
 * Created by kylin on 15/11/28.
 */
public class ServerConfig {

    private static DatabaseConfig DATABASE_CONFIG = null;

    static {
//        try {
//            SAXReader reader = new SAXReader();
//            Document document = reader.read("src/main/java/connection/config/databaseConfig.xml");
//            Element server = document.getRootElement();
//            DATABASE_CONFIG = new DatabaseConfig(server.element("database"));
//        }  catch (DocumentException e) {
//            e.printStackTrace();
//        }
        //TODO 数据库配置写入代码
        DATABASE_CONFIG = new DatabaseConfig();
    }

    public static DatabaseConfig getDatabaseConfig() {
        return DATABASE_CONFIG;
    }

}
