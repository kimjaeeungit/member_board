package service;

import java.util.List;

import vo.Attach;
import vo.Board;
import vo.Criteria;

public interface BoardService {
	// 1.글작성
	Long write(Board board);

	// 2.글수정
	void update(Board board);

	// 3.단일조회
	Board read(Long bno);

	// 4.목록조회
	List<Board> list();

	List<Board> list(Criteria cri);

	// 5.글삭제
	boolean deleteBoard(Long bno);

	// 6.파일이름 가져오기
	String getFileName(Long bno);

	// 7.댓글삭제
	void deleteReply(Long bno);

	// 8.글갯수
	int getCount(Criteria cri);

	/**
	 * 
	 * @param uuid
	 * @return origin
	 */
	// 9.첨부파일 uuid
	String findOriginBy(String uuid);

	// 10.다른날짜 사진 삭제
	List<Attach> readAttachByPath(String path);

}
