package com.practice.lib.palindromestring

import com.practice.lib.single_link.SingleLinked

//链表形式的字符串回文判断

//双向链表简单些 则从头尾进行 查找，知道次数为 mid 停止

//下面是单向链表的实践
fun main() {
    val strLink = SingleLinked<String>()
    strLink.add("1")
    strLink.add("2")
    strLink.add("3")
    strLink.add("4")
    strLink.add("5")
    strLink.add("6")
    strLink.add("5")
    strLink.add("4")
    strLink.add("3")
    strLink.add("2")
    strLink.add("1")
    println("isPalindrome1:${isPalindromeLinked(strLink)}")
    val strLink2 = SingleLinked<String>()
    strLink2.add("1")
    strLink2.add("2")
    strLink2.add("3")
    strLink2.add("4")
    strLink2.add("5")
    strLink2.add("5")
    strLink2.add("4")
    strLink2.add("3")
    strLink2.add("2")
    strLink2.add("1")
    println("isPalindrome2:${isPalindromeLinked(strLink2)}")
}

fun isPalindromeLinked(strLink: SingleLinked<String>): Boolean {
    //empty
    //size =1
    //头尾
    //暴力：直接反转链表
//   val reverseLink = strLink.reverse()
//   reverseLink.equals() //遍历判断即可

// 双向链表更适合存储后判断回文，分别从头尾巴遍历至 中间节点
//快慢指针 找到中间节点
    var slow = strLink.head
    var fast = strLink.head
    while (fast != null) {
        slow = slow?.next
        fast = fast.next?.next //步长2
    }
    //考虑奇数 与偶数个元素
    if (strLink.length % 2 != 0) {
        slow = slow?.next
    }
    //反转右侧链表
    var pre: SingleLinked.Node<String>? = null
    var cur = slow
    while (cur != null) {
        val temp = cur.next
        cur.next = pre
        pre = cur
        cur = temp
    }
    //遍历两端链表比较值
    var left = strLink.head
    var right = pre
    var isPalindrome = true
    while (right != null) {
        if (left?.element != right.element) {
            isPalindrome = false
        }
        left = left?.next
        right = right.next
    }
    return isPalindrome
}