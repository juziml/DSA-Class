package com.practice.lib.sort

import com.practice.lib.ext.printElement
/* 练习题
1.假设我们现在需要对 D，a，F，B，c，A，z 这个字符串进行排序，
要求将其中所有小写字母都排在大写字母的前面，
但小写字母内部和大写字母内部不要求有序。
2.如果字符串中存储的不仅有大小写字母，还有数字。要将小写字母的放到前面，
大写字母放在最后，数字放在中间，不用排序算法，又该怎么解决呢？

解答：
1.直接分两个桶 ，往里丢，在先取小的就行了
2.用排序算法：直接分三个桶
不用排序算法？可能分桶不算排序算法！


 */
fun main() {
    val a8 = arrayOf(2, 5, 3, 0, 2, 3, 0, 3)
    CountSort.sort(a8)
}
// 线性排序：

// 桶排序
// 把数据进行分桶，比如 200个 1～100的数据，分101 个桶，
// 遍历一边 对号入桶，再顺序取出 就有序了
// 适用于外部排序（不必一次性写入内存）
// 用户数据范围小（结合数据规模与数据值区间）
// 计数排序
// 好巧妙的设计
// 1.算桶（scope）
// 2.计数（前序求和）
// 3.排序（遍历原始数组，从桶中取坐标，求和值-1）
// 用户数据范围小（结合数据规模与数据值区间）
/*
 * 计数排序只能用在数据范围不大的场景中，如果数据范围 k 比要排序的数据 n 大很多，
 * 就不适合用计数排序了。而且，计数排序只能给非负整数排序，
 * 如果要排序的数据是其他类型的，要将其在不改变相对大小的情况下，转化为非负整数。
 */

// 基数排序
// 从最高位到最低位 独立排序，底层依赖稳定排序算法
// 比如对10万个手机号排序，排序11次就行。复杂度 11*O(n)
// 每位的排序算法用 计数排序，桶排序都行，因为她们的值范围固定

object CountSort : ISort {

    override fun sort(array: Array<Int>) {
        if (array.isEmpty()) return
        countSort(array)
    }

    private fun countSort(array: Array<Int>) {
        val aSize = array.size
        var max = 0
        array.forEach {
            if (it > max) max = it
        }
        val cA = Array(max + 1) { 0 }
        array.forEach {
            val x = cA[it]
            cA[it] = x + 1
        }
        cA.printElement("cA 算桶（scope）")
        var value = cA[0]
        //消 null
        cA[0] = value
        for (index in 1 until cA.size) {
            value += cA[index]
            cA[index] = value
        }
        cA.printElement("cA:计数（前序求和）")

        val rA = Array(aSize) { 0 }
        for (i in aSize - 1 downTo 0) {
            val aElement = array[i]
            val rIndex = cA[aElement]
            rA[rIndex - 1] = aElement
            cA[aElement] = rIndex - 1
        }
        rA.printElement("rA 排序（遍历原始数组，从桶中取坐标，求和值-1）")
//        cA 算桶（scope） >:
//        element:2:0:2:3:0:1:
//        index  :0:1:2:3:4:5:
//        cA:计数（前序求和） >:
//        element:2:2:4:7:7:8:
//        index  :0:1:2:3:4:5:
//        rA 排序（遍历原始数组，从桶中取坐标，求和值-1） >:
//        element:0:0:2:2:3:3:3:5:
//        index  :0:1:2:3:4:5:6:7:
    }
}

