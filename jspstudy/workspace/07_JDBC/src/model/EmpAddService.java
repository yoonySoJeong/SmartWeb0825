package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.EmpDAO;
import dto.EmpDTO;

public class EmpAddService implements EmpService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		String name = request.getParameter("name");
		
		EmpDTO empDTO = new EmpDTO();
		empDTO.setName(name);
		
		EmpDAO empDAO = EmpDAO.getInstance();
		int result = empDAO.insertEmp(empDTO);				// DB 들어가는 것 까지 됨.
		
		ModelAndView modelAndView = null;
		if(result > 0) {		// if(result == 1) 
			modelAndView = new ModelAndView("/JDBC/selectList.emp", true);	// DB 수정 이후에는 redirect 할 것. insert는 DB의 수정이 이뤄지므로 redirect
											// selectEmpList로 가게 되면 DB를 거치고 가지 않으므로 
		} else {
			// 경고창 띄우기
			PrintWriter out = null;
			try {
				out = response.getWriter();
				out.println("<script>");
				out.println("alert('사원 등록이 실패했습니다.')");
				out.println("history.back();");
				out.println("</script>");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if ( out!= null) {
						out.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
		return modelAndView;
	}

}
