package service.impl;

import java.util.List;

import dao.impl.MemberDaoImpl;
import model.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService {

	public static void main(String[] args) {
		// addMember
		// Member m=new Member("ttt","ttt","456","台北","77","admin");
		// new MemberServiceImpl().addMember(m);

		/* Login
		System.out.println(new MemberServiceImpl().Login("ttt", "456"));
		*/
		
		// isUsernameBeenUse
		System.out.println(new MemberServiceImpl().checkIfUsernameExists("ttt"));		
	}
	
	MemberDaoImpl memberdaoimpl=new MemberDaoImpl();
	
	@Override
	public void createMember(Member member) {
		memberdaoimpl.create(member);	
	}

	@Override
	public Member readMemberByUsernamePassword(String username, String password) {
		 /*
		 * 1.判斷member
		 * true-->Member物件
		 * false-->null
		 */
		Member member=null;
		List<Member> l=memberdaoimpl.readByUsernamePassword(username, password);
		if(l.size()!=0)
		{
			member=l.get(0);
		}		
		
		return member;
	}

	@Override
	public Member readMemberByName(String name) {
		 /*
		 * 1.判斷member
		 * true-->Member物件
		 * false-->null
		 */
		Member member=null;
		List<Member> l=memberdaoimpl.readByName(name);
		if(l.size()!=0)
		{
			member=l.get(0);
		}		
		
		return member;
	}
		
	@Override
	public boolean checkIfUsernameExists(String username) {
		return !memberdaoimpl.readByUsername(username).isEmpty();
	}

	
}
