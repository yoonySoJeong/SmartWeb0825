package com.koreait.integration1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.integration1.domain.SearchBoard;
import com.koreait.integration1.service.SearchService;

@Controller
public class SearchBoardController {

	@Autowired private SearchService service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	// get '/integration1/searchboard/findAllList'
	@GetMapping(value="searchboard/findAllList", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> findAllList(){
		List<SearchBoard> list = service.findAllList();
//		System.out.println("리스트 배열" + list.toString());
		Map<String, Object> map = new HashMap<>();
		if (list.size() == 0) {
			map.put("status", 500);
		} else {
			map.put("status", 200);
			map.put("message", "전체 " + list.size() + "개의 목록을 가져왔습니다.");
			map.put("list", list);
		}
		return map;
	}
	
	// get '/integration1/searchboard/find'
	@GetMapping(value="searchboard/find", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> find(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		map.put("column", request.getParameter("column"));
		map.put("query", request.getParameter("query"));
		List<SearchBoard> list = service.find(map);
		Map<String, Object> m = new HashMap<>();
		if (list.size() == 0) {
			m.put("status", 500);
			m.put("message", map.get("query") + "검색 결과가 없습니다.");
			m.put("list", null);
		} else {
			m.put("status", 200);
			m.put("message", list.size() + "개의 검색 결과가 있습니다.");
			m.put("list", list);
		}
		return m;
	}
	
}
