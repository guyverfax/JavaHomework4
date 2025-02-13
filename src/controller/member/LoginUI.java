package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import controller.porder.PorderMainUI;
import model.Member;
import service.impl.MemberServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(5, 5, 400, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel titleLabel = new JLabel("會員登入");
		titleLabel.setBackground(SystemColor.inactiveCaption);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		titleLabel.setBounds(135, 10, 150, 30);
		panel.add(titleLabel);
		
		JLabel dateTimeLabel = new JLabel("2025-01-16 22:38:34");
		dateTimeLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 9));
		dateTimeLabel.setBounds(302, 30, 98, 30);
		panel.add(dateTimeLabel);
		// 時鐘
		Tool.updateDateTime(dateTimeLabel);	
		Timer timer = new Timer(1000, e -> Tool.updateDateTime(dateTimeLabel));
		timer.start();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(5, 74, 400, 180);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel usernameLabel = new JLabel("帳號:");
		usernameLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		usernameLabel.setBounds(119, 24, 66, 15);
		panel_1.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("密碼:");
		passwordLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		passwordLabel.setBounds(119, 52, 66, 15);
		panel_1.add(passwordLabel);
		
		username = new JTextField();
		username.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		username.setBounds(185, 20, 96, 21);
		panel_1.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(185, 48, 96, 21);
        panel_1.add(password);
		
		JButton loginButton = new JButton("登入");
		loginButton.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=username.getText().trim();
				String Password = new String(((JPasswordField) password).getPassword());
				
				if (Username.isEmpty() || Password.isEmpty()) {
		            JOptionPane.showMessageDialog(LoginUI.this, "帳號或密碼不能為空", "錯誤", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
				
				Member member=new MemberServiceImpl().readMemberByUsernamePassword(Username, Password);
				
				if(member!=null)
				{
					Tool.save(member, "member.txt");
					LoginSuccessUI loginsuccess=new LoginSuccessUI();
					loginsuccess.setVisible(true);
					dispose();
				}
				else
				{
					LoginErrorUI loginerror=new LoginErrorUI();
					loginerror.setVisible(true);
					dispose();
				} 
			}
		});
		loginButton.setBounds(99, 99, 85, 23);
		panel_1.add(loginButton);
		
		JButton loginButton_1 = new JButton("註冊");
		loginButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		loginButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddMemberUI addmember=new AddMemberUI();
				addmember.setVisible(true);
				dispose();
			}
		});
		loginButton_1.setBounds(218, 99, 85, 23);
		panel_1.add(loginButton_1);
	}

}
