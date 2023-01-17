package com.example.koin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.core.component.getScopeId

class MainActivity : AppCompatActivity() {

    // inject() 의존성 주입 - Lazy 방식
    private val bb_inject1 : BB by inject()	// inject Type 유형 1 - Type by inject()
    private val bb_inject2 by inject<BB>()	// inject Type 유형 2 - by inject<Type>()

    // get() 의존성 주입 - 바로 주입 방식
    private var bb_get1 : BB = get()	// get Tpye 유형 1 - Type = get()
    private var bb_get2 = get<BB>()		// get Type 유형 2 - get<Type>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this@MainActivity,"${bb_inject1.name()},${bb_inject2.name()},${bb_get1.name()},${bb_get2.name()}",Toast.LENGTH_SHORT).show()
    }
}