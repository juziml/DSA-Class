package com.practice.lib.class07


class LRULinked<E> {

    private companion object
    class Node<N>(val element: N, var next: Node<N>? = null)

    private var head: Node<E>? = null
    var length: Int = 0
        private set
    private val CACHE_MAX = 5

    fun putCache(e: E) {
        var pre = head
        for (i in 0 until length) {
            if (pre == null) return
            if (i > 0) {
                if (pre.next?.element == e) {
                    if (i > 0) {
                        val cur = pre.next
                        pre.next = pre.next?.next
                        val oldHead = head
                        cur?.next = oldHead
                        head = cur
                    }
                    //存在链表中
                    return
                }
                pre = pre.next
            }
        }
        if (length < CACHE_MAX) {
            val oldHead = head
            val newNode = Node(e)
            newNode.next = oldHead
            head = newNode
            ++length
        } else {
            val oldHead = head
            val newNode = Node(e)
            newNode.next = oldHead
            head = newNode
            var cur = head
            for (i in 0 until length) {
                if (i == length - 1) {
                    cur?.next = null
                }
                cur = cur?.next
            }
        }

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

}


