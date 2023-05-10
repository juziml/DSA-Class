package com.practice.lib.sort

import com.practice.lib.ext.print

fun main() {
    val arr = arrayOf(1, 5, 6, 3, 2, 4)
    MergeSort.sort(arr)
    arr.print()
}

// 归并排序算法，稳定排序
// Time: O(nlogn) Place:O(n)
object MergeSort : ISort {
    override fun sort(array: Array<Int>) {
        if (array.isEmpty()) return
        mergeSort(array, 0, array.size - 1)
    }

    // 利用递归 无限拆分数组为 2段
    private fun mergeSort(array: Array<Int>, indexP: Int, indexR: Int) {
        // 不可再分
        if (indexP >= indexR) return
        // 取 p..r 的中间值 q
        val q = (indexP + indexR) / 2
        mergeSort(array, indexP, q)
        mergeSort(array, q + 1, indexR)
        merge(array, indexP, q, indexR)
    }

    /**
     * 合并数组
     * @param indexP:在原始数组上的起点坐标
     * @param indexQ:在原始数组上的中间分割点坐标
     * @param indexR:在原始数组上的终点坐标
     */
    private fun merge(
        origin: Array<Int>, indexP: Int, indexQ: Int, indexR: Int
    ) {
        val size = indexR - indexP + 1
        val temp = arrayOfNulls<Int>(size)
        var i = indexP
        var j = indexQ + 1
        var k = 0
        // 申请一个临时数组 temp 0..r-p
        // 合并时比对，[135],[246]
        // 用i,j 标记，每次从左边i取值，与右边j取值进行比对，被选中后，坐标+1
        // 将剩余值一次性存入 temp
        // 将temp 写回 原始数组
        while (i <= indexQ && j <= indexR) {
            if (origin[i] <= origin[j]) {
                temp[k++] = origin[i++]
            } else {
                temp[k++] = origin[j++]
            }
        }
        //一定有一个是到极限了，判断 i,j 是否到极限，将剩余数据写入temp
        val end: Int
        var start = if (i <= indexQ) {
            end = indexQ
            i
        } else {
            end = indexR
            j
        }
        while (start <= end) {
            temp[k++] = origin[start++]
        }
        //将temp中的数据拷贝回 原始数组
        for (i in 0 until size) {
            // 放到 p .. r 的区间上
            origin[indexP + i] = temp[i]!!
        }
    }
}