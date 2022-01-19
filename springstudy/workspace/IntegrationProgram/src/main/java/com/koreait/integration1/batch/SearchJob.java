package com.koreait.integration1.batch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SearchJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
//		
//	    1) Job : SearchJob.java
//	    2) Listener : SearchListener.java
//	    3) 1분마다 SearchJob이 동작하도록 구현하시오.
//	    4) SearchJob은 {"코미디", "공포", "멜로", "드라마", "SF"} 
//		   이 다섯 가지 검색어 중에서 랜덤으로 검색어를 선택한 뒤 검색 결과를 받아온 뒤
//	       검색결과가 없는 경우에만 error.txt 파일을 생성하고 해당 파일에 검색결과 message를 저장하시오. 
//		   파일의 저장위치는 별도로 지정하지 말고, 기본위치를 사용하시오.

	   try {
	         String[] queries = {"코미디", "공포", "멜로", "드라마", "SF"};
	         String query = URLEncoder.encode(queries[(int)(Math.random() * queries.length)], "UTF-8");	
 			 String apiURL = "http://localhost:9091/integration1/searchboard/find?column=CONTENT&query=" + query;

 			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = "";
			while ( (line = br.readLine()) != null ) {
				sb.append(line);
			}
			JSONObject obj = new JSONObject(sb.toString()); // json 객체의 data
//			System.out.println("status : " + obj.getInt("status"));
			if (obj.getInt("status") == 500) {
				File file = new File("error.txt");
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				bw.write(obj.getString("message"));
				System.out.println("검색결과없음 파일 생성");
				bw.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	       

	}

}
