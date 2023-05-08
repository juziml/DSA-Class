package com.practice.lib.sort

import com.practice.lib.ext.print

fun main() {
    val arr = arrayOf(8, 3, 9, 7, 1, 2, 6, 5, 4)
    QuickSort.sort(arr)
    arr.print()
}

// 快速排序
object QuickSort {

    fun sort(arr: Array<Int>) {
        quickSort(arr, 0, arr.size - 1)
    }
/*
选取任一下标数据作为参考点 值
将小于参考点 值的放左边，大于等于参考点值的放右边
递归调用，直到不可再拆
 */
    /**
     * @param origin:原始数组
     * @param p: 起点下标
     * @param r: 终点下标
     */
    private fun quickSort(origin: Array<Int>, p: Int, r: Int) {
        if (p >= r) return

        val pivotIndex = partition(origin, p, r)
        quickSort(origin, p, pivotIndex - 1)
        quickSort(origin, pivotIndex + 1, r)
    }

    private fun partition(origin: Array<Int>, p: Int, r: Int): Int {
        // 取 区间末尾值作为 pivot
        val pivot = origin[r]
        // 分别 用 leftIndex，rightIndex 分割 已处理和未处理区间
        // 每次从未处理区间（leftIndex+1..r-1）取值与 pivot比较
        // 小于则放入 leftIndex ,leftIndex ++ 完成右移
        // 使用数据交换完成原地数据搬移，不需要额外内存空间
        var leftIndex = p
        // 最后一位是 pivot，不取
        for (rightIndex in p until r) {
            val temp = origin[rightIndex]
            if (temp < pivot) {
                origin[rightIndex] = origin[leftIndex]
                origin[leftIndex] = temp
                leftIndex++
            }
        }
        //置换 leftIndex 与 pivot，让pivot 左边的全是小于它的值，右边全是大于它的
        origin[r] = origin[leftIndex]
        origin[leftIndex] = pivot
        return leftIndex
    }


}