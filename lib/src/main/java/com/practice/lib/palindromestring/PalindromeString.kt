package com.practice.lib.palindromestring

fun main() {
    val str = "AAAACCCC"//8
    val str2 = "AAABAAA"//3
    println(isPalindrome(str))
    println(isPalindrome(str2))
    println("p2---")
    println(isPalindrome2(str))
    println(isPalindrome2(str2))

}

//分析，找到中间节点，分割，从0 与中间节点分别取出比较，全部相同为回文
//考虑极限条件
fun isPalindrome(str: String): Boolean {
    if (str.isEmpty()) throw IllegalArgumentException("str can not empty")
    if (str.length == 1) return true
    for (i in 0 until str.length / 2) {
        if (str[0] != str[str.length - i - 1]) return false
    }
    return true
}

fun isPalindrome2(str: String): Boolean {
    if (str.isEmpty()) throw IllegalArgumentException("str can not empty")
    if (str.length == 1) return true
    return str == str.reversed()
}
//递归，不写了
