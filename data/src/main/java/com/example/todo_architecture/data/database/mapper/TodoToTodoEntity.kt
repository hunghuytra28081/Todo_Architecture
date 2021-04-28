package com.example.todo_architecture.data.database.mapper

import com.example.todo_architecture.data.database.TodoEntity
import com.example.todo_architecture.domain.entity.Todo

class TodoToTodoEntity {

    fun map(todo: Todo): TodoEntity {
        return TodoEntity(
            id = 0,
            title = todo.title,
            isDone = todo.isDone
        )
    }
}
