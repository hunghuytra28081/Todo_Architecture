package com.example.todo_architecture

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Room
import com.example.todo_architecture.data.TodoRepositoryImpl
import com.example.todo_architecture.data.database.MyDatabase
import com.example.todo_architecture.data.database.TodoDao
import com.example.todo_architecture.data.database.mapper.TodoEntityToTodo
import com.example.todo_architecture.data.database.mapper.TodoToTodoEntity
import com.example.todo_architecture.domain.interactor.CreateTodo
import com.example.todo_architecture.domain.interactor.GetAllTodo
import com.example.todo_architecture.domain.repository.Repository

@SuppressLint("StaticFieldLeak")
object InjectionUtil {

    private lateinit var context: Context
    private val getAllTodo: GetAllTodo by lazy {
        GetAllTodo(repository = repoImpl)
    }
    private val createTodo: CreateTodo by lazy {
        CreateTodo(repository = repoImpl)
    }

    fun inject(activity: MainActivity) {
        context = activity.applicationContext
        activity.getAllTodo = getAllTodo
        activity.createTodo = createTodo
    }

    val database: MyDatabase by lazy {
        Room.databaseBuilder(
            context,
            MyDatabase::class.java,
            "Sample.db"
        )
            .allowMainThreadQueries()
            .build()
    }

    val dao: TodoDao by lazy {
        database.dao()
    }

    private val repoImpl: Repository by lazy {
        TodoRepositoryImpl(
            dao = dao,
            todoEntityToTodo = TodoEntityToTodo(),
            todoToTodoEntity = TodoToTodoEntity()
        )
    }
}
