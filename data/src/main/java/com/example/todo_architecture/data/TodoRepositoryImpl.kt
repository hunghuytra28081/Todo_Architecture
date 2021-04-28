package com.example.todo_architecture.data

import com.example.todo_architecture.data.database.TodoDao
import com.example.todo_architecture.data.database.TodoEntity
import com.example.todo_architecture.data.database.mapper.TodoEntityToTodo
import com.example.todo_architecture.data.database.mapper.TodoToTodoEntity
import com.example.todo_architecture.domain.entity.Todo
import com.example.todo_architecture.domain.repository.Repository
import java.util.*

class TodoRepositoryImpl(
    private val dao: TodoDao,
    private val todoToTodoEntity: TodoToTodoEntity,
    private val todoEntityToTodo: TodoEntityToTodo
): Repository {

    override fun getAllTodo(): List<Todo> {
        val entityList: List<TodoEntity> = dao.getAllTodo()
        return entityList.map { entity ->
            todoEntityToTodo.map(entity)
        }
    }

    override fun create(todo: Todo): String {
        val entity = todoToTodoEntity.map(todo)
        dao.insertTodo(entity)
        return ""
    }
}
