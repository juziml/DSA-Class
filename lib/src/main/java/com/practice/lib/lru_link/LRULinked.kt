package com.practice.lib.lru_link


class LRULinked<E> {

    private companion object
    class Node<N>(val element: N, var next: Node<N>? = null)

    private var head: Node<E>? = null
    var length: Int = 0
        private set
    private val CACHE_MAX = 5

    fun putCache(e: E) {
        var prev: Node<E>? = null
        var cur = head
        while (cur != null) {
            // 已存在，将节点移动到头部
            if (cur.element == e) {
                if (prev != null) {
                    prev.next = cur.next
                    cur.next = head
                    head = cur
                }
                return
            }
            prev = cur
            cur = cur.next
        }
        // 不存在，插入到头节点
        if (length < CACHE_MAX) {
            val newNode = Node(e)
            newNode.next = head
            head = newNode
            ++length
        } else {
            val newNode = Node(e)
            newNode.next = head
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
        while (cur != null) {
            call(cur.element)
            cur = cur.next
        }
    }

}


