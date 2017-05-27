package guestdemo.action;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestdemo.dao.BoardDAO;
import guestdemo.dto.BoardDTO;

public class UpdateFormAction extends HttpServlet{
	public void execute(HttpServletRequest req, HttpServletResponse resp){
		int num = Integer.parseInt(req.getParameter("num"));
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = dao.viewMethod(num);
		req.setAttribute("dto", dto);
	}
}
