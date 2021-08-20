package com.azharul.kotlinlearning

import com.azharul.kotlinlearning.model.Employee
import com.azharul.kotlinlearning.model.Person

fun main() {
    var language = "Kotlin"
    language = "java"

    //Constant->Immutable
    val country = "Bangladesh"
    //Object type
    //Int
    var number: Int = 4
    //Double
    var doubles: Double = 4.2
    //Boolean
    var booleans: Boolean = true
    //Float
    var floats: Float = 2.6f
    //Char
    var chars: Char = 'a'
    //Null
    var name: String? = null
    var amount: Int? = null
    var address: String = "Dhaka"

    println("Hello name  $name")
    println("Hello amount  $amount")
    println("Hello address  $address")
    println("_______________________function________________")
    name = "Azharul"
    info(name)
    //String Interpolation
    println("Get name ${getName(name)}")
    var person = Person(70)
    person.personAge()
    println("_______________________function expression________________")
    var maxValue = maxNumber(10, 12)
    println("The max number is $maxValue")
    println("_______________________function default parameters________________")
    var areaValue = area(5, 2,80)
    println("Area value $areaValue")
    println("_______________________function named parameters________________")
    findVolume(length = 70,width = 50,height = 90)
    findVolume(length = 70,width = 50)
    println("_______________________Primary Constructor________________")
    var employee=Employee("Azhar");
    employee.name="Anwar"
    employee.getEmployeeName()
    println("_______________________Secondary Constructor________________")
    var employee1=Employee("Kotlin",10);
    println(employee1.id)
}

fun info(name: String) {
    println("My name is $name")
}

fun getName(name: String): String {
    return name
}

fun maxNumber(number1: Int, number2: Int): Int = if (number1 > number2) number1 else number2

fun area(length: Int, width: Int, height: Int = 10): Int {
    return length * height * width
}fun findVolume(length: Int, width: Int, height: Int = 10) {
   println("Volume length: $length")
   println("Volume width: $width")
   println("Volume height: $height")
}