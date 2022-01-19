package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.EmployeeDao;
import dto.Employee;

public class EmployeeInsertService implements EmployeeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// parameter
		String name = request.getParameter("name");
		String depart = request.getParameter("depart");
		int salary = Integer.parseInt(request.getParameter("salary"));
		
		Employee employee = new Employee();
		employee.setDepart(depart);
		employee.setName(name);
		employee.setSalary(salary);
		
		int result = EmployeeDao.getInstance().insertEmployee(employee);
		
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('등록성공')");
			out.println("location.href='/PJFIFTH/employeeList.do'");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		
		return null;	// response가 위에서 이뤄졌으므로 mav는 필요없음.
	}

}
