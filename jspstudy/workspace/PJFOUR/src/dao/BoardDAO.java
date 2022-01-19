package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.BoardDTO;
import mybatis.config.DBService;

public class BoardDAO {

	/* StudentDao의 모든 메소드는 factory에서 SqlSession을 얻어 낸다. */
	private SqlSessionFactory factory;
	private static BoardDAO instance;
	private BoardDAO() {
		factory = DBService.getInstance().getFactory();
	}
	public static BoardDAO getInstance() {
		if (instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	
	// 1. select board list
	public List<BoardDTO> selectBoardList() {
		SqlSession ss = factory.openSession();
		List<BoardDTO> list = ss.selectList("dao.board.selectBoardList");
		ss.close();
		return list;
	}
	
	// 2. select one content for detail 
	public BoardDTO selectBoardView(Long no) {
		SqlSession ss = factory.openSession();
		BoardDTO boardDTO = ss.selectOne("dao.board.selectBoardView", no);
		ss.close();
		return boardDTO;
	}
	
	// 3. update board content's hit
	public int updateBoardHit (Long no) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.board.updateBoardHit", no);
		if(result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	// 4. insert board content
	public int insertBoard(BoardDTO boardDTO) {
		SqlSession ss = factory.openSession(false); // prevent auto commit
		int result = ss.insert("dao.board.insertBoard", boardDTO);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	// 5. max hit content
	public List<BoardDTO> selectMaxHit() {
		SqlSession ss = factory.openSession();
		List<BoardDTO> maxHit = ss.selectList("dao.board.selectMaxHit");
		ss.close();
		return maxHit;
	}
	
	// 6. min hit content
	public List<BoardDTO> selectMinHit() {
		SqlSession ss = factory.openSession();
		List<BoardDTO> minHit = ss.selectList("dao.board.selectMinHit");
		ss.close();
		return minHit;
	}
	
	// 7. update board content
	public int updateBoard(BoardDTO boardDTO) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.board.updateBoard", boardDTO);
		if(result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	// 8. delete board content
	public int deleteBoard(Long no) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("dao.notice.deleteBoard", no);
		if (result > 0) ss.commit();
		ss.close();
		return result;

	}
	
}
