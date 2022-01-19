package com.koreait.smartapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class NaverAPI {
    public static String main(String... strings) {
        String result = null;
        String clientId = "VVCcnVdXognIBpor3nXF";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "XjEGIN2CjE";//애플리케이션 클라이언트 시크릿값";
        try {

            String text = URLEncoder.encode(strings[0], "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + text;

            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
            return response.toString();
        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }
    }
}
