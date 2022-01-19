package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.BoardDeleteService;
import model.BoardInsertService;
import model.BoardSelectAllListService;
import model.BoardSelectOneService;
import model.BoardService;
import model.BoardUpdateService;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);
		
		ModelAndView modelAndView = null;
		BoardService boardService = null;
		
		switch(command) {
		case "selectAllList.do" :
			boardService = new BoardSelectAllListService();
			break;
		case "selectOne.do" :
			boardService = new BoardSelectOneService();
			break;
		case "insert.do" :
			boardService = new BoardInsertService();
			break;
		case "update.do" :
			boardService = new BoardUpdateService();			
			break;
		case "insertForm.do" :
			modelAndView = new ModelAndView("views/insertList.jsp", false);
			break;
		case "delete.do" :
			boardService = new BoardDeleteService();
			break;
		
		}
		
		if (boardService != null) {
			try {
				modelAndView = boardService.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (modelAndView != null) {
			if(modelAndView.isRedirect()) {
				response.sendRedirect(modelAndView.getView());
			} else {
				request.getRequestDispatcher(modelAndView.getView()).forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
