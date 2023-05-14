package com.practice.lib.sort

fun main() {

    val nums = intArrayOf(1, 2, 3, 4, 5, 2, 1)
    InsertSort.insertionSort(nums)
    nums.forEachIndexed { index, i ->
        print("$i:")
    }

}

/*
将数组中的数据分为两个区间，已排序区间和未排序区间
理解这一点非常重要。
插入排序的第一次排序解析：
0～0 位 为已排序区间，1～size -1 为未排序区间
从 1～size -1 中 遍历取出 [x],与 0～0 进行比较，如果满足><,则进行换位
完成第一次插入排序

 */
object InsertSort {
    fun insertionSort(a: IntArray) {
        val n = a.size
        if (a.isEmpty() || n <= 1) return
        for (i in 1 until n) {
            val value = a[i]
            var j = i - 1
            while (j >= 0) {
                if (a[j] > value) {
                    a[j + 1] = a[j]
                } else {
                    break
                }
                --j
            }
            a[j + 1] = value
        }
    }

    fun sortAsc(array: Array<Int>) {
        val size = array.size
        if (size == 0) return
        //从未排序中取值
        for (right in 1 until size) {
            //将用于插入的值
            val rv = array[right]
            // = right 兼容 完全不需要动
            var pick = right
            //从已排序中 取值，从左往右取
            for (left in pick - 1 downTo 0) {
                val lv = array[left]
                if (lv > rv) {
                    //往后挪以为，空出原来的位置
                    array[left + 1] = lv
                    pick = left
                } else {
                    break
                }
            }
            // 将未排序的值入坑
            array[pick] = rv
        }

    }


}
