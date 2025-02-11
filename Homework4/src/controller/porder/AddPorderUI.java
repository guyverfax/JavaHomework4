package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.member.LoginUI;
import model.Member;
import model.Porder;
import service.impl.PorderServiceImpl;
import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class AddPorderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Member member=(Member)Tool.read("member.txt");
	private static PorderServiceImpl porderserviceimpl = new PorderServiceImpl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPorderUI frame = new AddPorderUI();
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
	public AddPorderUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(Color.BLACK);
		panel1.setBounds(0, 0, 483, 54);
		contentPane.add(panel1);
		
		JLabel lblNewLabel = new JLabel("新增訂單");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		lblNewLabel.setBounds(120, 10, 222, 34);
		panel1.add(lblNewLabel);
		
		JLabel usernameLabel = new JLabel("登入帳號:");
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setFont(new Font("微軟正黑體", Font.BOLD, 9));
		usernameLabel.setBounds(369, 19, 70, 15);
		panel1.add(usernameLabel);
		member=(Member)Tool.read("member.txt");
		usernameLabel.setText("登入帳號: "+member.getUsername());
		
		JLabel dateTimeLabel = new JLabel("2025-01-16 22:38:34");
		dateTimeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dateTimeLabel.setForeground(Color.WHITE);
		dateTimeLabel.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 9));
		dateTimeLabel.setBounds(369, 39, 104, 15);
		panel1.add(dateTimeLabel);	
		// 時鐘
		Tool.updateDateTime(dateTimeLabel);	
		Timer timer = new Timer(1000, e -> Tool.updateDateTime(dateTimeLabel));
		timer.start();
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(SystemColor.info);
		panel2.setBounds(0, 64, 204, 233);
		contentPane.add(panel2);
		
		JLabel nameLabel = new JLabel("顧客名字:");
		nameLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		nameLabel.setBounds(10, 10, 157, 25);
		panel2.add(nameLabel);
		nameLabel.setText("顧客名字: "+member.getName());
		
		JLabel appleLabel = new JLabel("蘋果(50元/個)");
		appleLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		appleLabel.setBounds(10, 47, 97, 25);
		panel2.add(appleLabel);
		
		JLabel bananaLabel = new JLabel("香蕉(20元/根)");
		bananaLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		bananaLabel.setBounds(10, 82, 97, 25);
		panel2.add(bananaLabel);
		
		JLabel lemonLabel = new JLabel("檸檬(30元/顆)");
		lemonLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lemonLabel.setBounds(10, 117, 91, 25);
		panel2.add(lemonLabel);	
		
		JComboBox appleComboBox = new JComboBox();
		appleComboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		appleComboBox.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		appleComboBox.setBounds(117, 47, 50, 23);
		panel2.add(appleComboBox);
		
		JComboBox bananaComboBox = new JComboBox();
		bananaComboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		bananaComboBox.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		bananaComboBox.setBounds(117, 86, 50, 23);
		panel2.add(bananaComboBox);
		
		JComboBox lemonComboBox = new JComboBox();
		lemonComboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "9", "10"}));
		lemonComboBox.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lemonComboBox.setBounds(117, 121, 50, 23);
		panel2.add(lemonComboBox);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(SystemColor.info);
		panel3.setBounds(214, 64, 269, 233);
		contentPane.add(panel3);
		panel3.setLayout(null);
		
		JLabel outputLabel = new JLabel("訂單內容");
		outputLabel.setHorizontalAlignment(SwingConstants.LEFT);
		outputLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		outputLabel.setBounds(10, 10, 87, 15);
		panel3.add(outputLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 237, 147);
		panel3.add(scrollPane);
		
		JTextArea outputArea = new JTextArea();
		scrollPane.setViewportView(outputArea);
		outputArea.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		outputArea.setText("");
		
		//==========Button==========
		ActionListener comboBoxListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	outputArea.setText("");
            }
        };
        
        appleComboBox.addActionListener(comboBoxListener);
        bananaComboBox.addActionListener(comboBoxListener);
        lemonComboBox.addActionListener(comboBoxListener);
        
		JButton addButton = new JButton("新增");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name=member.getName();				
				String Apple=(String)appleComboBox.getSelectedItem();
				String Banana=(String)bananaComboBox.getSelectedItem();
				String Lemon=(String)lemonComboBox.getSelectedItem();
				int newApple=Integer.parseInt(Apple);
				int newBanana=Integer.parseInt(Banana);
				int newLemon=Integer.parseInt(Lemon);				
				Porder porder=new Porder(Name,newApple,newBanana,newLemon); //暫時存放
				outputArea.setText(porder.getShowDetail(member.getAddress(),member.getPhone()));
			}
		});
		
		JButton clearButton = new JButton("清除");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appleComboBox.setSelectedItem("0");
				bananaComboBox.setSelectedItem("0");
				lemonComboBox.setSelectedItem("0");
				outputArea.setText("");
			}
		});
		clearButton.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		clearButton.setBounds(104, 159, 65, 30);
		panel2.add(clearButton);
		
		JButton nextButton = new JButton("結帳");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (outputArea.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(contentPane, "金額為0, 請新增再按下一步!", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String Name=member.getName();				
				String Apple=(String)appleComboBox.getSelectedItem();
				String Banana=(String)bananaComboBox.getSelectedItem();
				String Lemon=(String)lemonComboBox.getSelectedItem();
				int newApple=Integer.parseInt(Apple);
				int newBanana=Integer.parseInt(Banana);
				int newLemon=Integer.parseInt(Lemon);				
				Porder porder=new Porder(Name,newApple,newBanana,newLemon); //暫時存放
				outputArea.setText(porder.getShowDetail(member.getAddress(),member.getPhone()));
				JOptionPane.showMessageDialog(contentPane, "訂單成立, 回到訂單主頁!");
				porderserviceimpl.createPorder(porder);
				Tool.save(porder, "porder.txt");
				Tool.goPorderMainUI(AddPorderUI.this);
				dispose();
			}
		});
		nextButton.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		nextButton.setBounds(182, 202, 65, 23);
		panel3.add(nextButton);
		
		JButton printButton = new JButton("列印");
		printButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (outputArea.getText().equals(""))
					{
						JOptionPane.showMessageDialog(contentPane, "請先新增訂單", "錯誤", JOptionPane.ERROR_MESSAGE);
						return;
					}
					outputArea.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		printButton.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		printButton.setBounds(10, 202, 65, 23);
		panel3.add(printButton);
		
		addButton.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		addButton.setBounds(20, 159, 65, 30);
		panel2.add(addButton);
	}
}
