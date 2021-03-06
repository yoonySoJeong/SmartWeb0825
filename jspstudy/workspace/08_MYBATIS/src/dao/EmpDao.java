package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.EmpDto;
import mybatis.config.MybatisSetting;

public class EmpDao {
	
	// SqlSessionFactory를 받아서 필드로 저장해 두고,
	// 각 메소드(삽입, 수정, 삭제, 조회)들이 해당 SqlSessionFactory를 사용한다. --> factory 를 받아오는 code가 필요하다
	private SqlSessionFactory factory;								// <<== ^
	
	/* singleton */
	private static EmpDao instance;
	private EmpDao() {			// 외부 생성을 막아주는 private 생성자
		factory = MybatisSetting.getInstance().getFactory();
	}
	public static EmpDao getInstance() {
		if (instance == null) {
			instance = new EmpDao();	// 안 만들어 졌으면 만들고
		}
		return instance;				// 그것을 반환하라.
	}
	
	/* 메소드 */
	
	/* 앞으로 하게 될 작업 약속
	   "메소드이름"을 매퍼의 태그 id 속성으로 사용한다.	 
	*/
	
	// 0. 사용할 매퍼의 namespace 저장하기
	private final String NAMESPACE = "mybatis.mapper.sqlmap";
	
	
	
	// 1. 사원 목록 반환하는 메소드
	public List<EmpDto>	selectEmpList() {
		
		// 1) 쿼리는 sqlmap.xml(매퍼)에 <select>태그에 작성
		// SELECT num, name, salary, hire FROM emp ORDER BY num DESC;
		
		// 2) sqlmap.xml(매퍼)에 있는 <select> 태그 실행
		// <select> 태그의 id 속성으로 호출
		
		// 3) <select> 태그 호출 방법
		// 	  (1) selectOne()  :  반환 결과가 1개
		//    (2) selectList() :  반환 결과가 여러 개
		
		// 실제 구현
		
		
		
		// 1. SqlSession 구하기		
		SqlSession ss = factory.openSession();		// SqlSession의 객체를 구함 --> ss
		
		// 2. <select id="selectEmpList"> 태그를 호출할 메소드 호출하기
		// sqlmap.xml 구성
		// <mapper namespace="mybatis.mapper.sqlmap">
		//		<select id="selectEmpList">
		
		List<EmpDto> list = ss.selectList(NAMESPACE + ".selectEmpList");	// namespace + id
		
		// 3. SqlSession 객체 반납하기
		ss.close();  								 // 다 썼으면 닫아주기
		
		// 4. 결과 반환
		return list;
	}
	
	
	// 2. 사원 정보 반환
	public EmpDto selectEmpByNum(Long num) {		// num을 이용한 검색
		
		// 1) SqlSession 객체 생성 : factory에서 뽑기
		SqlSession ss = factory.openSession();		// select 처리는 openSession() : 인수 없음
		
		// 2) sqlmap.xml(매퍼)에서 <select> 태그 호출
		EmpDto empDto = ss.selectOne(NAMESPACE + ".selectEmpByNum", num);
		
		// 3) SqlSession 객체 반납
		ss.close();
		
		// 4) 결과 반환
		return empDto;
				
	}
	
	
	// 3. 사원 삭제
	public int deleteEmp(Long num) {
		
		// 1) SqlSession 객체 생성 
		//	  DML(insert, update, delete)은 수행 후 commit() 이 필요하다.
		//	  commit()을 직접 호출할 수 있도록 openSession(false) 방식으로 호출한다.
		SqlSession ss = factory.openSession(false);
		
		// 2) sqlmap.xml(매퍼)의 <delete> 태그 호출
		int result = ss.delete(NAMESPACE + ".deleteEmp", num);
		
		// 3) 삭제 성공하면 commit()
		if (result > 0) {
			ss.commit();
		}
		
		// 4) SqlSession 객체 반납
		ss.close();
		
		// 5) 결과 반환
		return result;
		
	}
	
	// 4. 사원 수정
	public int updateEmp(EmpDto empDto) {
		
		SqlSession ss = factory.openSession(false);		// false는 commit() 하고 싶어서임.
		
		int result = ss.update(NAMESPACE + ".updateEmp", empDto);
		
		if (result > 0) {
			ss.commit();
		}
		
		ss.close();
		
		return result;
	}
	
	// 5. 사원 삽입
	public int insertEmp(Map<String, Object> map) {
		
		SqlSession ss =factory.openSession(false);
		
		int result = ss.insert(NAMESPACE + ".insertEmp", map);
		
		if (result > 0) {
			ss.commit();
		}
		ss.close();
		
		return result;
		
	}

}
