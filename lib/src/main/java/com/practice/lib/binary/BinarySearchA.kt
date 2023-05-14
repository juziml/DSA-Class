package com.practice.lib.binary

import com.practice.lib.ext.printElement
import com.practice.lib.ext.printSelf

fun main() {

    val numbers = IntArray(20) { it + 1 }
    numbers.printElement("BinarySearchA")
    val result = BinarySearchA.findNumber(numbers, 19)
    "result:$result".printSelf()

}

// 非递归方式实现二分查找
// 二分查找用于 在有序数据中 查找某一个数，时间复杂度O(log N)
// 下面以正数 序列为例
object BinarySearchA {
    /**
     * 未支持负数
     */
    fun findNumber(arr: IntArray, value: Int): Int {
        var low = 0
        var high = arr.size - 1
        while (low <= high) { // <= ，处理到最后一次 ，为 3数 或 2数时 能取到 判断height
            val mid = low + (high - low) / 2
            val midValue = arr[mid]
            when {
                value == midValue -> {
                    return mid
                }
                value < midValue -> {
                    high = mid - 1
                }
                else -> {
                    low = mid + 1
                }
            }
        }
        return -1
    }

}