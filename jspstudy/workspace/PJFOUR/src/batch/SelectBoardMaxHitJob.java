package batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dao.BoardDAO;
import dto.BoardDTO;

public class SelectBoardMaxHitJob implements Job {

	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		List<BoardDTO> list = BoardDAO.getInstance().selectMaxHit();
		File file = new File("maxHit.txt");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			for (BoardDTO boardDTO : list) {
				bw.write("작성자 : " + boardDTO.getAuthor() + "\n");
				bw.write("제목 : " + boardDTO.getTitle() + "\n");
				bw.write("게시글 조회수 : " + boardDTO.getHit() + "\n");
				bw.write("게시글 IP : " + boardDTO.getIp() + "\n");
				bw.write("게시글 내용 : " + boardDTO.getContent() + "\n");
				bw.write("게시일자 : " + boardDTO.getPostdate() + "\n");
			}
			System.out.println("maxHit.txt 파일 생성 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
