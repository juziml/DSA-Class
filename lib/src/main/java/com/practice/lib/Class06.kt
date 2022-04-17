package com.practice.lib

import com.practice.lib.box.SingleLinkedList

fun main() {
    println("this is main function")
//    println(checkIsPalindrome(str1))
//    println(checkIsPalindrome(str2))
//    println(checkIsPalindrome(str3))
    testLinkedList()
}

//快慢指针，定位单链表中间节点
fun testLinkedList() {
    val linkedList = SingleLinkedList<String>("1")
    linkedList.putNext("2")
    linkedList.putNext("3")
    linkedList.putNext("4")
    linkedList.putNext("5")
    linkedList.putNext("6")
    linkedList.putNext("7")

    var slowPointer = linkedList
    var fastPointer: SingleLinkedList<String>? = slowPointer
    while (slowPointer.hasNext()) {
        print("s:${slowPointer.data}: ")
        slowPointer = slowPointer.next!!
        fastPointer = fastPointer?.next?.next
        print("f-${fastPointer?.data}: ")
        println()
        if (null == fastPointer) {
            break
        }

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
