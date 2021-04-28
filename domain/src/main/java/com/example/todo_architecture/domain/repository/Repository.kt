package com.example.todo_architecture.domain.repository

import com.example.todo_architecture.domain.entity.Todo

interface Repository {

    fun getAllTodo(): List<Todo>

    //create new Entity, return todo idEntity
    fun create(todo: Todo): String
}
