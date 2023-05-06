package com.practice.lib.sort

import com.practice.lib.ext.print

fun main() {
    val arr = arrayOf(4, 5, 6, 3, 2, 1)
    MergeSort.mergeSort(arr, 0, arr.size - 1)
    arr.print()
}

// 归并排序算法
object MergeSort {

    // 利用递归 无限拆分 数组为 2段
    fun mergeSort(array: Array<Int>, p: Int, r: Int) {
        // 不可再分
        if (p >= r) return
        // 取 p..r 的中间值 q
        val q = (p + r) / 2
        mergeSort(array, p, q)
        mergeSort(array, q + 1, r)
        merge(array, p, q, r)
    }

    // 合并数组
    private fun merge(
        origin: Array<Int>, p: Int, q: Int, r: Int
    ) {
        val temp = arrayOfNulls<Int>(r - p + 1)
        var i = p
        var j = q + 1
        var k = 0
        // 申请一个临时数组 temp 0..r-p
        // 合并时比对，[135],[246]
        // 用i,j 标记，每次从左边i取值，与右边j取值进行比对，被选中后，坐标+1
        // 将剩余值一次性存入 temp
        // 将temp 写回 原始数组
        while (i <= q && j <= r) {
            if (origin[i] <= origin[j]) {
                temp[k++] = origin[i++]
            } else {
                temp[k++] = origin[j++]
            }
        }
        //一定有一个是到极限了，判断 i,j 是否到极限，将剩余数据写入temp
        val end: Int
        var start = if (i <= q) {
            end = q
            i
        } else {
            end = r
            j
        }
        while (start <= end) {
            temp[k++] = origin[start++]
        }
        //将temp中的数据拷贝回 原始数组
        for (i in 0..r - p) {
            // 放到 p .. r 的区间上
            origin[p + i] = temp[i]!!
        }
    }
}