package com.example.clickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;

    Button btnUp;
    Button btnReset;
    Button btnDown;

    int result;

    ImageView ivIceCream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);

        btnUp = findViewById(R.id.btnUp);
        btnReset = findViewById(R.id.btnReset);
        btnDown = findViewById(R.id.btnDown);


        ivIceCream = findViewById(R.id.ivIceCream);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = 0;
                tvResult.setText(String.valueOf(result));
            }
        });

        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result--;
                tvResult.setText(String.valueOf(result));
            }
        });
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result++;
                tvResult.setText(String.valueOf(result));

                if (result == 10) {
                    ivIceCream.setImageResource((R.drawable.singler));
                } else if (result == 20) {
                    ivIceCream.setImageResource((R.drawable.paint));
                } else if (result == 30) {
                    ivIceCream.setImageResource((R.drawable.quarter));
                } else if (result == 40) {
                    ivIceCream.setImageResource((R.drawable.familiy));
                    Toast.makeText(getApplicationContext(),"성공:)",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}