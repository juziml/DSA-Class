package com.practice.lib

fun String.print(secondTag: String? = null) {
    secondTag?.let {
        println("$it $this")
    }.let {
        println(this)
    }

}