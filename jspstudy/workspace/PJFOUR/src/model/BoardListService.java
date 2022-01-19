package model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;

public class BoardListService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// session 사용을 위해 가져오기
		HttpSession session = request.getSession();
		
		BoardDTO boardDTO = (BoardDTO) session.getAttribute("boardDTO");
		if(boardDTO != null) {
			session.removeAttribute("boardDTO");
		}
		
		if (session.getAttribute("open") != null) {
			session.removeAttribute("open");
		}
		
		List<BoardDTO> list = BoardDAO.getInstance().selectBoardList();
		request.setAttribute("list", list);
		return new ModelAndView("views/boardList.jsp", false);
	}

}
