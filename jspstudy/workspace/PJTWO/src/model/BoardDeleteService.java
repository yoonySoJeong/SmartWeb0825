package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDao;

public class BoardDeleteService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Optional<String> optIdx = Optional.ofNullable(request.getParameter("idx"));
		Long idx = Long.parseLong(optIdx.orElse("0"));
		BoardDao dao = BoardDao.getInstance();
		// 다오에가자..
		// 다오 메소드 실행
		int result = dao.deleteOne(idx);
		
		PrintWriter out = response.getWriter();
		
		if (result > 0) {
			out.println("<script>");
			out.println("alert('삭제 성공');");
			out.println("location.href='/PJTWO/selectAllList.do';");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('삭제 실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		
		return null;
	}

}
