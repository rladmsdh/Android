package com.example.lifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 액티비티 또는 프래그먼트가 생성이 되었을 때 실행
        Log.e("onCreate","ENTER")

        findViewById<Button>(R.id.btn).setOnClickListener{
            val intent = Intent(this,SubActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart","ENTER")
    }

    override fun onResume() {
        super.onResume()
        //중지 되어있던 액티비티가 다시 재 실행 되는 시점에서 실행
        Log.e("onResume","ENTER")
    }

    override fun onPause() {
        super.onPause()
        //중지 상태(홈 버튼을 눌러서 바깥으로 잠깐 빠져나갔을 때,다른 액티비티가 활성화 되어있을 때) 일 때 실행
        Log.e("onPause","ENTER")
    }

    override fun onStop() {
        super.onStop()
        Log.e("onStop","ENTER")
    }

    override fun onDestroy() {
        super.onDestroy()
        //화면이 파괴되어서 소멸했을 때의 시점 일 때 실행
        Log.e("onDestroy","ENTER")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("onRestart","ENTER")
    }
}