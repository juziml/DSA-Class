package com.practice.lib.box


class SingleNode<E> {
    private companion object
    class Node<N>(val element: N, var next: Node<N>? = null)


    private var last: Node<E>? = null
    private var head: Node<E>? = null

    var length: Int = 0
        private set

    fun add(e: E) {
        val newNode = Node(e)
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
        var cur = head
        if (cur == null) {
            return
        } else {
            call(cur)
            while (hasNext(cur!!)) {
                cur = cur.next
                call(cur!!)
            }
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
                result = it.element == obj
                if (result) {
                    pre.next = it.next
                    return@run
                }
                pre = it
            }
        }
        return result
    }

    fun remove(index: Int) {

    }


}


