package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.member.AddMemberUI;
import controller.member.LoginSuccessUI;
import model.Member;
import model.Porder;
import service.impl.MemberServiceImpl;
import service.impl.PorderServiceImpl;
import util.PorderTableModel;
import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class PorderManagerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
    private PorderTableModel tableModel;
	private static Member member=(Member)Tool.read("member.txt");
	private static PorderServiceImpl porderserviceimpl = new PorderServiceImpl();
	private static MemberServiceImpl memberserviceimpl = new MemberServiceImpl();
	final int APPLE_PRICE = 50;
    final int BANANA_PRICE = 20;
    final int LEMON_PRICE = 30;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderManagerUI frame = new PorderManagerUI();
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
	public PorderManagerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(Color.BLACK);
		panel1.setBounds(0, 0, 483, 54);
		contentPane.add(panel1);
		
		JLabel lblNewLabel = new JLabel("訂單管理");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		lblNewLabel.setBounds(120, 10, 222, 34);
		panel1.add(lblNewLabel);
		
		JLabel usernameLabel = new JLabel("登入帳號: <dynamic>");
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setFont(new Font("微軟正黑體", Font.BOLD, 9));
		usernameLabel.setBounds(369, 19, 95, 15);
		panel1.add(usernameLabel);
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
        panel2.setBounds(8, 64, 467, 37);
        contentPane.add(panel2);
        panel2.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("庫存訂單  (點訂單再編輯或刪除按鈕)");
        lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
        lblNewLabel_1.setBounds(0, 10, 254, 27);
        panel2.add(lblNewLabel_1);
        
		JPanel panel3 = new JPanel();
		panel3.setBounds(8, 98, 475, 231);
		contentPane.add(panel3);
		panel3.setLayout(null);
	
		List<Porder> porder=new ArrayList();
		porder=porderserviceimpl.readAllPorder();
		
		// 設定 TableModel
        tableModel = new PorderTableModel(porder);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        // 設定 JTable 的位置和大小
        scrollPane.setBounds(0, 10, 465, 208);
        panel3.add(scrollPane);
        
        JPanel panel4 = new JPanel();
        panel4.setBounds(8, 339, 467, 53);
        contentPane.add(panel4);
        panel4.setLayout(null);
        
        JButton editButton = new JButton("編輯");
        editButton.setFont(new Font("微軟正黑體", Font.BOLD, 12));
        editButton.setBounds(10, 10, 70, 29);
        panel4.add(editButton);
        
        JButton deleteButton = new JButton("刪除");
        deleteButton.setFont(new Font("微軟正黑體", Font.BOLD, 12));
        deleteButton.setBounds(90, 10, 70, 29);
        panel4.add(deleteButton);
        
        JButton saveButton = new JButton("列印庫存訂單");
        saveButton.setFont(new Font("微軟正黑體", Font.BOLD, 12));
        saveButton.setBounds(210, 10, 125, 29);
        panel4.add(saveButton);
        
        JButton backButton = new JButton("回訂單主頁");
        backButton.setFont(new Font("微軟正黑體", Font.BOLD, 12));
        backButton.setBounds(345, 10, 112, 29);
        panel4.add(backButton);
               
        //編輯
        editButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();  // 取得選中的行
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "請先選擇要編輯的訂單", "提示", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            // 取得原始數據
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            String name = (String) tableModel.getValueAt(selectedRow, 1);
            int apple = (int) tableModel.getValueAt(selectedRow, 2);
            int banana = (int) tableModel.getValueAt(selectedRow, 3);
            int lemon = (int) tableModel.getValueAt(selectedRow, 4);
                       
            JLabel idLabel = new JLabel();
            JLabel nameLabel = new JLabel();
            idLabel.setText(Integer.toString(id));
            nameLabel.setText(name);
            
            JLabel phoneLabel=new JLabel();
            JLabel addressLabel=new JLabel();
            phoneLabel.setText(memberserviceimpl.readMemberByName(name).getPhone());
            addressLabel.setText(memberserviceimpl.readMemberByName(name).getAddress());            
            
            String[] options = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            JComboBox<String> appleComboBox = new JComboBox<>(options);
            JComboBox<String> bananaComboBox = new JComboBox<>(options);
            JComboBox<String> lemonComboBox = new JComboBox<>(options);
            
            appleComboBox.setSelectedItem(String.valueOf(apple));
            bananaComboBox.setSelectedItem(String.valueOf(banana));
            lemonComboBox.setSelectedItem(String.valueOf(lemon));
            
            // 計算初始總金額
            JLabel totalLabel = new JLabel();
            int total = (apple * APPLE_PRICE) + (banana * BANANA_PRICE) + (lemon * LEMON_PRICE);
            totalLabel.setText("總金額：" + total + " 元");
            
            // 監聽 ComboBox 的選擇變更，並更新總金額
            ActionListener comboBoxListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int newAppleJ = Integer.parseInt((String) appleComboBox.getSelectedItem());
                    int newBananaJ = Integer.parseInt((String) bananaComboBox.getSelectedItem());
                    int newLemonJ = Integer.parseInt((String) lemonComboBox.getSelectedItem());
                    int totalJ = (newAppleJ * APPLE_PRICE) + (newBananaJ * BANANA_PRICE) + (newLemonJ * LEMON_PRICE);
                    totalLabel.setText("總金額：" + totalJ + " 元");
                }
            };
               
            appleComboBox.addActionListener(comboBoxListener);
            bananaComboBox.addActionListener(comboBoxListener);
            lemonComboBox.addActionListener(comboBoxListener);
            
            // 建立對話框內容
            Object[] fields = {
                "訂單號碼: "+idLabel.getText(),
                "顧客名字: "+nameLabel.getText(),
                "電話: "+phoneLabel.getText(),
                "地址: "+addressLabel.getText(),
            	"蘋果數量", appleComboBox,
                "香蕉數量", bananaComboBox,
                "檸檬數量", lemonComboBox,
                totalLabel,
            };
            
            // 顯示 JOptionPane，讓使用者修改數值
            int result = JOptionPane.showConfirmDialog(null, fields, "選擇新的水果數量",
                         JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            // 如果使用者按下 OK，則更新 JTable
            if (result == JOptionPane.OK_OPTION) {
                int newApple = Integer.parseInt((String) appleComboBox.getSelectedItem());
                int newBanana = Integer.parseInt((String) bananaComboBox.getSelectedItem());
                int newLemon = Integer.parseInt((String) lemonComboBox.getSelectedItem());
                porderserviceimpl.updatePorder(newApple, newBanana, newLemon, id);
                table.setModel(new PorderTableModel(new ArrayList<>()));
                tableModel = new PorderTableModel(porderserviceimpl.readAllPorder());
                table.setModel(tableModel);          
            }           
        }); 
        
        //刪除
        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();  // 取得選中的行
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "請先選擇要刪除的訂單", "提示", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            // 取得原始數據
            int id = (int) tableModel.getValueAt(selectedRow, 0);
            String name = (String) tableModel.getValueAt(selectedRow, 1);
            int apple = (int) tableModel.getValueAt(selectedRow, 2);
            int banana = (int) tableModel.getValueAt(selectedRow, 3);
            int lemon = (int) tableModel.getValueAt(selectedRow, 4);
            
            int confirm = JOptionPane.showConfirmDialog(this, "確定要刪除這筆訂單嗎？", "刪除確認", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.NO_OPTION) {
                return;
            }
     
            porderserviceimpl.deletePorderById(id);
            table.setModel(new PorderTableModel(new ArrayList<>()));
            tableModel = new PorderTableModel(porderserviceimpl.readAllPorder());
            table.setModel(tableModel);
        }); 
        
        //匯出
        saveButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                try (PrintWriter writer = new PrintWriter(fileChooser.getSelectedFile())) {
                	writer.write('\ufeff');
                    for (int i = 0; i < tableModel.getColumnCount(); i++) {
                        writer.print(tableModel.getColumnName(i) + (i == tableModel.getColumnCount() - 1 ? "\n" : ","));
                    }
                    for (int row = 0; row < tableModel.getRowCount(); row++) {
                        for (int col = 0; col < tableModel.getColumnCount(); col++) {
                            writer.print(tableModel.getValueAt(row, col) + (col == tableModel.getColumnCount() - 1 ? "\n" : ","));
                        }
                    }
                    JOptionPane.showMessageDialog(this, "資料已成功匯出！");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "匯出失敗：" + ex.getMessage());
                }
            }
        });
        
        //回訂單主頁
        backButton.addActionListener(e -> {
        	Tool.goPorderMainUI(this);
        });
	}
}
