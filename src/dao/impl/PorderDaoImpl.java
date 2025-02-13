package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PorderDao;
import model.Porder;
import util.DbConnection;

public class PorderDaoImpl implements PorderDao{

	public static void main(String[] args) {
		// create
		//Porder porder=new Porder("cde",2,2,2);
		//new PorderDaoImpl().add(porder);
		
		// read
		//List<Porder> l=new PorderDaoImpl().selectAll();
		//System.out.println(l);
		//List<Porder> l=new PorderDaoImpl().selectById(2);
		//System.out.println(l);
		
		// update
		//Porder porder=new PorderDaoImpl().selectById(1).get(0);
		//System.out.println(porder);
		//porder.setBanana(10);
		//new PorderDaoImpl().update(porder);
		
		// delete
		//new PorderDaoImpl().delete(2);
	}

	private static Connection conn=DbConnection.getDB();
	
	@Override
	public void create(Porder porder) {
		String sql="insert into porder(name,apple,banana,lemon) values(?,?,?,?)";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, porder.getName());
			preparedstatement.setInt(2, porder.getApple());
			preparedstatement.setInt(3, porder.getBanana());
			preparedstatement.setInt(4, porder.getLemon());
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public List<Porder> readAll() {
		String sql="select * from porder";
		List<Porder> l=new ArrayList();
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			while(resultset.next())
			{
				Porder porder=new Porder();
				porder.setName(resultset.getString("name"));
				porder.setApple(resultset.getInt("apple"));
				porder.setBanana(resultset.getInt("banana"));
				porder.setLemon(resultset.getInt("lemon"));
				porder.setId(resultset.getInt("id"));
				l.add(porder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return l;
	}

	@Override
	public List<Porder> readById(int id) {
		String Sql="select * from porder where id=?";
		List<Porder> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(Sql);
			preparedstatement.setInt(1, id);			
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next())
			{
				Porder porder=new Porder();
				porder.setId(resultset.getInt("id"));
				porder.setName(resultset.getString("name"));
				porder.setApple(resultset.getInt("apple"));
				porder.setBanana(resultset.getInt("banana"));
				porder.setLemon(resultset.getInt("lemon"));
				l.add(porder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public void update(Porder porder) {
		String sql="update porder set name=?,apple=?,banana=?,lemon=? where id=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, porder.getName());
			preparedstatement.setInt(2, porder.getApple());
			preparedstatement.setInt(3, porder.getBanana());
			preparedstatement.setInt(4, porder.getLemon());
			preparedstatement.setInt(5, porder.getId());			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql="delete from porder where id=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
