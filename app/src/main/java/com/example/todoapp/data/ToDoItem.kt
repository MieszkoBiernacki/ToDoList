package com.example.todoapp.data

data class ToDoItem(
    val id: Long = 0L,
    val itemName: String,
    val itemDesc: String,
    val statur: Boolean = false
)

object test{
    var testList = listOf(
        ToDoItem(itemName = "item 1 name", itemDesc = "item 1 desc"),
        ToDoItem(itemName = "item 2 name", itemDesc = "item 2 desc"),
        ToDoItem(itemName = "item 3 name", itemDesc = "item 3 desc"),
        ToDoItem(itemName = "item 4 name", itemDesc = "item 4 desc")
    )
}
