package model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDao;
import dto.Board;

public class BoardUpdateService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Long idx = Long.parseLong(request.getParameter("idx"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Board boardDto = new Board();
		boardDto.setIdx(idx);
		boardDto.setTitle(title);
		boardDto.setContent(content);
		
		BoardDao dao = BoardDao.getInstance();
		int result = dao.updateBoard(boardDto);
		PrintWriter out = response.getWriter();
		
		if (result > 0) {
			out.println("<script>");
			out.println("alert('수정 성공');");
			out.println("location.href='/PJTWO/selectOne.do?idx=" + idx + "';");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('수정 실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		
		
		
		return null;
	}

}
