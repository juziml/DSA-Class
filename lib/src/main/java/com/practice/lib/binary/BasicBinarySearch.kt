package com.practice.lib.binary

import com.practice.lib.ext.printElement
import com.practice.lib.ext.printSelf
import kotlin.math.abs

fun main() {

    val numbers = IntArray(20) { it + 1 }
    numbers.printElement("BinarySearchA")
    val result = BasicBinarySearch.search(numbers, 19)
    val result2 = BasicBinarySearch.searchByRecursion(numbers, 19)
    "result:$result, result2:$result2".printSelf()
    val sq = BasicBinarySearch.sqrt(8.0)
    "sq:$sq".printSelf()

}

// 基础二分查找，主要是体现 二分查找的基础理论
// 二分查找用于 在有序数据中 查找某一个数，时间复杂度O(log N)
// 下面以正数 序列为例
object BasicBinarySearch {
    /**
     * 常规实现
     */
    fun search(arr: IntArray, value: Int): Int {
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

    /**
     * 递归实现
     */
    fun searchByRecursion(arr: IntArray, value: Int): Int {
        return recursionFind(arr, value, 0, arr.size - 1)
    }

    private fun recursionFind(arr: IntArray, value: Int, low: Int, high: Int): Int {
        if (low > high) return -1 // 不能是= ，= 时 是最后一次 递归，取到high 的值

        val mid = low + (high - low) / 2
        val mValue = arr[mid]
        return when {
            mValue == value -> {
                mid
            }
            mid < value -> {
                recursionFind(arr, value, mid + 1, high)
            }
            else -> {
                recursionFind(arr, value, low, mid - 1)
            }
        }
    }

    fun sqrt(value: Double): Double {
        if (value == 1.0) return 1.0
        return sqrtImp(value, 0.0, value)
    }

    private fun sqrtImp(value: Double, low: Double, high: Double): Double {
        // 采取递归求解
        // 退出条件：中位数 平方后 == value 或 小数到第 6位
        // 小数第6位就可以控制递归深度
        val mid = low + (high - low) / 2.0
        val square = mid * mid
        if (square == value) return mid
        if (abs(square - value) < 1 && countDecimalPlaces(mid) >= 6) {
            return mid
        }
        return if (square < value) {
            sqrtImp(value, mid, high)
        } else {
            sqrtImp(value, low, mid)
        }
    }

    private fun countDecimalPlaces(number: Double): Int {
        val stringRepresentation = number.toString()

        val decimalSeparatorIndex = stringRepresentation.indexOf('.')
        if (decimalSeparatorIndex < 0) {
            return 0
        }

        var decimalPlaces = 0
        for (i in decimalSeparatorIndex + 1 until stringRepresentation.length) {
            if (stringRepresentation[i] == '0') {
                continue // 跳过末尾的零
            }
            decimalPlaces = stringRepresentation.length - i
            break
        }

        if (decimalPlaces == 0) {
            return 0
        }

        if (stringRepresentation[0] == '-') {
            decimalPlaces-- // 如果数字是负数，则有效小数位数减一
        }

        return decimalPlaces
    }
}

