package command;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.MemberDAO;
import dto.Member;

public class InsertMemberCommand implements MemberService {

	public class AgeException extends Exception {
		public AgeException(String msg) {
			super(msg);
		}
	}
	
	public class NullDataException extends Exception {
		public NullDataException(String msg) {
			super(msg);
		}
		
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		try {
			
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String strAge = request.getParameter("age");
		int age = Integer.parseInt(strAge);
		String birthday = request.getParameter("birthday");
		
		if (age < 0 || age > 100) {
			throw new AgeException("나이의 범위는 0~100사이 정수입니다.");
		}
		
		/* 문자열의 null check는 Empty */
		if (no.isEmpty()|| name.isEmpty() || strAge.isEmpty() || birthday.isEmpty()) {
			throw new NullDataException("빈 곳 없이 채워주세요");
		}
		
		Member member = new Member();
		member.setNo(no);
		member.setName(name);
		member.setAge(age);
		member.setBirthday(birthday);
		
		int result = MemberDAO.getInstance().insertMember(member);
		
		JSONObject obj = new JSONObject();
		obj.put("result", result > 0);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.close();
		
		// 예외코드 정리
		// 2001 : 동일한 게시글번호 재등록, 필수 칼럼 누락
		// 2002 : 잘못된 데이터 전달
		// 2003 : 알 수 없는 에러	   ex) number format / null pointer ...etc.. exceptions
		
		
		
		/* 구현해야 할 Exception들 */
		// 1. 나이에 정수가 아닌 값을 입력한 경우 "나이는 정수만 입력 가능합니다."
		// 2. 나이에 0~100 범위가 아닌 값을 입력한 경우 "나이는 0~100 사이만 입력 가능합니다."
		
		} catch (SQLIntegrityConstraintViolationException e) {
			response.setContentType("text/plain; charset=UTF-8"); 
			PrintWriter out = response.getWriter();	
			out.println("동일한 회원번호는 입력할 수 없습니다.");		
			response.setStatus(2001);	
			
		} catch (SQLException e) {
			response.setContentType("text/plain; charset=UTF-8"); 
			PrintWriter out = response.getWriter();	
			out.println("입력 데이터를 확인하세요");		
			response.setStatus(2002);	
			
		} catch (NullDataException e) {	
			response.setContentType("text/plain; charset=UTF-8"); 
			PrintWriter out = response.getWriter();	
			out.println(e.getMessage());		
			response.setStatus(2003);	
		
		} catch (AgeException e) {
			response.setContentType("text/plain; charset=UTF-8"); 
			PrintWriter out = response.getWriter();	
			out.println(e.getMessage());		
			response.setStatus(2004);	
			
		} catch (Exception e) {
			response.setContentType("text/plain; charset=UTF-8"); 
			PrintWriter out = response.getWriter();	
			out.println("알 수 없는 예외가 발생했습니다.");		
			response.setStatus(2005);	
		}
		
	}

}