package search

import java.io.File

fun main(args: Array<String>) {
    var fileName = args[0]
    if (args[0] == "--data") {
        fileName = args[1]
    }
    val fileData = File(fileName).readLines().toTypedArray()
    search(fileData)
}

fun search (fileData: Array<String>) {
    var temp = mutableListOf<String>()
    var menu = "\n=== Menu ===\n1. Find a person\n2. Print all people\n0. Exit"
    println(menu)
    var menuSearchNum = readLine()!!.toInt()
    while (menuSearchNum != 0) {
        when (menuSearchNum) {
            1 -> {
                println("\nEnter a name or email to search all matching people.")
                val searchData = readLine()!!.toString()
                for (element in 0 until fileData.size){
                    if (fileData[element].contains(searchData) ||
                        fileData[element].toLowerCase().contains(searchData.toLowerCase()) ||
                        fileData[element].toUpperCase().contains(searchData.toUpperCase())) {
                        temp.add(fileData[element])
                    }
                }
                if (temp.size != 0) {
                    println("\nPeople found:")
                    for(element in 0 until temp.size){
                        println(temp[element])
                    }
                    temp.clear()
                } else {
                    println("No matching people found.")
                }
                println(menu)
                menuSearchNum = readLine()!!.toInt()
            }
            2 -> {
                println("\n=== List of people ===")
                for (element in 0 until fileData.size) {
                    println(fileData[element])
                }
                println(menu)
                menuSearchNum = readLine()!!.toInt()
            }
            0 -> break
            else -> {
                println("\nIncorrect option! Try again.")
                println(menu)
                menuSearchNum = readLine()!!.toInt()
            }
        }
    }
    println("\nBye!")
}
