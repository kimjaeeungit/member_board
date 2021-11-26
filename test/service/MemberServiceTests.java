package service;

import vo.Board;
import vo.Member;

public class MemberServiceTests {
	MemberService service = new MemberServiceImpl();
	Member member = new Member();
	
	public static void main(String[] args) {
		MemberServiceTests tests = new MemberServiceTests();
		tests.testGetMembers(); //1.회원목록조회
		tests.testLogin(); //2.로그인 성공 확인
		tests.testJoin(); //3.회원가입
		tests.testModify(); //4.회원정보수정
		tests.testFindBy(); //5.id로 정보 select
	}
	
	//1.회원목록조회
	public void testGetMembers() {
		System.out.println(service.getMembers());
	}
	//2.로그인 성공 확인
	public void testLogin() {
		System.out.println(service.login("javaman","5678"));
	}
	//3.회원가입
	public void testJoin() {
		service.join(new Member("bts","1234","asdsa","방탄"));
		System.out.println(service.getMembers());
	}
	//4.회원정보수정
	public void testModify() {
		service.modify(new Member("bts2","1234","asdsa2","방탄2"));
		System.out.println(service.getMembers());
	}
	//5.id로 정보 select하는 메서드
	public void testFindBy() {
		System.out.println(service.findBy(member.getId()));
	}
}
