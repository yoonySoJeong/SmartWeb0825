package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;
import dao.ReplyDAO;
import dto.BoardDTO;

public class BoardInsertService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String author = request.getParameter("author");
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		String ip = request.getRemoteAddr();
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setAuthor(author);
		boardDTO.setContent(content);
		boardDTO.setTitle(title);
		boardDTO.setIp(ip);
		
		int result = BoardDAO.getInstance().insertBoard(boardDTO);
		if (result > 0) {
			return new ModelAndView("boardList.do", false);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("<h1>게시글 작성 실패</h1>");
			out.println("alert('게시글작성 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
			return null;
		}
		
	}

}
