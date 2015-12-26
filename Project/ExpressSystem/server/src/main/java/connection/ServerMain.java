package connection;

import connection.config.RMIConfig;
import connection.config.ServerFrame;

import java.awt.*;

/**
 * Created by kylin on 15/11/21.
 */
public class ServerMain {

    public static void main(String[] args) {
//        ServerFrame frame = new ServerFrame();
//        frame.setVisible(true);
        String IP = args[0];
        String port = args[1];
        RMIConfig.setServerIPAndPort(IP,port);
        if(RMIPublisher.buildConnection())
            System.out.println("服务器已建立!");
    }
}
