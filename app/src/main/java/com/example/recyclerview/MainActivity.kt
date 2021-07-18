package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var todoList = mutableListOf(
            Todo("Wake Up", false),
            Todo("Get the shit out of your ass", false),
            Todo("Brush your teeth", false),
            Todo("Finally, Get some tea!!", false)
        )
        val adapter = ToDoAdapter(todoList)
        val rvTodos = findViewById<RecyclerView>(R.id.rvTodos)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)

        val button = findViewById<Button>(R.id.button)
        val etTodo = findViewById<EditText>(R.id.etTodo)
        button.setOnClickListener {
            val title = etTodo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size-1)
        }
    }
}