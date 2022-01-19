package com.koreait.integration1.service;

import java.util.List;
import java.util.Map;

import com.koreait.integration1.domain.SearchBoard;

public interface SearchService {

	public List<SearchBoard> findAllList();
	public List<SearchBoard> find(Map<String, Object> map);
	
}
