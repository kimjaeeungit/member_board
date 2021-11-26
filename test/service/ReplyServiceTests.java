package service;

import vo.Criteria;
import vo.Reply;

public class ReplyServiceTests {
	ReplyService service = new ReplyServiceImpl();
	Reply reply = new Reply();
	
	public static void main(String[] args) {
		ReplyServiceTests tests = new ReplyServiceTests();
		tests.testInsert(); // 1.댓글작성
		tests.testList(); // 2.댓글조회
		tests.testSelect(); // 3.댓글 단일 조회
		tests.testDelete(); // 4.댓글 삭제
	}
	//1.댓글작성
	public void testInsert() {
		service.write(new Reply(86L,"ghj","ghj","jhj",385L));
	}
	//2.댓글조회
	public void testList() {
	     service.list(86L).forEach(System.out::println);
	}
	//3.댓글 단일 조회
	public void testSelect() {
		System.out.println(service.get(86L));
	}
	//4.댓글 삭제
	public void testDelete() {
		service.remove(86L);
	}
}
