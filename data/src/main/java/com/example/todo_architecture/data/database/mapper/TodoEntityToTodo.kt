package com.example.todo_architecture.data.database.mapper

import com.example.todo_architecture.data.database.TodoEntity
import com.example.todo_architecture.domain.entity.Todo

class TodoEntityToTodo {

    fun map(entity: TodoEntity): Todo {
        return Todo(
            idEntity = entity.toString(),
            title = entity.title,
            isDone = entity.isDone
        )
    }
}
