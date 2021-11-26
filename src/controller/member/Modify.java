package controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import service.MemberServiceImpl;
import vo.Member;

@WebServlet("/modify")
public class Modify extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//그냥 웹브라우저 통해서 실행하면 join.jsp로 이동
		req.getRequestDispatcher("WEB-INF/jsp/member/modify.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");
		//join.jsp에서 받아온 데이터 

		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		
		//초기화
		Member member= new Member(id,pwd,email,name);
		MemberService service = new MemberServiceImpl();
		//service.java에 있는 메서드
		service.modify(member);
		
		//회원가입 완료되면 loign.jsp로 이동
		resp.sendRedirect("index.html");
	
	
	}
	

}
