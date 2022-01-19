package com.koreait.integration1.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.integration1.domain.SearchBoard;
import com.koreait.integration1.repository.SearchBoardRepository;

public class SearchServiceImpl implements SearchService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<SearchBoard> findAllList() {
		SearchBoardRepository repository = sqlSession.getMapper(SearchBoardRepository.class);
		return repository.findAllList();
	}
	
	@Override
	public List<SearchBoard> find(Map<String, Object> map) {
		SearchBoardRepository repository = sqlSession.getMapper(SearchBoardRepository.class);
		return repository.find(map);
	}
	
	
	
}
