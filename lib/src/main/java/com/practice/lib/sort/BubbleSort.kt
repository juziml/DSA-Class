package com.practice.lib.sort

import com.practice.lib.ext.printElement

//冒泡排序
private val numbers1 = arrayOf(64, 34, 25, 12, 22, 11, 90)
private val numbers2 = arrayOf(1, 2, 3, 9, 1, 4, 5, 6)

fun main() {
    bubbleAsc(numbers1)
    numbers1.printElement("bubbleAsc")
    bubbleSort(numbers2)
    numbers2.printElement("bubbleSort")
}

// 冒泡排序是安全的排序算法
//最好 O(n),最坏O(n^2)
//每次冒泡都会将本剩余数据里最大的一次次冒到最后 size-o 为止
//也就是往右边冒
//外侧循环 控制遍历次数，
//内侧循环 控制 未排序范围的数进行冒泡， i ,i+1 进行比对，交换位置
fun bubbleAsc(numbers: Array<Int>) {
    if (numbers.isEmpty()) return
    for (o in 0 until numbers.size - 1) {
        var flag = false
        for (i in 0 until numbers.size - o - 1) {
            val ln = numbers[i]
            val rn = numbers[i + 1]
            if (ln > rn) {
                numbers[i] = rn
                numbers[i + 1] = ln
                flag = true
            }
        }
        //无数据交换时，确定完全有序，退出循环
        if (!flag) break
    }
    numbers.forEach {
        print("$it,")
    }
}

// for GPT
fun bubbleSort(arr: Array<Int>) {
    val n = arr.size
    var temp: Int
    for (i in 0 until n - 1) {
        for (j in 0 until n - i - 1) {
            if (arr[j] > arr[j + 1]) {
                // 交换相邻两个元素的位置
                temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
}