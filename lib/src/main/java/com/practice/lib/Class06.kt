package com.practice.lib

import com.practice.lib.box.LRULinked
import com.practice.lib.box.SingleLinked

fun main() {

//    println(checkIsPalindrome(str1))
//    println(checkIsPalindrome(str2))
//    println(checkIsPalindrome(str3))
//    testLinkedList()
    testLRU()
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

//快慢指针，定位单链表中间节点
fun testLinkedList() {
    val singleNode = SingleLinked<String>()
    singleNode.add("1")
    singleNode.add("2")
    singleNode.add("3")
    singleNode.add("4")
    singleNode.add("5")
    singleNode.add("6")

    singleNode.remove(0)
    singleNode.remove(4)
    singleNode.forEach {
        println("V=== $it")
    }
    singleNode.add("7")
    singleNode.forEach {
        println("F=== $it")
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
