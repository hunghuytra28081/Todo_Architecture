package com.example.todo_architecture.domain.interactor

import com.example.todo_architecture.domain.entity.Todo
import com.example.todo_architecture.domain.repository.Repository
import java.lang.IllegalArgumentException

class CreateTodo(
    private val repository: Repository
) {
    /*
        - Nội dung To do k đc rỗng
        - Khi tạo mới To do, mặc định để chưa hoàn thành
    */
    fun execute(title: String){
        if (title.isBlank()){
            throw IllegalArgumentException("Todo list not must be blank")
        }

        val todo = Todo(
            idEntity = "",
            title = title,
            isDone = false
        )
        repository.create(todo)
    }
}
