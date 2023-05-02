package com.practice.lib
//冒泡排序
private val numbers = arrayOf(1, 3, 4, 1, 5, 9, 7, 6, 2)

fun main() {
    bubbleAsc(numbers)
}

// 冒泡排序是安全的排序算法
//最好 O(n),最坏O(n^2)
//每次冒泡都会将本剩余数据里最大的一次次冒到最后 size-o 的为止
//也就是往右边冒
fun bubbleAsc(numbers: Array<Int>) {
    if (numbers.isEmpty()) return
    for (o in 0 until numbers.size) {
        var flag = false
        for (i in 0 until numbers.size - o) {
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