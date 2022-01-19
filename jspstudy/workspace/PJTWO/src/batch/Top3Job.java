package batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dao.BoardDao;
import dto.Board;

public class Top3Job implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

		// STUDENT 테이블에서 ave 순으로 TOP3 가져오기
		List<Board> list = BoardDao.getInstance().selectAllBoardList();
		
		// LIST를 파일로 만들기
		File file = new File("allboardList.txt");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {	// try - catch resource 의 특징 try()안에 사용할 resource를 지정하여 진행되고난 뒤, 자동으로 종료하여, close를 따로 해주지 않아도 됨.
			for (Board board : list) {
				bw.write(board.getIdx() + ",");
				bw.write(board.getTitle() + ",");
				bw.write(board.getWriter() + ",");
				bw.write(board.getContent() + ",");
				bw.write(board.getRegister() + "\n");
			}
			System.out.println("allboardList.txt 파일 생성 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
