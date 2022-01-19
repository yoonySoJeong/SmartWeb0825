package com.koreait.smartapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    InputMethodManager imm;
    ImageButton btnVoice;
    EditText edtSearch;
    Button btnSearch;
    ListView listView;
    private Book book;
    CustomAdapter adapter;
    private static final int RESULT_SPEECH = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtSearch = findViewById(R.id.edt_search);
        listView = findViewById(R.id.list_result);
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        btnVoice = findViewById(R.id.btn_mic);
        btnVoice.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                startActivityForResult(intent, RESULT_SPEECH);
            }
        });
        btnSearch = findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                book = new Book();
                book.execute(edtSearch.getText().toString());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    public class Book extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String result = null;
            String clientId = "VVCcnVdXognIBpor3nXF";
            String clientSecret = "XjEGIN2CjE";
            try {
                String text = URLEncoder.encode(strings[0], "UTF-8");
                String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + text;

                URL url = new URL(apiURL);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("X-Naver-Client-Id", clientId);
                con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
                int responseCode = con.getResponseCode();
                BufferedReader br;
                if (responseCode == 200) { // 정상 호출
                    br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                } else {  // 에러 발생
                    br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                }
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                    response.append("\n");
                }
                br.close();


                adapter = new CustomAdapter(MainActivity.this);


                StringBuilder sb = new StringBuilder();

                JSONObject obj1 = new JSONObject(sb.toString());
                JSONArray array = obj1.getJSONArray("items");
                for (int i = 0, length = array.length(); i < length; i++) {
                    JSONObject book = array.getJSONObject(i);
                    String image = book.getString("image");
                    String title = "도서명 : " + book.getString("title").replaceAll("<.+?>", "");
                    String author = "저자 : " + book.getString("author");
                    String publisher = "출판사 : " + book.getString("publisher");
                    adapter.addItem(image, title, author + ", " + publisher);
                }

            } catch (Exception e) {
                Log.e("RUN", e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            listView.setAdapter(adapter);
        }

    }

}