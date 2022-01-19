package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Bean;
import common.ModelAndView;

public class List implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Bean user = new Bean();
		user.setName((String)request.getAttribute("name"));
		user.setPw((String)request.getAttribute("pw"));
		
		ModelAndView modelAndView = null;
		
		modelAndView = new ModelAndView("/PPP/member/start.jsp", true);		
		return modelAndView;
	}

}
