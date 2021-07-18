package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ToDoAdapter (
    var todos : List<Todo>
        ):RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>(){
    inner class ToDoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)//we need to create one data class

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.to_do_item, parent, false)
        return ToDoViewHolder(view)
        //in most of the cases this function remains as it is here
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.itemView.apply {
            val tvTodoItem = findViewById<TextView>(R.id.tvTodoItem)
            tvTodoItem.text = todos[position].title
            val cbcheckBox = findViewById<CheckBox>(R.id.cbcheckBox)
            cbcheckBox.isChecked = todos[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}