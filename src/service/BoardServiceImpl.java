package service;

import java.util.List;

import dao.BoardDao;
import dao.ReplyDao;
import vo.Attach;
import vo.Board;
import vo.Criteria;
import vo.PageDTO;

public class BoardServiceImpl implements BoardService {
	private BoardDao dao=new BoardDao();
	private ReplyDao daoR=new ReplyDao();

	@Override
	//트랜잭션
	//첨부파일 추가해서 글작성
	public Long write(Board board) {
		//글 작성 후 글번호 반환
		Long bno=dao.insert(board);
		
		//각 첨부파일에 글번호 부여
		for(Attach attach:board.getAttachs()) {
			attach.setBno(bno);
			//첨부파일 작성
			dao.writeAttach(attach);
		}		
		return bno;
	}

	@Override
	public Board read(Long bno) {
		// TODO Auto-generated method stub
		Board board = dao.read(bno);
		board.setAttachs(dao.readAttach(bno));
		return board;
	}

	@Override
	public List<Board> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}


	
	@Override
	public List<Board> list(Criteria cri) {
		List<Board>list=dao.list(cri);
		list.forEach(b->b.setAttachs(dao.readAttach(b.getBno())));
		return list;
	}

	
	//글삭제 첨부파일삭제
	@Override
	public boolean deleteBoard(Long bno) {
		return dao.deleteBoard(bno);
	}
	
	//파일이름 가져오기
	public String getFileName(Long bno) {
		return dao.getFileName(bno);
	}
	//댓글삭제
	public void deleteReply(Long bno) {
		dao.deleteReply(bno);
	}
	
	@Override
	public String findOriginBy(String uuid) {
		// TODO Auto-generated method stub
		return dao.findOriginBy(uuid);
	}
	
	
	@Override
	public int getCount(Criteria cri) {
		return dao.getCount(cri);
	}

	@Override
	public List<Attach> readAttachByPath(String path) {
		// TODO Auto-generated method stub
		return dao.readAttachByPath(path);
	}
	@Override
	public void update(Board board) {
		Long bno=dao.update(board);
		
		//각 첨부파일에 글번호 부여
		for(Attach attach:board.getAttachs()) {
			attach.setBno(bno);
			//첨부파일 작성
			dao.writeAttach(attach);
		}	
	}
	
}
