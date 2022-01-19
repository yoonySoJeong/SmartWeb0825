package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Employee;
import mybatis.config.DBService;

public class EmployeeDao {
	
	/* factory SqlSession*/
	private SqlSessionFactory factory;
	private static EmployeeDao instance;
	private EmployeeDao() {
		factory = DBService.getInstance().getFactory();
	}
	
	public static EmployeeDao getInstance() {
		if (instance == null) {
			instance = new EmployeeDao();
		}
		return instance;
	}
	
	// 1. Employee List
	public List<Employee> selectAllEmployee() {
		SqlSession ss = factory.openSession();
		List<Employee> list = ss.selectList("dao.employee.selectAllEmployee");
		ss.close();
		return list;
	}
	
	// 2. Count All Employees 
	public int getTotalCount() {
		SqlSession ss = factory.openSession();
		int totalCount = ss.selectOne("dao.employee.getTotalCount");
		ss.close();
		return totalCount;
	}
	
	// 3. salary average
	public double getAverage() {
		SqlSession ss = factory.openSession();
		double average = ss.selectOne("dao.employee.getAverage");
		ss.close();
		return average;
	}
	
	// 4. add employee
	public int insertEmployee(Employee employee) {
		SqlSession ss = factory.openSession(false);	// not auto commit
		int result = ss.insert("dao.employee.insertEmployee", employee);
		if (result > 0) ss.commit(); 		// insert success
		ss.close();
		return result;						// result : 0 or 1
	}
	
	// 5. employee detail
	public Employee selectOneEmployee(Long eno) {
		SqlSession ss = factory.openSession();
		Employee employee = ss.selectOne("dao.employee.selectOneEmployee", eno);
		ss.close();
		return employee;
	}
	
	//6. employee update
	public int updateEmployee(Employee employee) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.employee.updateEmployee", employee);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	
}
