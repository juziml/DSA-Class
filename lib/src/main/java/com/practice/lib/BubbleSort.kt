package com.practice.lib

val numbers = arrayOf(1, 3, 4, 1, 5, 9, 7, 6, 2)

fun main() {
    bubbleAsc(numbers)
}

// 冒泡排序是安全的排序算法
//最好 O(n),最坏O(n^2)
fun bubbleAsc(numbers: Array<Int>) {
    if (numbers.isEmpty()) return
    for (o in 0..numbers.size - 1) {
        var flag = false
        for (i in 0..numbers.size - 1 - o - 1) {
            val ln = numbers[i]
            val rn = numbers[i + 1]
            if (ln > rn) {
                numbers[i] = rn
                numbers[i + 1] = ln
                flag = true
            }
        }
        print("$o,")
        if (!flag) break
    }
    println("-")
    numbers.forEach {
        print("$it,")
    }
}