package controller.member;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDao;
import dao.MemberDao;
import dao.ReplyDao;
import service.MemberService;
import service.MemberServiceImpl;
import vo.Board;
import vo.Member;
import vo.Reply;

@WebServlet("/removeform")
public class RemoveForm extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/jsp/member/removeform.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDao dao = new MemberDao();
		BoardDao daob = new BoardDao();
		ReplyDao daor =new ReplyDao();
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");

		System.out.println("id"+id);
		String pw= req.getParameter("pwd");
				
		
		//게시글 아이디 바꾸기
		Board boardselect =daob.findById(id);
		Board board= new Board(boardselect.getBno(),boardselect.getTitle(),boardselect.getContent(),id);
		daob.updateWriter(board);
		
		//댓글 아이디 바꾸기
		Reply replyselect =daor.findById(id);
		Reply reply= new Reply(replyselect.getRno(),replyselect.getTitle(),replyselect.getContent(),id,replyselect.getBno());
		daor.updateWriter(reply);

		int check = dao.deleteMember(id, pw);
		 
		 if(check == 1){
            session.invalidate(); // 삭제했다면 세션정보를 삭제한다.
		 }
		  resp.sendRedirect("index.html");  
	
	}
}
