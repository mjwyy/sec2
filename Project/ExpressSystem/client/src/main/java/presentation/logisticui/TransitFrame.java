package presentation.logisticui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.io.File;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;

import presentation.util.welcomPanel;

public class TransitFrame extends JFrame {

	private JPanel contentPane;
	private welcomPanel welcome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransitFrame frame = new TransitFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TransitFrame() {
		setBackground(new Color(153, 204, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 548);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		welcome = new welcomPanel();
		welcome.setBounds(118, 88, 737, 390);
		contentPane.add(welcome);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 853, 63);
		contentPane.add(panel);
		
		JLabel lblL = new JLabel();
		panel.add(lblL);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		panel_1.setBounds(0, 63, 853, 23);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(6, 0, 132, 22);
		panel_1.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("系统（S）");
		menuBar.add(mnNewMenu);
		
		JMenu mnf = new JMenu("功能（F）");
		menuBar.add(mnf);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, Color.GRAY));
		panel_2.setBounds(0, 476, 415, 49);
		contentPane.add(panel_2);
		
		JButton btnNewButton = new JButton("录入到达单");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrivalNoteOnTransitPanel anot = new ArrivalNoteOnTransitPanel();
				anot.setBounds(118, 88, 815, 387);
				contentPane.remove(contentPane.getComponentAt(118, 88));
				contentPane.add(anot);
				contentPane.repaint();
			}
		});
		btnNewButton.setBounds(0, 85, 117, 130);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("录入中转单");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TransitNoteInputPanel tni = new TransitNoteInputPanel();
			tni.setBounds(118, 88, 815, 387);
			contentPane.remove(contentPane.getComponentAt(118, 88));
			contentPane.add(tni);
			contentPane.repaint();
			}
		});
		btnNewButton_1.setBounds(0, 214, 117, 130);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("录入装车单");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadNoteOnTransitPanel lnot = new LoadNoteOnTransitPanel();
				lnot.setBounds(118, 88, 815, 387);
				contentPane.remove(contentPane.getComponentAt(118, 88));
				contentPane.add(lnot);
				contentPane.repaint();
			}
		});
		btnNewButton_2.setBounds(0, 345, 117, 130);
		contentPane.add(btnNewButton_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(413, 476, 442, 49);
		contentPane.add(panel_3);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, Color.GRAY));
		
		
		
	}
}
