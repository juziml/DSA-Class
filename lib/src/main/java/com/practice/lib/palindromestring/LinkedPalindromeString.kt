package com.practice.lib.palindromestring

import com.practice.lib.single_link.SingleLinked

//链表形式的字符串回文判断

//双向链表简单些 则从头尾进行 查找，知道次数为 mid 停止

//下面是单向链表的实践
fun main() {
    val strLink = SingleLinked<String>()
    strLink.add("A")
    strLink.add("A")
    strLink.add("A")
    strLink.add("V")
//    strLink.add("B")//中间只有一个不同
    strLink.add("V")
    strLink.add("A")
    strLink.add("A")
    strLink.add("A")
    //empty
    //size =1
    //头尾
    //暴力：直接反转链表
//   val reverseLink = strLink.reverse()
//   reverseLink.equals() //遍历判断即可
//快慢指针 找到中间节点
    var slow = strLink.getHead()
    var fast = slow
    while (fast != null) {
        slow = slow?.next
        fast = fast.next?.next //步长2
    }
    //遍历两段 查找
    var left = strLink.getHead()
    var right = slow
    var isPalindrome = true
    while (right != null) {
        val le = left?.element
        val re = right.element
        if (le != re) {
            isPalindrome = false
            break
        }
        right = right.next
        left = left?.next
    }
    println("isPalindrome:$isPalindrome")
}
