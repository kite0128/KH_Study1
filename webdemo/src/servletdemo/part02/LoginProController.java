package servletdemo.part02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginPro")
public class LoginProController extends HttpServlet{
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			req.setCharacterEncoding("UTF-8");
			
			MemberDTO dto = new MemberDTO();
			String id = req.getParameter("id");
			dto.setId(id);
			
			String pw = req.getParameter("password");
			dto.setPassword(pw);
			
			
			RequestDispatcher dis = req.getRequestDispatcher("/servletview/part02/res.jsp");
			req.setAttribute("dto", dto);
			dis.forward(req, resp);
			
		}
	
}
