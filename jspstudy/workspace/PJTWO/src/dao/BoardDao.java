package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Board;
import mybatis.config.DBService;

public class BoardDao {
	
	private SqlSessionFactory factory;
	
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
	
	private final String NAMESPACE = "dao.board";
	
	// 1. Board List 
	public List<Board> selectAllBoardList() {
		SqlSession ss = factory.openSession();
		List<Board> list = ss.selectList(NAMESPACE + ".selectAllBoardList");
		ss.close();
		return list;
	}
	
	// 2. select one
	public Board selectOne(Long idx) {
		SqlSession ss = factory.openSession();
		Board boardDto = ss.selectOne(NAMESPACE +".selectOne" , idx);
		ss.close();
		return boardDto;
	}
	
	// 3. Insert
	public int insertBoard(Board board) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert(NAMESPACE + ".insertBoard", board);
		
		if (result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	// 4. update
	public int updateBoard(Board board) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update(NAMESPACE + ".updateBoard", board);
		
		if (result > 0) {
			ss.commit();
		}
		ss.close();
		
		return result;
	}
	
	// 5. delete
	public int deleteOne(Long idx) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete(NAMESPACE + ".deleteOne", idx);	// sqlmapper 다녀오자.
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	// 6. getTotalCount
	public int getTotalCount() {
		SqlSession ss = factory.openSession();
		int totalCount = ss.selectOne(NAMESPACE + ".getTotalCount");
		ss.close();
		return totalCount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
