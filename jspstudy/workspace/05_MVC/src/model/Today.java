package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Today {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 여기야.. JSP -> Servlet(MyController : 신호등) -> 최종 java File까지 도착 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		String result = sdf.format(new Date());
		
		// 응답 view인 output.jsp로 보내기 위한 데이터 저장.
		request.setAttribute("result", result);
		
	}

	
}
