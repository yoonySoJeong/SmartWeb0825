package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.StudentDAO;
import dto.Student;

public class InsertService implements StudentService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			
		// 파라미터
		String sno = request.getParameter("sno");
		String name = request.getParameter("name");
		String strMidterm = request.getParameter("midterm");
		String strFinalterm = request.getParameter("finalterm");
		int midterm = 0;
		if(strMidterm.isEmpty() == false) {
			midterm = Integer.parseInt(strMidterm);
		};
		int finalterm = 0;
		if(strFinalterm.isEmpty() == false) {
			midterm = Integer.parseInt(strFinalterm);
		};
		String pass;
		int avg =  (midterm + finalterm) / 2 ;
		if (avg >= 70) {
			pass = "Y";
		} else {
			pass = "N";
		}
		
		
		// DTO
		
		Student student = new Student();
		
		student.setSno(sno);
		student.setName(name);
		student.setMidterm(midterm);
		student.setFinalterm(finalterm);
		student.setPass(pass);
		
		
		// DB에 삽입
	
		int result = StudentDAO.getInstance().insert(student);
	
		
				
		// JSONObject 생성 (JSON 데이터)
		JSONObject obj = new JSONObject();
		obj.put("result", result > 0);
				
				
		// JSONObject 응답
		response.setContentType("application/json; charset=UTF");
		PrintWriter out = response.getWriter();
		out.println(obj);  // obj가 $.ajax의 success function()으로 전달
		out.close();
		// catch 블록의 response는 ajax의 error로 응답을 보냄.
		
		// 예외코드 정리
		// 2001 : 동일한 게시글번호 재등록, 필수 칼럼 누락
		// 2002 : 잘못된 데이터 전달(DB오류)
		// 2003 : 알 수 없는 예외
			
		} catch (SQLIntegrityConstraintViolationException e) {
			
			// 텍스트의 타입 : text/plain
			response.setContentType("text/plain; charset=UTF-8");
			
			// 에러 메시지 전달
			PrintWriter out = response.getWriter();
			out.println("점수는 정수만 입력 가능합니다1.");
			
			// 에러 코드 전달
			response.setStatus(2001);  // 에러 코드 2001 발생
			
		} catch (IOException e) {
			
			// 텍스트의 타입 : text/plain
			response.setContentType("text/plain; charset=UTF-8");
			
			// 에러 메시지 전달
			PrintWriter out = response.getWriter();
			out.println("점수는 정수만 입력 가능합니다2.");
			
			// 에러 코드 전달
			response.setStatus(2002);  // 에러 코드 2002 발생
			
		} catch (SQLException e) {
			
			// 텍스트의 타입 : text/plain
			response.setContentType("text/plain; charset=UTF-8");
			
			// 에러 메시지 전달
			PrintWriter out = response.getWriter();
			out.println("이미 존재하는 학번은 추가할 수 없습니다.");
			
			// 에러 코드 전달
			response.setStatus(2003);  // 에러 코드 2003 발생
			
		
		} catch (Exception e) {
		
		// 텍스트의 타입 : text/plain
		response.setContentType("text/plain; charset=UTF-8");
		
		// 에러 메시지 전달
		PrintWriter out = response.getWriter();
		out.println("입력데이터를 확인하세요.");
		
		// 에러 코드 전달
		response.setStatus(2004);  // 에러 코드 2004 발생
		
		}

	}
}
