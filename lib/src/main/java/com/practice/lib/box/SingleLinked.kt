package com.practice.lib.box


class SingleNode<T> {
    private companion object
    class Node<A>(val element: A, var next: Node<A>? = null)


    private var last: Node<T>? = null
    private var next: Node<T>? = null

    var length: Int = 0
        private set

    fun add(e: T) {
        val newNode = Node(e)
        if (next == null) {
            next = newNode
        } else {
            last!!.next = newNode
        }
        last = newNode
        ++length
    }

    private fun hasNext(n: Node<T>): Boolean {
        return n.next != null
    }

    fun forEach(call: (t: T) -> Unit) {
        if (length == 0) return
        var cur = next
        call(cur!!.element)
        while (hasNext(cur!!)) {
            cur = cur.next
            call(cur!!.element)
        }
    }

    fun remove(obj: Any) {

    }

    fun remove(index: Int) {

    }


}


