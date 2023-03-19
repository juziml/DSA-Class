package com.practice.lib

//插入排序
private val numbers = arrayOf(4, 5, 6, 1, 3, 2)


fun main() {
    insertAsc(numbers)
}

private fun insertAsc(numbers: Array<Int>) {

    for (i in 1..numbers.size - 1) {
        var iValue = numbers[i]
        var j: Int = i - 1
        for (o in i - 1 downTo 0) {
            if (numbers[o] > iValue) {
                numbers[o + 1] = numbers[o]
            } else {
                break
            }
            j--
        }
        numbers[j + 1] = iValue
    }
    numbers.forEach {
        print("$it,")
    }

}