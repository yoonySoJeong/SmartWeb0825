package model;

import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.BoardDAO;
import dao.ReplyDAO;
import dto.BoardDTO;
import dto.ReplyDTO;

public class BoardViewService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Optional<String> opt = Optional.ofNullable(request.getParameter("no"));
		Long no = Long.parseLong(opt.orElse("0"));
		HttpSession session = request.getSession();
		
		if (session.getAttribute("open") == null) {
			session.setAttribute("open", true);
			BoardDAO.getInstance().updateBoardHit(no);
		}
		
		BoardDTO boardDTO = (BoardDTO) session.getAttribute("boardDTO");
		
		
		if(boardDTO == null) {
			BoardDAO.getInstance().updateBoardHit(no);
			boardDTO = BoardDAO.getInstance().selectBoardView(no);
		} 
		
		if(boardDTO != null) {
			session.setAttribute("boardDTO", boardDTO);
			List<ReplyDTO> replyList = ReplyDAO.getInstance().selectReplyList(no);
			request.setAttribute("replyList", replyList);
			request.setAttribute("boardDTO", boardDTO); // session 저장소보다 우선순위인 request 저장소를 사용하기 위해 똑같이 저장해둔다.
			return new ModelAndView("views/boardView.jsp", false);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('일치하는 게시글이 없습니다. 다시 시도하세요.')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
			return null;
		}
		
	}

}
