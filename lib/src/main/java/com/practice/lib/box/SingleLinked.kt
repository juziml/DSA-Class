package com.practice.lib.box


class SingleLinked<E> {
    private companion object
    class Node<N>(val element: N, var next: Node<N>? = null)


    private var last: Node<E>? = null
    private var head: Node<E>? = null

    var length: Int = 0
        private set

    fun add(e: E) {
        val newNode = Node(e)
        add(newNode)
    }

    fun add(newNode: Node<E>) {
        if (head == null) {
            head = newNode
        } else {
            last?.next = newNode
        }
        last = newNode
        ++length
    }

    fun hasNext(n: Node<E>): Boolean {
        return n.next != null
    }

    fun forEach(call: (t: E) -> Unit) {
        var cur = head
        if (cur == null) {
            return
        } else {
            call(cur.element)
            while (hasNext(cur!!)) {
                cur = cur.next
                call(cur!!.element)
            }
        }

    }

    private inline fun forEachNode(call: (t: Node<E>) -> Unit) {
        var n = head
        while (n != null) {
            call(n)
            n = n.next
        }
    }

    fun remove(obj: E): Boolean {
        var result = false
        if (null == head) return result
        if (obj == head!!.element) {
            head = head?.next
            return true
        }
        var pre: Node<E> = head!!
        run run@{
            forEachNode {
                if (it.element == obj) {
                    pre.next = it.next
                    if (it.element == last?.element) {
                        last = pre
                    }
                    result = true
                    return@run
                }
                pre = it
            }
        }
        if (result) {
            --length
        }
        return result
    }

    fun removeAt(index: Int): Boolean {
        if (index < 0 || index >= length) return false
        var result = false
        var pre = head
        for (i in 0 until length) {
            if (i == index && pre != null) {
                result = true
                if (i == 0) {
                    head = pre.next
                    if (i == length - 1) {
                        last = head
                    }
                } else {
                    pre.next = pre.next?.next
                    if (i == length - 1) {
                        last = pre
                    }
                }
                break
            }
            if (i > 0) {
                pre = pre?.next
            }
        }
        if (result) {
            --length
        }
        return result
    }


    fun reverse() {
        var pre: Node<E>? = null
        var cur = head
        last = cur
        while (cur != null) {
            val nextTemp = cur.next
            cur.next = pre
            pre = cur
            cur = nextTemp
        }
        head = pre
    }

    //链表中环的检测
    //存值法，碰到连续存到两个相同值时 为有环，时间复杂度最差为O(N)，空间复杂度O(N)

    //快慢指针法，快指针==慢指针时为有环，时间复杂度O(N),空间复杂度O(1)
}


