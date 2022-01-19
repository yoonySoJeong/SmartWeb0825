package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import service.List;
import service.MemberService;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Controller() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);
		
		ModelAndView mv = null;
		MemberService service = null;
		
		switch(command) {
		case "login.do":
			mv = new ModelAndView("member/start.jsp", false);
			break;
		}
	
		// modelAndView가 없는 경우 	(ajax 처리	--> page이동이 없는 기술. response에 의해서 inputpage로 이동.)
		// Model이 직접 결과를 반환하는 경우	=> response를 직접 작업하는 경우.		--> response가 있기 때문에 (응답하는 객체)
		if (service != null) {
			try {														// Exception을 직접 받기 위한 try를 작성할 것 ---> 100% 예외 처리됨. IOE or Servlet E 는 위에서 해주지만 다른 예외 처리를 위해 작성.(interface에서 던지는 exception임)
				mv = service.execute(request, response);		// 모든 실행의 결과는 mav이다.
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//command의 실행 결과로 mav가 반환됨.
		if (mv != null) {				// mav 가 null이 아니면
			if(mv.isRedirect()) {		// redirect 여부 확인
					response.sendRedirect(mv.getView());										// mav가 getView(이동할 장소)를 가지고 redirect response를 한다.
			} else {
					request.getRequestDispatcher(mv.getView()).forward(request, response);		// 아니면 forward한다 request와 response를 들고.
			}
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
