package guestdemo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestdemo.dao.BoardDAO;
import guestdemo.dto.BoardDTO;

public class ViewAction {
		public void execute(HttpServletRequest req, HttpServletResponse resp){
			BoardDAO dao = BoardDAO.getInstance();
			int num = Integer.parseInt(req.getParameter("num"));
			dao.readCountMethod(num);
			BoardDTO dto = dao.viewMethod(num);
			req.setAttribute("dto", dto);
		}//end execute
		
}//end class
