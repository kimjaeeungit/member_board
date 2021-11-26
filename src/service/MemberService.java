package service;

import java.util.List;

import vo.Member;

public interface MemberService {

	//할일
	
	//회원가입
	void join(Member member);
	
	//로그인
	boolean login(String id, String pwd);
	
	//탈퇴
	
	//로그아웃
	
	//정보수정
	void modify(Member member);
	
	//id/pw찾기
	
	//단일 회원 조회
	Member findBy(String id);
	
	//회원 목록 조회
	List<Member>getMembers();

	
	//회원탈퇴
	//int deleteMember(String id, String pw);


	
}
