package model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.EmployeeDao;
import dto.Employee;

public class EmployeeListService implements EmployeeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// DB 접근 
		EmployeeDao dao = EmployeeDao.getInstance();
		
		// get list
		List<Employee> list = dao.selectAllEmployee();
		
		// get total employees number
		int totalCount = dao.getTotalCount();
		
		// get average salary
		double average = dao.getAverage();

		
		// set params at request as Attr
		request.setAttribute("list", list);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("average", average);
		
		return new ModelAndView("views/employeeList.jsp", false);	// 전달만 함 forward
	}

}
