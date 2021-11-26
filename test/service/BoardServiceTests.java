package service;

import vo.Board;
import vo.Criteria;

public class BoardServiceTests {
	BoardService service = new BoardServiceImpl();
	Board board = new Board();

	public static void main(String[] args) {
		BoardServiceTests tests = new BoardServiceTests();
		tests.testWrite(); //1.글작성
		tests.testList(); // 2.글수정
		tests.testRead(); // 3.단일조회
		tests.testList(); // 4.목록조회
		tests.testDeleteBoard(); // 5.글삭제
		tests.testDeleteReply(); // 7.댓글삭제
		tests.testGetFileName(); // 8.삭제할 파일명 가져오기
		tests.testReadAttachByPath(); // 9.다른날짜 사진 삭제
		tests.testFindOriginBy(); // 11.원래 파일이름
		tests.testGetCount(); // 12.글갯수 가져오기
	}

	// 1.글작성
	public void testWrite() {
		service.write(new Board(null, "dao main에서 작성된 글 제목", "dao main에서 작성된 글 내용", null, "babamba", 1L));
	}

	// 2.글수정
	public void testUpdate() {
		service.update(new Board(1L, "수정글", "수정내용", null, null, null));
		System.out.println(service.read(1L));
	}

	// 3.단일조회
	public void testRead() {
		board = service.read(1667900L);
		System.out.println(board);
	}

	// 4.목록조회
	public void testList() {
		service.list(new Criteria(1, 20)).forEach(System.out::println);
	}

	// 5.글삭제
	public void testDeleteBoard() {
		service.deleteBoard(309L);
		service.list().forEach(System.out::println);
	}

	// 6.삭제할 파일명 가져오기
	public void testGetFileName() {
		String filename = service.getFileName(367L);
		System.out.println(filename);
	}

	// 7.댓글삭제
	public void testDeleteReply() {
		service.deleteReply(367L);
	}

	// 8.글갯수 가져오기
	public void testGetCount() {
		int count = service.getCount(new Criteria(1, 20));
		System.out.println("글갯수" + count);
	}

	// 9.원래 파일이름
	public void testFindOriginBy() {
		String file = service.findOriginBy("f34c5e16-873d-4373-808f-ce699159d08f.png");
		System.out.println(file);
	}

	// 10.다른날짜 사진 삭제
	public void testReadAttachByPath() {
		service.readAttachByPath("210917").forEach(System.out::println);
	}
}
