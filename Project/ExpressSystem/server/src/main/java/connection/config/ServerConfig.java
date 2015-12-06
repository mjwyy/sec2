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

    private static final boolean IS_DEBUG = true;

    static {
        try {
            if (IS_DEBUG) {
                SAXReader reader = new SAXReader();
                Document document = reader.read("server/src/main/java/connection/config/config.xml");
                Element server = document.getRootElement();
                DATABASE_CONFIG = new DatabaseConfig(server.element("database"));
            }else{
                ObjectInputStream obj = new ObjectInputStream(
                        new FileInputStream("connection/config/databaseConfig.dat"));
                DATABASE_CONFIG = (DatabaseConfig) obj.readObject();
                obj = new ObjectInputStream(
                        new FileInputStream("connection/config/connectionConfig.dat"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConfig getDatabaseConfig() {
        return DATABASE_CONFIG;
    }

}
