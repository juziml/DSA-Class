package com.practice.lib.ext

import java.lang.StringBuilder

fun String.printSelf(secondTag: String = "") {
    println("$secondTag : $this")
}

fun <T> Array<T>.printElement(tag: String = "") {
    println("\n $tag >:")
    val elements = StringBuilder("elements: ")
    val indices = StringBuilder("index: ")
    forEachIndexed { index, t ->
        elements.append("$t:")
        indices.append("$index:")
    }
    println(elements)
    println(indices)
}

fun IntArray.printElement(tag: String = "") {
    println("\n $tag >:")
    val elements = StringBuilder("elements: ")
    val indices = StringBuilder("index___: ")
    forEachIndexed { index, t ->
        elements.append("$t:")
        indices.append("$index:")
    }
    println(elements)
    println(indices)
}
