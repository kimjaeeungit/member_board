package dao;

import vo.Board;
import vo.Criteria;

public class BoardDaoTests {
   BoardDao dao = new BoardDao();
   Board board =new  Board();
   
   public static void main(String[] args) {
      BoardDaoTests tests = new BoardDaoTests();
      tests.testInsert(); //1.글작성
      tests.testList(); //2.글수정
      tests.testRead(); //3.단일조회
      tests.testList(); //4.목록조회
      tests.testDeleteBoard(); //5.글삭제
      tests.testDeleteAttach(); //6.첨부파일 삭제
      tests.testDeleteReply(); //7.댓글삭제
      tests.testGetFileName(); //8.삭제할 파일명 가져오기
      tests.testReadAttachByPath(); //9.다른날짜 사진 삭제
      tests.testReadAttach(); //10.첨부파일 목록만 가져오기
      tests.testFindOriginBy(); //11.원래 파일이름
      tests.testGetCount(); //12.글갯수 가져오기
      tests.findById(); //13.id로 정보 select하는 메서드
      tests.testUpdateWriter(); //14.탈퇴한회원 게시글 아이디 수정
   }
   
   //1.글작성
   public void testInsert() {
	   Long bno = dao.insert(new Board(null, "dao main에서 작성된 글 제목","dao main에서 작성된 글 내용",null,"babamba",1L));
	   System.out.println(bno);
   }
   //2.글수정
   public void testUpdate() {
   	 Long bno = dao.update(new Board(1L,"수정글","수정내용",null,null,null));
	 System.out.println(dao.read(1L));
   }
   //3.단일조회
   public void testRead() {
      board = dao.read(1667900L);
      System.out.println(board);
   }
   //4.목록조회
   public void testList() {
      dao.list(new Criteria(1,20)).forEach(System.out::println);
   }
   //5.글삭제
   public void testDeleteBoard() {
	  dao.deleteBoard(309L);
	  dao.list().forEach(System.out::println);
   }
   //6.첨부파일 삭제
   public void testDeleteAttach() {
	  dao.deleteAttach(27L);
	  dao.list().forEach(System.out::println);
   }
   //7.댓글삭제
   public void testDeleteReply() {
	   dao.deleteReply(367L);
   }
   //8.삭제할 파일명 가져오기
   public void testGetFileName() {
	   String filename=dao.getFileName(367L);
	   System.out.println(filename);
   }
   //9.다른날짜 사진 삭제
   public void testReadAttachByPath() {
	   dao.readAttachByPath("210917").forEach(System.out::println);
   }
   //10.첨부파일 목록만 가져오는 셀렉트 코드
   public void testReadAttach() {
	   String file=dao.getFileName(365L);
	   System.out.println(file);
   }
   //11.원래 파일이름
   public void testFindOriginBy() {
	   String file=dao.findOriginBy("f34c5e16-873d-4373-808f-ce699159d08f.png");
	   System.out.println(file);
   }
   //12.글갯수 가져오기
   public void testGetCount() {
	   int count=dao.getCount(new Criteria(1,20));
	   System.out.println("글갯수"+count);
   }
   //13.id로 정보 select하는 메서드
   public void findById() {
	   System.out.println(dao.findById("babamba3"));
   }
   //14.탈퇴한회원 게시글 아이디 수정
   public void testUpdateWriter() {
	   dao.updateWriter(new Board(377L,"수정글","수정내용","test3"));
   }
}
   
   