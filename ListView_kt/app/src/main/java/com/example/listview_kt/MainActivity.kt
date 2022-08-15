package com.example.listview_kt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    var UserList = arrayListOf<User>(
        User("rladmsdh","12345","hi~"),
        User("rladmsd","1234","hi!"),
        User("rladms","123","hello"),
        User("rladm","12","hi"),
        User("rlad","1","hi")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        val button = findViewById<Button>(R.id.button)
        val Adapter = UserAdapter(this,UserList)
        listView.adapter = Adapter
        /*
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this,selectItem.name,Toast.LENGTH_SHORT).show()
        }*/
        button.setOnClickListener{
            UserList.add(User("kim","14","hi"))
            Adapter.notifyDataSetChanged()
        }
    }
}