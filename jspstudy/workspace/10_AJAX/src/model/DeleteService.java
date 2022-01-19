package model;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;

import common.ModelAndView;
import dao.ProductDao;

public class DeleteService implements ProductService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 파라미터 처리
		Optional<String> optPno = Optional.ofNullable(request.getParameter("pno"));
		Long pno = Long.parseLong(optPno.orElse("0"));  // 예외의 회피를 위해 넣어줌 :: number format exception
		
		// 실제 삭제
		int result = ProductDao.getInstance().delete(pno);
		
		// 응답할 JSON 데이터
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		// obj :: {"result" : 0 } 또는 {"result" : 1 }
		
		// 응답 처리
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.close();		
		
		return null;		// 이동이 없으므로 null 반환 mav 호출필요가 없음.
	}

}
