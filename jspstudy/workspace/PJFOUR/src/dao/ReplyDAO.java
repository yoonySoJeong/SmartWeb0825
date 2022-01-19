package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.ReplyDTO;
import mybatis.config.DBService;

public class ReplyDAO {
	
	private SqlSessionFactory factory;
	
	/* singleton */
	private static ReplyDAO instance;
	private ReplyDAO() {
		factory = DBService.getInstance().getFactory();
	}
	
	public static ReplyDAO getInstance() {
		if (instance == null ) {
			instance = new ReplyDAO();
		}
		return instance;
	}
	
	/* insert reply */
	public int insertReply(ReplyDTO replyDTO) {		// Reply type, reply 
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.board.insertReply", replyDTO);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	/* select replies list */
	public List<ReplyDTO> selectReplyList(Long no) {	// 받아와서 넘겨주기.
		SqlSession ss = factory.openSession();
		List<ReplyDTO> list = ss.selectList("dao.board.selectReplyList", no);	// 여기로 넘겨줌
		ss.close();
		return list;
	}
}
