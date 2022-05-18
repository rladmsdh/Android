package com.example.plu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button plu,sub,one,equal,two,three,four,five,six,seven,eight,nine,zero;

    private TextView ans;

    private int k=0,i=0,s=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ans = findViewById(R.id.ans);

        findViewById(R.id.sub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                k+=i;
                i=0;
                s=-1;
                ans.setText("-");
            }
        });

        findViewById(R.id.c).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                k=0;
                i=0;
                s=1;
                ans.setText(Integer.toString(k));
            }
        });

        findViewById(R.id.plu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                k+=i;
                i=0;
                ans.setText("+");
            }
        });

        findViewById(R.id.equal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                k+=i*s;
                i=0;
                s=1;
                ans.setText(Integer.toString(k));
            }
        });

        findViewById(R.id.one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i*=10;
                i+=1;
                ans.setText(Integer.toString(i));
            }
        });

        findViewById(R.id.two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i*=10;
                i+=2;
                ans.setText(Integer.toString(i));
            }
        });

        findViewById(R.id.three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i*=10;
                i+=3;
                ans.setText(Integer.toString(i));
            }
        });

        findViewById(R.id.four).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i*=10;
                i+=4;
                ans.setText(Integer.toString(i));
            }
        });

        findViewById(R.id.five).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i*=10;
                i+=5;
                ans.setText(Integer.toString(i));
            }
        });

        findViewById(R.id.six).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i*=10;
                i+=6;
                ans.setText(Integer.toString(i));
            }
        });

        findViewById(R.id.seven).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i*=10;
                i+=7;
                ans.setText(Integer.toString(i));
            }
        });

        findViewById(R.id.eight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i*=10;
                i+=8;
                ans.setText(Integer.toString(i));
            }
        });

        findViewById(R.id.nine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i*=10;
                i+=9;
                ans.setText(Integer.toString(i));
            }
        });

        findViewById(R.id.zero).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i*=10;
                ans.setText(Integer.toString(i));
            }
        });
    }
}