package com.example.listview_kt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class UserAdapter (val context: Context,val UserList:ArrayList<User>):BaseAdapter()
{
    override fun getCount(): Int {
        return UserList.size
    }

    override fun getItem(position: Int): Any {
        return UserList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View = LayoutInflater.from(context).inflate(R.layout.list_item,null)

        val name = view.findViewById<TextView>(R.id.name);
        val greet = view.findViewById<TextView>(R.id.greet);
        val age = view.findViewById<TextView>(R.id.age);

        val user = UserList[position]

        name.text = user.name
        greet.text = user.greet
        age.text = user.age

        return view
    }

}