package com.practice.lib.sort

fun main() {
    val arr = arrayOf(4, 5, 6, 3, 2, 1)
    SelectionSort.sort(arr)
    arr.forEachIndexed { index, i ->
        print("$index:$i,")
    }
}

/*
选择排序算法:分已排序区间,未排序区间。
每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
由于会做大小交互，导致原有数据被挪动，所以选择排序是不安全的排序算法
 */
object SelectionSort {

    fun sort(array: Array<Int>) {
        val size = array.size
        for (o in 0 until size) {
            var pick = array[o]
            for (i in o until size) {
                if (pick > array[i]) {
                    val temp = array[i]
                    array[i] = pick
                    pick = temp
                }
            }
            array[o] = pick
        }

    }

}