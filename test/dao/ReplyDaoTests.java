package dao;

import vo.Criteria;
import vo.Reply;

public class ReplyDaoTests {
	ReplyDao dao = new ReplyDao();
	Reply reply = new Reply();

	public static void main(String[] args) {
		ReplyDaoTests tests = new ReplyDaoTests();
		tests.testInsert(); // 1.댓글작성
		tests.testList(); // 2.댓글조회
		tests.testSelect(); // 3.댓글 단일 조회
		tests.testDelete(); // 4.댓글 삭제
		tests.testFindById(); // 5.id로 정보 select하는 메서드
		tests.testUpdateWriter(); // 6.탈퇴회원 댓글 아이디 수정
	}

	// 1.댓글작성
	public void testInsert() {
		dao.insert(new Reply(86L, "ghj", "ghj", "jhj", 385L));
	}

	// 2.댓글조회
	public void testList() {
		dao.list(86L).forEach(System.out::println);
	}

	// 3.댓글 단일 조회
	public void testSelect() {
		System.out.println(dao.select(86L));
	}

	// 4.댓글 삭제
	public void testDelete() {
		dao.delete(86L);
	}

	// 5.id로 정보 select하는 메서드
	public void testFindById() {
		System.out.println(dao.findById("tes2"));
	}

	// 6.탈퇴회원 댓글 아이디 수정
	public void testUpdateWriter() {
		dao.updateWriter(new Reply(86L, "ghj", "ghj", "jhj", 385L));
	}
}
