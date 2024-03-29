package com.practice.lib

import com.practice.lib.lru_link.LRULinked
import com.practice.lib.single_link.SingleLinked

fun main() {

//    println(checkIsPalindrome(str1))
//    println(checkIsPalindrome(str2))
//    println(checkIsPalindrome(str3))
    testLinkedList()
//    testLRU()
}

fun testLRU() {
    val singleNode = LRULinked<String>()
    singleNode.putCache("1")
    singleNode.putCache("2")
    singleNode.putCache("3")
    singleNode.putCache("4")
    singleNode.putCache("5")

    singleNode.putCache("6")

    singleNode.forEach {
        println("V=== $it")
    }

}

fun testLinkedList() {
    val singleNode = SingleLinked<Int>()
    singleNode.add(1)
    singleNode.add(2)
    singleNode.add(3)
    singleNode.add(4)
    singleNode.add(5)
    singleNode.add(6)

//    singleNode.remove(1)
//    singleNode.remove(3)
//    singleNode.remove(6)
//
//    singleNode.forEach {
//        println("V=== $it")
//    }
    singleNode.forEach {
        print("$it ")
    }
    println()
    singleNode.reverse()
    singleNode.forEach {
        println("$it ")
    }
    singleNode.add(7)
    singleNode.forEach {
        println("$it ")
    }
}


//回文字符串判断解法
//1.中心填充+中心拓展法
val str1 = "1234321"
val str2 = "123321"
val str3 = "1234567654321"

fun checkIsPalindrome(str: String): Boolean {
    val length = str.length
    if (length == 0) return false
    if (length == 1) return true
    val lastMirrorIndex = if (length % 2 == 0) {
        (length / 2) - 1
    } else {
        ((length + 1) / 2) - 2
    }
    println("$str: l:$length mid point $lastMirrorIndex")

    for (i in 0..length) {
        if (i > lastMirrorIndex) return true
        if (str[i] != str[length - 1 - i]) return false
    }
    return true
}
