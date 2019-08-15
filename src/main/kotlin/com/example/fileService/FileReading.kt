package com.example.fileService

import com.example.model.Contacts
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun fileReading(fileName: String): MutableList<Contacts> {
    val fileName = "D:/HAMID/KOTLIN/PROJECTS/PhoneBook_Kotlin/phonebook.txt"
    val lines: List<String> = File(fileName).readLines().drop(1)
    var tr: MutableList<Contacts> = mutableListOf()
    tr.forEach { it -> println(it) }
    lines.forEach { line ->
        val sp = line.split("\t")

        val trans = Contacts(
            firstName = sp[0],
            lastName = sp[1],
            phoneNumber = listOf(sp[2]),
            email = listOf(sp[3])
        )
        tr.add(trans)
    }
    return tr
}
