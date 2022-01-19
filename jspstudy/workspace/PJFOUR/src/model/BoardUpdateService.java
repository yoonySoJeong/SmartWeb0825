package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;

public class BoardUpdateService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Long no = Long.parseLong(request.getParameter("no"));
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle(title);
		boardDTO.setContent(content);
		boardDTO.setNo(no);
		
		int result = BoardDAO.getInstance().updateBoard(boardDTO);	// dto 호출, db로 보내는 code
		
		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.println("<script>");
			out.println("alert('공지사항 수정 성공')");
			out.println("location.href='viewNotice.do?no=" + no + "'");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('공지사항 수정 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		return null;
	}

}
