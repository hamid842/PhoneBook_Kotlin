package com.example

import com.example.fileService.fileReading

fun main(args: Array<String>) {
    val fileContent = fileReading("D:/HAMID/KOTLIN/PROJECTS/PhoneBook_Kotlin/phonebook.txt")
    println(fileContent)
}