package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MemberDao;
import model.Member;
import util.DbConnection;

public class MemberDaoImpl implements MemberDao {

	public static void main(String[] args) {
		/* add
		Member m=new Member("a","aaa","111","台北","111","111");
		Member m2=new Member("b","bbb","222","台北","222","222");
		Member m3=new Member("c","ccc","333","台北","333","333");
		new MemberDaoImpl().add(m);
		new MemberDaoImpl().add(m2);
		new MemberDaoImpl().add(m3);
		*/
		
		/* getAll
		List<Member> l=new MemberDaoImpl().getAll();
		for (Member m:l)
		{
			System.out.println(m);
		}
		*/
		
		/* selectUsernameAndPassword
		List<Member> l=new MemberDaoImpl().selectUsernameAndPassword("aaa", "111");
		for (Member m:l)
		{
			System.out.println(m);
		}
		*/
		
		/* selectById 
		List<Member> l=new MemberDaoImpl().selectById(2);
		for (Member m:l)
		{
			System.out.println(m);
		}
		*/
		
		/* update 
		List<Member> l=new MemberDaoImpl().selectById(2);
		//System.out.println(l.get(0));
		Member m=l.get(0);
		m.setName("teacher");	
		new MemberDaoImpl().update(m);
		*/
		 
		/* delete
		new MemberDaoImpl().delete(2);
		*/
		
	}

	private static Connection conn=DbConnection.getDB();
	
	@Override
	public void create(Member member) {
		String sql="insert into member(name,username,password,address,phone,role) "
				+ "values(?,?,?,?,?,?)";
	
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, member.getName());
			preparedstatement.setString(2, member.getUsername());
			preparedstatement.setString(3, member.getPassword());
			preparedstatement.setString(4, member.getAddress());
			preparedstatement.setString(5, member.getPhone());
			preparedstatement.setString(6, member.getRole());
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Member> readAll() {
		String sql="select * from member";
		List<Member> l=new ArrayList();

		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			while (resultset.next())
			{
				Member m=new Member();
				m.setId(resultset.getInt("id"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setAddress(resultset.getString("address"));
				m.setPhone(resultset.getString("phone"));
				m.setRole(resultset.getString("role"));
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<Member> readByUsernamePassword(String username, String password) {
		String sql="select * from member where username=? and password=?";
		List<Member> l=new ArrayList();
		
		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setString(1, username);
			preparedstatement.setString(2, password);
			ResultSet resultset=preparedstatement.executeQuery();
			while (resultset.next())
			{
				Member m=new Member();
				m.setId(resultset.getInt("id"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setAddress(resultset.getString("address"));
				m.setPhone(resultset.getString("phone"));
				m.setRole(resultset.getString("role"));
				l.add(m);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return l;
	}

	@Override
	public List<Member> readById(int id) {
		String sql="select * from member where id=?";
		List<Member> l=new ArrayList();
		
		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			ResultSet resultset=preparedstatement.executeQuery();
			while (resultset.next())
			{
				Member m=new Member();
				m.setId(resultset.getInt("id"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setAddress(resultset.getString("address"));
				m.setPhone(resultset.getString("phone"));
				m.setRole(resultset.getString("role"));
				l.add(m);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<Member> readByUsername(String username) {
		String sql="select * from member where username=?";
		List<Member> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, username);			
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				Member m=new Member();
				m.setId(resultset.getInt("id"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setAddress(resultset.getString("address"));
				m.setPhone(resultset.getString("phone"));
				m.setRole(resultset.getString("role"));				
				l.add(m);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<Member> readByName(String name) {
		String sql="select * from member where name=?";
		List<Member> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, name);			
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				Member m=new Member();
				m.setId(resultset.getInt("id"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setAddress(resultset.getString("address"));
				m.setPhone(resultset.getString("phone"));
				m.setRole(resultset.getString("role"));				
				l.add(m);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}
	
	@Override
	public void update(Member member) {
		String sql="update member set name=?,password=?,address=?,phone=?,role=? where id=?";	
		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setString(1, member.getName());
			preparedstatement.setString(2, member.getPassword());
			preparedstatement.setString(3, member.getAddress());
			preparedstatement.setString(4, member.getPhone());
			preparedstatement.setString(5, member.getRole());
			preparedstatement.setInt(6, member.getId());
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

	@Override
	public void delete(int id) {
		String sql="delete from member where id=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1,id);
			preparedstatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
