package com.azharul.kotlinlearning.model

class Employee(var name: String) {
    var id = -1

    init {
        println("Here is $name")
    }

    fun getEmployeeName() {
        println("Get employee name $name")
    }

    constructor(name: String, id: Int) : this(name) {
        this.id = id
    }

}