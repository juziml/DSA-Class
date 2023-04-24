package com.practice.lib

var str = "READY,"
fun main() {
    val l = arrayOf("1", "2", "3")
    run run@{
        l.forEach {
            beforeIf()
            if (it == "1") {
                return@run
            }
            afterIf()
        }
    }
    println(str)
}

fun inIf() {
    str += "inIf,"
}

fun afterIf() {
    str += "afterIf,"
}

fun beforeIf() {
    str += "beforeIf,"
}
