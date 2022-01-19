package model;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.EmployeeDao;

public class EmployeeDetailService implements EmployeeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Optional<String> optEno = Optional.ofNullable(request.getParameter("eno"));
		Long eno = Long.parseLong(optEno.orElse("0"));
		
		EmployeeDao dao = EmployeeDao.getInstance();
		
		request.setAttribute("eno", dao.selectOneEmployee(eno));
		
		return new ModelAndView("views/employeeDetail.jsp", false);
	}

}
