package com.example.recyclerview_kt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.helper.widget.Carousel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rv)

        var itemlist = arrayListOf<Data>(
            Data("rladmsdh", "student", 12),
            Data("rladmsdh", "student", 13),
            Data("rladmsdh", "student", 14),
            Data("rladmsdh", "student", 15)
        )

        rv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv.setHasFixedSize(true)
        rv.adapter = Adapter(itemlist)
    }
}