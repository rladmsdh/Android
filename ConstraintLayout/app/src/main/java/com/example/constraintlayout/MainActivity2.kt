package com.example.constraintlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this,MainActivity3::class.java)
        startActivity(intent)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Toast.makeText(this,"흠",Toast.LENGTH_SHORT).show()
    }
}