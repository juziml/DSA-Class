package com.practice.lib.sort

fun main() {


}
// 线性排序

// 桶排序
// 把数据进行分桶，比如 200个 1～100的数据，分101 个桶，
// 遍历一边 对号入桶，再顺序取出 就有序了
// 适用于外部排序（不必一次性写入内存）

// 计数排序
// 好巧妙的设计
// 1.算桶（scope）
// 2.计数（前绪求和）
// 3.排序（遍历原始数组，从桶中取坐标，求和值-1）
object CountSort : ISort {

    override fun sort(array: Array<Int>) {
        if (array.isEmpty()) return
        countSort(array)
    }

    private fun countSort(array: Array<Int>) {


    }
}

