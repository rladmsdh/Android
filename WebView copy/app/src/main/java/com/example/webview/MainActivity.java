package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @SuppressLint({"SetJavaScriptEnabled", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_view);

        Button btnSignIn;
        TextView tvSignup;

        btnSignIn = findViewById(R.id.btn_signin);
        tvSignup = findViewById(R.id.tv_signup);

        btnSignIn.setOnClickListener(view -> Toast.makeText(getApplicationContext(),"로그인",Toast.LENGTH_SHORT).show());

        tvSignup.setOnClickListener(view -> {
            setContentView(R.layout.signup);
            Toast.makeText(getApplicationContext(),"회원가입",Toast.LENGTH_SHORT).show();
        });
    }
}