package com.example.fileService

import com.example.model.Contacts
import java.io.File
import java.io.IOException
import java.io.PrintWriter
import java.lang.System.out
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun fileReading(fileName: String): MutableList<Contacts> {
    val fileName = "D:/HAMID/KOTLIN/PROJECTS/PhoneBook_Kotlin/phonebook.txt"
    val lines: List<String> = File(fileName).readLines()
    var tr: MutableList<Contacts> = mutableListOf()
    tr.forEach { it -> println(it) }
    lines.sorted().forEach { line ->
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
fun fileWriting(contacts:MutableList<Contacts>) {
    try {
        PrintWriter("D:/HAMID/KOTLIN/PROJECTS/PhoneBook_Kotlin/phonebook.txt")
            .use { writer ->
                if (contacts.isNotEmpty()) {
                    for ((key, value) in contacts) {
                        val line = String.format(key, value)
                        writer.println(line)
                    }
                }
            }
    } catch (ioex: IOException) {
        System.err.println(ioex.message)
    }

}