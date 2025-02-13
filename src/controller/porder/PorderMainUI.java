package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.SystemColor;

public class PorderMainUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Member member=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderMainUI frame = new PorderMainUI();
					frame.setLocation(100, 100);
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
	public PorderMainUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(SystemColor.info);
		panel1.setBounds(5, 5, 400, 60);
		contentPane.add(panel1);
		
		JLabel titleLabel = new JLabel("訂單主頁");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		titleLabel.setBounds(129, 21, 120, 29);
		panel1.add(titleLabel);
		
		JLabel usernameLabel = new JLabel("登入帳號:");
		usernameLabel.setFont(new Font("微軟正黑體", Font.BOLD, 9));
		usernameLabel.setBounds(302, 25, 98, 15);
		panel1.add(usernameLabel);
		
		member=(Member)Tool.read("member.txt");
		usernameLabel.setText("登入帳號: "+member.getUsername());
		
		
		JLabel dateTimeLabel = new JLabel("2025-01-16 22:38:34");
		dateTimeLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 9));
		dateTimeLabel.setBounds(302, 33, 98, 30);
		panel1.add(dateTimeLabel);
		// 時鐘
		Tool.updateDateTime(dateTimeLabel);	
		Timer timer = new Timer(1000, e -> Tool.updateDateTime(dateTimeLabel));
		timer.start();
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(SystemColor.info);
		panel2.setBounds(5, 74, 400, 180);
		contentPane.add(panel2);
		
		JButton btnNewButton = new JButton("新增訂單");
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPorderUI addporderui=new AddPorderUI();
				addporderui.setVisible(true);
				dispose();				
			}
		});
		btnNewButton.setBounds(144, 41, 103, 23);
		panel2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("管理訂單");
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				member=(Member)Tool.read("member.txt");
				if (!member.getRole().equals("Admin"))
				{
					JOptionPane.showMessageDialog(contentPane, "身份不是管理者, 無法使用!", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				PorderManagerUI pordermanager=new PorderManagerUI();
				pordermanager.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(144, 95, 103, 23);
		panel2.add(btnNewButton_1);
	}
}
