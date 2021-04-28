package com.example.todo_architecture.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TodoEntity::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun dao(): TodoDao
}
