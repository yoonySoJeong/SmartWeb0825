package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.ModelAndView;
import dao.BoardDao;
import dto.Board;

public class PrevWriterName implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Board board = BoardDao.getInstance().lastWriterName();
		
		JSONObject obj = new JSONObject();
		obj.put("writer", board.getWriter());
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(obj);
		out.close();
		
		return null;
	}

}
