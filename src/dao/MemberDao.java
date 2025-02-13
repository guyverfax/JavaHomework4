package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
	
	//create
	void create(Member member);

	//read
	List<Member> readAll();
	List<Member> readByUsernamePassword(String username,String password);//select * from member where username=? and password=?
	List<Member> readById(int id);
	List<Member> readByUsername(String username);
	List<Member> readByName(String name);
	
	//update
	void update(Member member);
	
	//delete
	void delete(int id);
	
}
