package com.practice.lib.binary

import com.practice.lib.ext.printSelf

/*
4种常见的二分查找变形问题:
•查找第一个值等于给定值的元素
。查找最后一个值等子给定值的元素
•查找第一个大于等于给定值的元素
•查找最后一个小于等于给定值的元素

练习题：

 */
fun main() {
    val array = intArrayOf(1, 2, 4, 5, 6, 6, 7, 8, 9)
    val f1 = BinaryPractice.firstEqual(array, 6)
    "f1:$f1".printSelf()
}

object BinaryPractice {
    /**
     * 查找第一个值等于给定值的元素
     */
    fun firstEqual(array: IntArray, x: Int): Int {
        // 定义 low，high
        // 定义终止条件：low >= high
        // mid = low +(high -low) /2
        // 判断 mid == 0，为首个，array[mid -1] != x 为首个，否则继续二分
        var low = 0
        var high = array.size - 1
        while (low <= high) {
            val mid = low + ((high - low) shr 1)
            if (array[mid] < x) {
                low = mid + 1
            } else if (array[mid] > x) {
                high = mid - 1
            } else {
                if (mid == 0 || array[mid - 1] != x) return mid
                else high = mid - 1
            }
        }
        return -1
    }


}