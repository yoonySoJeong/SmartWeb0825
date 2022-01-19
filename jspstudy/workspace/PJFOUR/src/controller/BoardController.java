package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.BoardInsertService;
import model.BoardListService;
import model.BoardService;
import model.BoardViewService;
import model.ReplyInsertService;


/* 가장 완벽한 형태 (여지껏 우리가 작성했던 것 중에서...) */


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
		
		ModelAndView mav = null;
		BoardService service = null; 													
		switch(command) {
		/* 작성글들 리스트 */
		case "boardList.do" :
			service = new BoardListService();
			break;
		/* 선택 글 상세보기 */
		case "viewNotice.do" :
			service = new BoardViewService();
			break;
		/* 댓글 달기 */	
		case "insertReply.do" :
			service = new ReplyInsertService();
			break;
		/* 게시글 작성 폼으로 가기 */
		case "insertBoardForm.do" :
			mav = new ModelAndView("views/boardInsertForm.jsp", false);
			break;
		/* 게시글 작성 */
		case "insertBoard.do" :
			service = new BoardInsertService();
			break;
		/* 게시글 수정 폼으로 가기 */
		case "updateForm.do" :
			mav = new ModelAndView("views/boardInsertForm.jsp", false);
			break;
		/* 게시글 수정 */
		case "updateBoard.do" :
			
			break;
		}
		
		if (service != null) {
			try {														
				mav = service.execute(request, response);		
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		if (mav != null) {				
			if(mav.isRedirect()) {		
					response.sendRedirect(mav.getView());										
			} else {
					request.getRequestDispatcher(mav.getView()).forward(request, response);		
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
