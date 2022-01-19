package com.koreait.integration1;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class SearchBoardTest {

	@Test
	public void test() {
		
		try {
			String apiURL = "http://localhost:9091/integration1/searchboard/find?column=TITLE" + "&query="+URLEncoder.encode("액션", "UTF-8");
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = "";
			while ( (line = br.readLine()) != null ) { // 한 줄씩 읽으시오.
				sb.append(line);
			}
			JSONObject obj = new JSONObject(sb.toString()); // json 객체의 data
//			System.out.println("status : " + obj.getInt("status"));
//			System.out.println("message : " + obj.getString("message"));
			if (obj.getInt("status") == 200) {
				JSONArray arr = obj.getJSONArray("list");
				for ( int i = 0; i < arr.length(); i++ ) {
					JSONObject o = arr.getJSONObject(i);
					System.out.println("번호 : " + o.getInt("no"));
					System.out.println("제목 : " + o.getString("title"));
					System.out.println("내용 : " + o.getString("content"));
					System.out.println("작성일 : " + o.getString("regDate"));	
					System.out.println();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
