package com.example.todo_architecture.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.todo_architecture.domain.entity.Todo

@Dao
abstract class TodoDao {

    @Query("SELECT * FROM todo")
    abstract fun getAllTodo(): List<TodoEntity>

    @Insert
    abstract fun insertTodo(todoEntity: TodoEntity)
}
