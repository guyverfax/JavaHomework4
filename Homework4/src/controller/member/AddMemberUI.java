package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;

import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class AddMemberUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField addressField;
	private JTextField phoneField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMemberUI frame = new AddMemberUI();
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
	public AddMemberUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(SystemColor.inactiveCaption);
		panel1.setBounds(5, 5, 400, 60);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel registerLabel = new JLabel("會員註冊");
		registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registerLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		registerLabel.setBounds(135, 10, 150, 30);
		panel1.add(registerLabel);
		
		JLabel dateTimeLabel = new JLabel("2025-01-16 22:38:34");
		dateTimeLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 9));
		dateTimeLabel.setBounds(302, 30, 98, 30);
		panel1.add(dateTimeLabel);
		
		Tool.updateDateTime(dateTimeLabel);	
		Timer timer = new Timer(1000, e -> Tool.updateDateTime(dateTimeLabel));
		timer.start();
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(SystemColor.inactiveCaption);
		panel2.setBounds(5, 75, 400, 349);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		JLabel nameLabel = new JLabel("姓名");
		nameLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		nameLabel.setBounds(113, 201, 46, 15);
		panel2.add(nameLabel);
		
		JLabel usernameLabel = new JLabel("帳號");
		usernameLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		usernameLabel.setBounds(106, 44, 46, 42);
		panel2.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("密碼");
		passwordLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		passwordLabel.setBounds(106, 90, 46, 14);
		panel2.add(passwordLabel);
		
		JLabel addressLabel = new JLabel("地址");
		addressLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		addressLabel.setBounds(113, 232, 46, 15);
		panel2.add(addressLabel);
		
		JLabel phoneLabel = new JLabel("電話");
		phoneLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		phoneLabel.setBounds(113, 260, 46, 15);
		panel2.add(phoneLabel);
		
		JLabel roleLabel = new JLabel("身份");
		roleLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		roleLabel.setBounds(106, 117, 46, 15);
		panel2.add(roleLabel);
		
		nameField = new JTextField();
		nameField.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		nameField.setBounds(157, 198, 96, 21);
		panel2.add(nameField);
		nameField.setColumns(10);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		usernameField.setColumns(10);
		usernameField.setBounds(157, 55, 96, 21);
		panel2.add(usernameField);
		
		passwordField = new JPasswordField();
        passwordField.setBounds(157, 83, 96, 21);
        panel2.add(passwordField);
		
		addressField = new JTextField();
		addressField.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		addressField.setColumns(10);
		addressField.setBounds(157, 229, 96, 21);
		panel2.add(addressField);
		
		phoneField = new JTextField();
		phoneField.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		phoneField.setColumns(10);
		phoneField.setBounds(157, 258, 96, 21);
		panel2.add(phoneField);
		
		String[] roleType = Tool.getRole();	
		JComboBox roleField = new JComboBox(roleType);
		roleField.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		roleField.setBounds(157, 114, 96, 23);
		panel2.add(roleField);
		
		JButton registerButton = new JButton("註冊");
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=usernameField.getText();
				
				if(new MemberServiceImpl().checkIfUsernameExists(Username))
				{
					AddMemberErrorUI addmembererror=new AddMemberErrorUI();
					addmembererror.setVisible(true);
					dispose();
				}
				else
				{
					String Name=nameField.getText();
					String Password= new String(((JPasswordField) passwordField).getPassword());
					String Address=addressField.getText();
					String Phone=phoneField.getText();
					String Role=(String)roleField.getSelectedItem();
					
					if (Name.isEmpty() || Username.isEmpty() || Password.isEmpty() || Address.isEmpty() || Phone.isEmpty() )
					{
						JOptionPane.showMessageDialog(AddMemberUI.this, "欄位不能為空", "錯誤", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					if (!Tool.isValidPassword(Password)) {
			            JOptionPane.showMessageDialog(AddMemberUI.this, "密碼至少1個英文字母、1個符號、1個數字，且長度為1-5個字元", "錯誤", JOptionPane.ERROR_MESSAGE);
			            return;
			        }
					
					Member member=new Member(Name,Username,Password,Address,Phone,Role);
					
					new MemberServiceImpl().createMember(member);
					
					AddMemberSuccessUI addmembersuccess=new AddMemberSuccessUI();
					addmembersuccess.setVisible(true);
					dispose();
				}
			}
		});
		registerButton.setBounds(157, 298, 85, 23);
		panel2.add(registerButton);
		
		JLabel lblNewLabel = new JLabel("*基本資料*");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(113, 170, 156, 15);
		panel2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("*註冊資料*");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(113, 30, 156, 15);
		panel2.add(lblNewLabel_1);
		

	
	}
}
