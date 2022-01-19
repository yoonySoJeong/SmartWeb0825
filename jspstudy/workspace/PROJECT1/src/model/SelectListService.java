package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDao;

public class SelectListService implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setAttribute("list", BoardDao.getInstance().selectList());
		request.setAttribute("totalCount", BoardDao.getInstance().getTotalCount());
				
		return new ModelAndView("views/showAllList.jsp", false);
	}

}
