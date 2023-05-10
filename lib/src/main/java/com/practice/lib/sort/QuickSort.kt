package com.practice.lib.sort

import com.practice.lib.ext.print

/*
思考题：
现在你有 10 个接口访问日志文件夹，每个日志文件大小约 300MB，
每个文件里的日志都是按照时间戳从小到大排序的。
你希望将这 10 个较小的日志文件夹，合并为 1 个日志文件夹，
合并之后的日志仍然按照时间戳从小到大排列。
如果处理上述排序任务的机器内存只有 1GB，
你有什么好的解决思路，能“快速”地将这 10 个日志文件合并吗？

思路：
日志都是按照时间戳：要稳定排序
每个文件夹内，已经是从小到大排序的了
1GB，在空间上只能容忍 同时操作3个文件夹，那么就不可以在内存里做已排未排的管理
1.获得总数 n，设定起点 i=0，新建一个 tempMerge 文件夹
2.开10个 io thread，再为每个文件夹读取设置一个下标 xIndex
3.每个文件夹读一条一次读取10条,选出最小的，
写入tempMerge 文件夹，并将对应的xIndex++，i++
再读取一条，重新对10条进行比较，以此循环，直到 i = n-1
整个合并结束，给tempMerge 原地改名为 mergedLogs

 */
fun main() {
    val arr = arrayOf(8, 3, 9, 7, 1, 2, 6, 5, 4)
    QuickSort.sort(arr)
    arr.print()
}

// 快速排序，非稳定排序
// Time:O(nlogn) Place:O(1)
// 在完全有序的数据下 时间复杂度 退化为 O(n^2）
object QuickSort : ISort {

    override fun sort(arr: Array<Int>) {
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