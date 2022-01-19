package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Board;
import mybatis.config.DBService;

public class BoardDao {
	
	private SqlSessionFactory factory;
	
	/* singleton */
	private static BoardDao instance;
	private BoardDao() {
		factory = DBService.getInstance().getFactory();
	}
	public static BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}
	
	// 1. selectList
	public List<Board> selectList(){
		SqlSession ss = factory.openSession();
		List<Board> list = ss.selectList("dao.pboard.selectList");
		ss.close();
		return list;
	}
	
	
	// 2. insertContent
	public int insert(Board board) {
		SqlSession ss =factory.openSession();
		int result = ss.insert("dao.pboard.insert", board);
		if(result > 0) ss.commit();
		return result;
	}
	
	
	// 3. totalContents
	public int getTotalCount() {
		SqlSession ss = factory.openSession();
		int totalCount = ss.selectOne("dao.pboard.getTotalCount");
		ss.close();
		return totalCount;
	}
	
	// 4. lastWriter
	public Board lastWriterName() {
		SqlSession ss = factory.openSession();
		Board board = ss.selectOne("dao.pboard.lastWriterName");
		ss.close();
		return board;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
