package guestdemo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import guestdemo.action.DeleteAction;
import guestdemo.action.FileDownLoadAction;
import guestdemo.action.ListAction;
import guestdemo.action.UpdateFormAction;
import guestdemo.action.UpdateProAction;
import guestdemo.action.ViewAction;
import guestdemo.action.WriteAction;
import sun.rmi.server.Dispatcher;

//http://localhost:8090/webdemo/board/*

@WebServlet("/board/*")
public class BoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}// end doGet()

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}// end doPost()

	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		// System.out.println(uri);
		// /webdemo/board/writeForm.do
		// /webdemo/board/*

		String action = uri.substring(uri.lastIndexOf("/"));
		String path = "";
		if (action.equals("/*") || action.equals("/list.do")) {
			ListAction list = new ListAction();
			list.execute(req, resp);
			path = "/guestview/list.jsp";
		} else if (action.equals("/writeForm.do")) {
			path = "/guestview/write.jsp";
		} else if (action.equals("/view.do")) {
			ViewAction view = new ViewAction();
			view.execute(req, resp);
			path = "/guestview/view.jsp";
		} else if (action.equals("/write.do")) {
			WriteAction write = new WriteAction();
			MultipartRequest multi = write.execute(req, resp);
			String param = "?pageNum=" + multi.getParameter("pageNum");
			resp.sendRedirect("list.do" + param);
		} else if (action.equals("/updateForm.do")) {
			UpdateFormAction uform = new UpdateFormAction();
			uform.execute(req, resp);
			path = "/guestview/update.jsp?pageNum=" + req.getParameter("pageNum");
		} else if (action.equals("/updatePro.do")) {
			UpdateProAction pro = new UpdateProAction();
			MultipartRequest multi = pro.execute(req);
			resp.sendRedirect("list.do?pageNum=" + multi.getParameter("pageNum"));
		} else if (action.equals("/download.do")) {
			FileDownLoadAction download = new FileDownLoadAction();
			download.execute(req, resp);
		} else if (action.equals("/delete.do")) {
			DeleteAction del = new DeleteAction();
			del.execute(req, resp);
			resp.sendRedirect("list.do?pageNum=" + req.getParameter("pageNum"));
		}

		if (path != "") {
			RequestDispatcher dis = req.getRequestDispatcher(path);
			dis.forward(req, resp);
		}
	}// end process()

}// end class
