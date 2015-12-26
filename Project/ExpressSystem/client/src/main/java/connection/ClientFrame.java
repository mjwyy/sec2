package connection;

import util.FormatCheck;
import util.ResultMsg;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientFrame extends JFrame {

    private JPanel contentPane;
    private JTextField serverIP;
    private JTextField port;
    private JLabel lblMinjw;
    private JLabel tips;
    private JLabel lblServer;
    private JLabel state1;
    private JLabel state2;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {

    }

    /**
     * Create the frame.
     */
    public ClientFrame() {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setLocation((screenWidth-450)>>1, (screenHeight-300)>>1);
        contentPane = new JPanel(){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon img = new ImageIcon("image/serverBackground.jpg");
                g.drawImage(img.getImage(), 0, 0, null);
                float lineWidth = 3.0f;
                ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
                g.drawLine(768, 0, 768, 500);
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblIp = new JLabel("IP:");
        lblIp.setBounds(39, 68, 61, 16);
        contentPane.add(lblIp);

        JLabel lblPort = new JLabel("port:");
        lblPort.setBounds(39, 137, 61, 16);
        contentPane.add(lblPort);

        serverIP = new JTextField();
        serverIP.setBounds(76, 62, 282, 45);
        contentPane.add(serverIP);
        serverIP.setColumns(10);

        port = new JTextField();
        port.setBounds(76, 137, 282, 51);
        contentPane.add(port);
        port.setColumns(10);

        lblMinjw = new JLabel("MinJW物流管理系统客户端(●°u°●)​ 」");
        lblMinjw.setBounds(39, 19, 305, 31);
        contentPane.add(lblMinjw);

        JButton button = new JButton("启动");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!(serverIP.getText().isEmpty()||port.getText().isEmpty())){
                    String aserverIP = serverIP.getText();
                    String aport = port.getText();
                    System.out.println("ip = " + aserverIP);
                    System.out.println("port = " + aport);
                    ResultMsg IPMeg = FormatCheck.isIP(aserverIP);
                    ResultMsg PortMsg = FormatCheck.isPort(aport);

                    if(!IPMeg.isPass()){
                        //TODO 界面弹出提示框显示IPMsg里面的字符串
                        String infoToDisplay = IPMeg.getMessage();
                        System.out.println(infoToDisplay);
                    } else if(!PortMsg.isPass()){
                        //TODO 界面弹出提示框显示IPMsg里面的字符串
                        String infoToDisplay = PortMsg.getMessage();
                        System.out.println(infoToDisplay);
                    } else {
                        //通过格式检查
                        RMIHelper.setServerIP(aserverIP);
                        RMIHelper.setServerPort(aport);
                        try {
                            RMIHelper.tryConnect();
                            dispose();
                        } catch (RemoteException e1) {
                            showStatus(true,false);
                        } catch (NotBoundException e1) {
                            showStatus(true,false);
                        }
                    }

                }else {
                    tips.setVisible(true);
                    showStatus(true,false);
                }
            }
        });
        button.setBounds(240, 215, 117, 29);
        contentPane.add(button);

        tips = new JLabel("请填完整信息再确认");
        tips.setBounds(250, 245, 125, 16);
        contentPane.add(tips);
        tips.setVisible(false);

        state1 = new JLabel("正在连接,请稍后.......");
        state1.setBounds(39, 302, 319, 31);
        contentPane.add(state1);
        state1.setVisible(true);

        state2 = new JLabel("running……");
        state2.setBounds(39, 302, 319, 31);
        contentPane.add(state2);
        state2.setVisible(false);

    }

    public void showStatus(boolean stop,boolean run) {
        state1.setVisible(stop);
        state2.setVisible(run);
    }
}
