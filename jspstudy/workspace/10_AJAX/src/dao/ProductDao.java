package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Product;
import mybatis.config.DBService;

public class ProductDao {
	
	private SqlSessionFactory factory;
	
	/* singleton */
	private static ProductDao instance;
	private ProductDao() {
		/* factory */
		factory = DBService.getInstance().getFactory();
	}
	public static ProductDao getInstance() {
		if(instance == null) {
			instance = new ProductDao();
		}
		return instance;
	}
	
	// 1. 제품 목록
	public List<Product> selectList() {
		SqlSession ss = factory.openSession();
		List<Product> list = ss.selectList("dao.product.selectList");
		ss.close();
		return list;
	}
	
	// 2. 제품명 중복체크
	public boolean nameCheck(String name) {
		SqlSession ss = factory.openSession();
		Product product = ss.selectOne("dao.product.nameCheck", name);
		ss.close();
		return product == null;
		
	}
	
	// 3. 제품 등록
	public int insert(Product product) {
		SqlSession ss = factory.openSession();
		int result = ss.insert("dao.product.insert", product);
		if (result > 0) ss.commit();
		return result;
	}
	
	// 4. 마지막 등록 제품명
	public Product prevInsertname() {
		SqlSession ss = factory.openSession();
		Product product = ss.selectOne("dao.product.prevInsertname");
		ss.close();
		return product;
	}
	
	// 5. 제품 삭제
	public int delete(Long pno) {		// Long type pno 받아온다
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("dao.product.delete", pno);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	
	
/*	// 5. 내가 작성 :: 전체 제품 수량 체크
	public int getTotalItems() {
		SqlSession ss = factory.openSession();	//세션열기
		int totalCount = ss.selectOne("dao.product.getTotalItems");
		ss.close(); 		// 받아 왔으니 닫기
		return totalCount;
	}
*/	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
