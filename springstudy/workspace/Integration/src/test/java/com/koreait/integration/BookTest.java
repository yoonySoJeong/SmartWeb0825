package com.koreait.integration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class BookTest {
	
	@Test
	public void 전체목록_테스트() {		// Ajax 형태라서 가능한 test
		try {
			String apiURL = "http://localhost:9091/integration/book/findAllBook";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = "";
			while ( (line = br.readLine()) != null ) { // 한 줄씩 읽으시오.
				sb.append(line);
			}
			JSONObject obj = new JSONObject(sb.toString()); // json 객체의 data
			System.out.println("status : " + obj.getInt("status"));
			System.out.println("message : " + obj.getString("message"));
			System.out.println();
			JSONArray arr = obj.getJSONArray("list");
			for ( int i = 0; i < arr.length(); i++ ) {
				JSONObject o = arr.getJSONObject(i);
				System.out.println("번호 : " + o.getInt("no"));
				System.out.println("제목 : " + o.getString("title"));
				System.out.println("미리보기 : " + o.getString("preview"));
				System.out.println("저자 : " + o.getString("author"));
				System.out.println("가격 : " + o.getInt("price"));
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
