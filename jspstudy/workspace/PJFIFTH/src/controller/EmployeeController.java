package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.EmployeeDetailService;
import model.EmployeeInsertService;
import model.EmployeeListService;
import model.EmployeeService;
import model.EmployeeUpdateService;

@WebServlet("*.do")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);
		
		ModelAndView mav = null;
		EmployeeService employeeService = null;
		
		switch(command) {
		case "employeeList.do" :
		employeeService = new EmployeeListService();
		break;
		/* insertForm 으로 forward 이동 */
		case "insertForm.do" :
		mav = new ModelAndView("views/employeeInsert.jsp", false);
		break;
		/* real insert employee details */
		case "insertEmployee.do" :
		employeeService = new EmployeeInsertService();
		break;
		/* employee detail */	
		case "employeeDetail.do" :
		employeeService = new EmployeeDetailService();
		break;
		/* employee update */
		case "updateEmployee.do" :
		employeeService = new EmployeeUpdateService();
		break;
		}
		
		if (employeeService != null) {
			try {
				mav = employeeService.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (mav != null) {
			if(mav.isRedirect()) {
				response.sendRedirect(mav.getView());
			} else {
				request.getRequestDispatcher(mav.getView()).forward(request, response);
			}
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
