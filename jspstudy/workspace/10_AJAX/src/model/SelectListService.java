package model;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import common.ModelAndView;
import dao.ProductDao;
import dto.Product;

public class SelectListService implements ProductService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Product> list = ProductDao.getInstance().selectList();	// DB로부터 data를 받아오는 작업(목록을 받아오는 작업)
		
		// list를 JSON 데이터로 변경 후 반환
		JSONArray arr = new JSONArray(list);	// JSONArray에 list 전달
//		System.out.println(arr.toString());		// arr확인을 위해 sysout에 넣음
		
		// 결과 반환
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(arr);		// arr이 ajax success로 넘기는 데이터 :: JSONArray arr을 response로 보여준다.
		out.close();
		
		// 페이지 이동을 막기 위해서 null을 반환한다 :: return null		
		return null;
	
	}

}
