package com.example.todo.Database


data class Todo (
    val id: String,
    val title: String,
    val detial: String,
    var status: Status

)
{
    enum class Status{
        COMPLETED, IN_PROGRESS, PENDING;

    }
}
