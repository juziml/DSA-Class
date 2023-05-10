package com.practice.lib.ext

fun String.printElement(secondTag: String? = null) {
    secondTag?.let {
        println("$it $this")
    }.let {
        println(this)
    }

}

fun <T> Array<T>.printElement(tag: String = "") {
    println("$tag >:")
    print("element:")
    forEachIndexed { index, t ->
        print("$t:")
    }
    println()
    print("index  :")
    forEachIndexed { index, t ->
        print("$index:")
    }
    println()
}