package service;

import java.util.List;

import dao.BoardDao;
import dao.MemberDao;
import vo.Board;
import vo.Member;

public class MemberServiceImpl implements MemberService {
	//MemberDao객체 생성
	private MemberDao dao = new MemberDao();
	private BoardDao daob= new BoardDao();
	
	@Override
	public List<Member>getMembers(){
		return dao.getMembers();
	}
	
	//로그인 여부 확인
	@Override
	public boolean login(String id,String pwd) {
		return dao.login(id,pwd);
	}
	@Override
	public void join(Member member) {
		dao.join(member);
	}
	
	//회원정보수정
	@Override
	public void modify(Member member) {
		dao.modify(member);		
	}

	@Override
	public Member findBy(String id) {
		// TODO Auto-generated method stub
		return dao.findBy(id);
	}
	
//	public int deleteMember(String id, String pw) {
//		Board board = new Board();
//		daob.updateWriter(board);
//		return deleteMember(id,pw);
//	}
	
}
