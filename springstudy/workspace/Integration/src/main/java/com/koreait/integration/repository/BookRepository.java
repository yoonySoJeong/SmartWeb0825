package com.koreait.integration.repository;

import java.util.List;
import java.util.Map;

import com.koreait.integration.domain.Book;

public interface BookRepository {
	
	public int insertBook(Book book);
	public List<Book> findAllBook();
	public List<Book> findBook(Map<String, Object> map);  // 실무에서 많이 씀 Map<String, Map<String, Object>>
}
