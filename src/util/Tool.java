package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.porder.PorderMainUI;

//import controller.porder.PorderMainUI;

public class Tool {
	
	public enum Role {
		User, Admin
	}
	public static String[] getRole() {
		return java.util.Arrays.stream(Role.values())
	                .map(Enum::name)
	                .toArray(String[]::new);
	}

	
	public static void save(Object s,String filename)
	{
		
		try {
			
			FileOutputStream fos=new FileOutputStream(filename);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			
			oos.writeObject(s);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Object read(String filename)
	{
		Object o=null;
		
		try {
			FileInputStream fis=new FileInputStream(filename);
			ObjectInputStream ois=new ObjectInputStream(fis);
			o=ois.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return o;
	}

	//時鐘
	public static void updateDateTime(JLabel label) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime = sdf.format(new Date());
		label.setText(currentDateTime);
	}
	
	//密碼正則表示法
	public static boolean isValidPassword(String password) {
        // 至少 1 個英文字母、1 個符號、1 個數字，且長度為 1-5個字元
        String regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d]).{1,5}$";
        return password.matches(regex);
    }

	public static void goPorderMainUI(JFrame jframe)
	{
		PorderMainUI pordermain=new PorderMainUI();
		pordermain.setVisible(true);		
		jframe.dispose();
	}

}
