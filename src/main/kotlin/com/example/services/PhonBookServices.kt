package com.example.services

import com.example.fileService.fileReading
import com.example.model.Contacts
import java.util.*

fun listCommands() {
    println("================ P H O N E   B O O K =================")
    println()
    println("'list' - lists all saved contacts in alphabetical order")
    println("'find by first name' - finds a contact by first name")
    println("'find by last name' - finds a contact by last name")
    println("'find by number' - find a contact by number")
    println("'add' - saves a new contact entry into the phone book")
    println("'help' - all valid commands")
    println("------------------------------------------------------")
    println("> ")
    val scanner = Scanner(System.`in`)
    val line: String = scanner.nextLine()
    when (line) {
        "list" -> fileReading("D:/HAMID/KOTLIN/PROJECTS/PhoneBook_Kotlin/phonebook.txt")
        "find by first name" -> findByFirstName(firstName = scanner.nextLine())
        "find by last name" -> findByLastName(lastName = scanner.nextLine())
        "find by number" -> findByPhoneNumber(phoneNumber = scanner.nextLine())
        "find by email" -> findByEmail(email = scanner.nextLine())
        "help" -> listCommands()
        else -> {
            println("Invalid command")
        }
    }
}

fun findByFirstName(firstName: String) {
    println("For searching the contact enter the 'first' name please :")
    println("> ")
    val scanner = Scanner(System.`in`)
    val file = fileReading("D:/HAMID/KOTLIN/PROJECTS/PhoneBook_Kotlin/phonebook.txt")
    val input = scanner.nextLine().trim()
    file.map { it-> it.firstName }
            println(file)
}

fun findByLastName(lastName: String) {
    println("For searching the contact , enter the 'last' name please :")
    println("> ")
    val scanner = Scanner(System.`in`)
    val file = fileReading("D:/HAMID/KOTLIN/PROJECTS/PhoneBook_Kotlin/phonebook.txt")
    val input = scanner.nextLine().trim()
    file.map { it-> it.lastName }
            println(file)
}

fun findByPhoneNumber(phoneNumber: String) {
    println("For searching the contact , enter the number please :")
    println("> ")
    val scanner = Scanner(System.`in`)
    val file = fileReading("D:/HAMID/KOTLIN/PROJECTS/PhoneBook_Kotlin/phonebook.txt")
    val input = scanner.nextLine().trim()
    file.map { it->it.phoneNumber }.filter { it->it.contains(input) }
    println(file)
}

fun findByEmail(email: String) {
    println("For searching the contact , enter 'email' please :")
    println("> ")
    val scanner = Scanner(System.`in`)
    val file = fileReading("D:/HAMID/KOTLIN/PROJECTS/PhoneBook_Kotlin/phonebook.txt")
    val input = scanner.nextLine().trim()
    for (entry in file) {
        if (entry.email.contains(input)) {
            println(entry.copy())
        }
    }
}