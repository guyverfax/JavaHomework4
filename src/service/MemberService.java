package service;

import model.Member;

public interface MemberService {
	//create
	void createMember(Member member);
	
	//read
	Member readMemberByUsernamePassword(String username,String password);
	Member readMemberByName(String name);
	boolean checkIfUsernameExists(String username);
	
	//update
		
	//delete

}
