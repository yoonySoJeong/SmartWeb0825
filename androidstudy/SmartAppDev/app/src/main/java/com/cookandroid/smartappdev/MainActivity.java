package com.cookandroid.smartappdev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editId;
    private EditText editPw;
    private EditText editEmail;
    private Button btnJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editId = findViewById(R.id.editId);
        editPw = findViewById(R.id.editPw);
        editEmail = findViewById(R.id.editEmail);
        btnJoin = findViewById(R.id.btnJoin);

        btnJoin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        // btnJoin을 클릭했는지 확인하는 코드
        if(view.getId() == R.id.btnJoin) {

        }
        switch (view.getId()) {
            case R.id.btnJoin :
                break;
        }

        // 입력 값 모으는 message
        String message = "";

        // 입력 및 선택
        // 아이디 비번
        String id = editId.getText().toString().trim();
        message += "아이디 : " + id + "\n";
        String pw = editPw.getText().toString().trim();
        message += "비밀번호 : " + pw + "\n";
        String email = editEmail.getText().toString().trim();
        message += "이메일은 " + email + "입니다.";


        // Toast
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}