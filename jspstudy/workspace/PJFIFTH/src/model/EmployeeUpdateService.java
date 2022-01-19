package model;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.EmployeeDao;
import dto.Employee;

public class EmployeeUpdateService implements EmployeeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Long eno = Long.parseLong(request.getParameter("eno"));
		String name = request.getParameter("name");
		String depart = request.getParameter("depart");
		int salary = Integer.parseInt(request.getParameter("salary"));
		
		Employee employee = new Employee();
		employee.setEno(eno);
		employee.setName(name);
		employee.setDepart(depart);
		employee.setSalary(salary);
		
		int result = EmployeeDao.getInstance().updateEmployee(employee);
		
		PrintWriter out = response.getWriter();
		if(result > 0) {			// 성공시 보낼 script
			out.println("<script>");
			out.println("alert('수정 성공')");
			out.println("location.href='/PJFIFTH/employeeDetail.do?eno=" + eno + "'");	// redirect 이동
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('수정 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}

		return null;
	}

}
