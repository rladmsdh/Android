package com.example.recyclerview_kt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class Adapter (private val item : ArrayList<Data>):RecyclerView.Adapter<Adapter.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return MainViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPos : Int = adapterPosition
                val data : Data = item.get(curPos)
                Toast.makeText(parent.context,"name:${data.name}\n나이:${data.age}\n직급:${data.classes}",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBindViewHolder(holder: Adapter.MainViewHolder, position: Int) {
        holder.name.text = item.get(position).name
        holder.age.text = item.get(position).age.toString()
        holder.classes.text = item.get(position).classes
    }

    override fun getItemCount(): Int {
        return item.size
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.name)
        val age = itemView.findViewById<TextView>(R.id.age)
        val classes = itemView.findViewById<TextView>(R.id.classes)
    }
}