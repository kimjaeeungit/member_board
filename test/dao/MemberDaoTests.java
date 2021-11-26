package dao;

import vo.Board;
import vo.Member;

public class MemberDaoTests {
	MemberDao dao = new MemberDao();
	Member member = new Member();
	
	public static void main(String[] args) {
		MemberDaoTests tests = new MemberDaoTests();
		tests.testGetMembers(); //1.회원목록조회
		tests.testLogin(); //2.로그인 성공 확인
		tests.testJoin(); //3.회원가입
		tests.testModify(); //4.회원정보수정
		tests.testFindBy(); //5.id로 정보 select
		tests.testFindById(); //6.email로 정보 select
		tests.testFindById2(); //7.email과 name으로 정보 select
		tests.testDeleteMember(); //8.회원 탈퇴
	}
	
	//1.회원목록조회
	public void testGetMembers() {
		System.out.println(dao.getMembers());
	}
	//2.로그인 성공 확인
	public void testLogin() {
		System.out.println(dao.login("javaman","5678"));
	}
	//3.회원가입
	public void testJoin() {
		dao.join(new Member("bts","1234","asdsa","방탄"));
		System.out.println(dao.getMembers());
	}
	//4.회원정보수정
	public void testModify() {
		dao.modify(new Member("bts2","1234","asdsa2","방탄2"));
		System.out.println(dao.getMembers());
	}
	//5.id로 정보 select하는 메서드
	public void testFindBy() {
		System.out.println(dao.findBy(member.getId()));
	}
	//6.email로 정보 select하는 메서드
	public void testFindById() {
		System.out.println(dao.findById("dmjf12@naver.com"));
		}
	//7.email과 name으로 정보 select하는 메서드
	public void testFindById2() {
		System.out.println(dao.findById("dmjf12@naver.com","김재은"));
	}
	//8.회원 탈퇴
	public void testDeleteMember() {
		dao.deleteMember("bts","1234");
	}
}
