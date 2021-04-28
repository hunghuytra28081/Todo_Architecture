package com.example.todo_architecture.domain.interactor

import com.example.todo_architecture.domain.entity.Todo
import com.example.todo_architecture.domain.repository.Repository

class GetAllTodo(
    private val repository: Repository
) {
    operator fun invoke(): List<Todo> {
        return repository.getAllTodo()
    }
}
