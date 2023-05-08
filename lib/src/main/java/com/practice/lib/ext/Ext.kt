package com.practice.lib.ext

fun String.print(secondTag: String? = null) {
    secondTag?.let {
        println("$it $this")
    }.let {
        println(this)
    }

}

fun <T> Array<T>.print() {
    forEachIndexed { index, t ->
        print("$t:$index,")
    }
}