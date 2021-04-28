package com.example.todo_architecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.todo_architecture.domain.interactor.CreateTodo
import com.example.todo_architecture.domain.interactor.GetAllTodo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var getAllTodo: GetAllTodo
    lateinit var createTodo: CreateTodo

    override fun onCreate(savedInstanceState: Bundle?) {
        InjectionUtil.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        refreshData()
        addButton.setOnClickListener {
            createTodo.execute(todoEditText.text.toString())
            refreshData()
        }
    }
    fun refreshData(){
        val todos = getAllTodo()
        todoTextView.text = todos.toString()
    }
}
