package com.practice.lib

val numbers = arrayOf(2, 3, 4, 1, 5, 9, 7, 6, 1)

fun main() {
    bubbleAsc(numbers)
}

fun bubbleAsc(numbers: Array<Int>) {
    for (o in 0..numbers.size - 1) {
        for (i in 0..numbers.size - 1 - o - 1) {
            val ln = numbers[i]
            val rn = numbers[i + 1]
            if (ln > rn) {
                numbers[i] = rn
                numbers[i + 1] = ln
            }
        }
    }
    numbers.forEach {
        print("$it,")
    }
}