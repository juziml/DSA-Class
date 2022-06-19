package com.practice.lib

import com.practice.lib.box.SingleNode
import java.util.*

fun main() {

//    println(checkIsPalindrome(str1))
//    println(checkIsPalindrome(str2))
//    println(checkIsPalindrome(str3))
    testLinkedList()
}

//快慢指针，定位单链表中间节点
fun testLinkedList() {
    val l = LinkedList<String>()
    l.add("1")
    l.add("2")
    l.add("3")
    l.add("4")
    l.add("5")
    l.add("6")
    l.removeAt(1)
    val singleNode = SingleNode<String>()
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
//    var slowPointer = singleNode
//    var fastPointer: SingleNode<String>? = slowPointer
//    while (slowPointer.hasNext()) {
//        print("s:${slowPointer.element}: ")
//        slowPointer = slowPointer.next!!
//        fastPointer = fastPointer?.next?.next
//        print("f-${fastPointer?.element}: ")
//        println()
//        if (null == fastPointer) {
//            break
//        }
//
//    }


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
