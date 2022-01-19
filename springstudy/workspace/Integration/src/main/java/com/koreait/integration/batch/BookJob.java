package com.koreait.integration.batch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class BookJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		// 저자 "황순원", "생텍쥐베리" 중 임의로 한 명의 정보를 이용하여 도서를 검색한 결과를 출력하시오.
		// (도서 정보의 파일을 생성하시오)

	   try {
	          
	         String apiURL = "http://localhost:9091/integration/book/findAllBook";
	         URL url = new URL(apiURL);
	         HttpURLConnection con = (HttpURLConnection)url.openConnection();
	         //   System.out.println("con: "+con);   //ok
	         
	         BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	         StringBuilder sb = new StringBuilder();
	         String line = "";
	         while( (line = br.readLine()) != null ) {
	            sb.append(line);
	         }
	         br.close();

	         JSONObject obj = new JSONObject(sb.toString());
	         JSONArray arr = obj.getJSONArray("list");
	         
	         
	         
	         ////////////////////// 전체 북리스트에서 저자값만 저장하는 List /////////////////////////////
	         
	         List<String> list = new ArrayList<>();
	         
	         for( int i=0; i<arr.length(); i++) {
	            // arr[i]=JSONObject이다.          jsonObject안에 list가 있고 list=jsonObject이기 때문에 한번 더 꺼내서 확인해야한다.  
	            // list가 배열이기 때문에 for문 돌려야 확인 가능
	            JSONObject o =   arr.getJSONObject(i);    // getJSONObject()은 제이슨 객체를 꺼낼수있다.   o에는 각 list 존재함     => 저자1명이 여러 책을 쓸 수 있으므로 list는 배열 
	            list.add(o.getString("author"));
	         }
	         
	      
	         // 무작위로 저자 나옴
	         int n = (int)(Math.random()*list.size());
	         // System.out.println(list.get(n));    
	         
	         
	         
	         //////////////////////////////////////무작위로 나온 작가 파라미터 전달해서 객체받기///////////////////////////////////////////////////////////////////// 
	         
	         apiURL = "http://localhost:9091/integration/book/findBook?column=AUTHOR&query="+ URLEncoder.encode(list.get(n), "utf-8");
	          url = new URL(apiURL);
	           con = (HttpURLConnection)url.openConnection();
	         //   System.out.println("con: "+con);   //ok
	         System.out.println("api검색 : "+apiURL );
	          br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	          sb = new StringBuilder();
	          line = "";
	          while( (line = br.readLine()) != null ) {
	            sb.append(line);
	           }
	         br.close();

	         obj = new JSONObject(sb.toString());
	         arr = obj.getJSONArray("list");
	         JSONObject o = null;
	         for( int i=0; i<arr.length(); i++) {     //    제이슨오브젝트안에 list가 있고 list는 제이슨오브젝트이기 때문에 한번 더 꺼내서 확인해야한다. list가 배열이기 때문에 for문 돌려야 확인 가능
	                                                 // arr[i]=JSONObject이다.          제이슨오브젝트안에 list가 있고 list는 제이슨오브젝트이기 때문에 한번 더 꺼내서 확인해야한다. list가 배열이기 때문에 for문 돌려야 확인 가능
	          o =   arr.getJSONObject(i);                // getJSONObject()은 제이슨 객체를 꺼낼수있다.
	         System.out.println("번호 : " + o.getInt("no"));
	         System.out.println("제목 : " + o.getString("title"));
	         System.out.println("개요 : " + o.getString("preview"));
	         System.out.println("저자 : " + o.getString("author"));
	         System.out.println("가격 : " + o.getInt("price"));
	         System.out.println(" ");
	         }
	         
	         // File 생성 
	         File file = new File(o.getString("author")+"_author.txt");  // 공백 절대 금지.
	         
	         BufferedWriter bw = new BufferedWriter(new FileWriter(file)); // 파일에 쓰기
	            bw.write("번호 : " + o.getInt("no")+" \n");
	            bw.write("제목 : " +o.getString("title")+" \n");
	            bw.write( "개요 : " + o.getString("preview")+" \n");
	            bw.write( "저자 : " + o.getString("author")+" \n");
	            bw.write("가격 : " + o.getInt("price")+"");
	            bw.close();
	            System.out.println(file + "파일 생성 완료");
	       } catch(Exception e) {
	          e.printStackTrace();
	       }
	       

	}

}
