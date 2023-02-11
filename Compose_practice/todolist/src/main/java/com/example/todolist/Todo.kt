package com.example.todolist

data class Todo(
    var text : String = "",
    var done : Boolean = false,
    var onEdit : Boolean = true,
) : java.io.Serializable{

}
