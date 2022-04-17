package com.practice.lib.box

class SingleLinkedList<T>(val data: T) {
    var next: SingleLinkedList<T>? = null

    fun putNext(data: T) {
        var node = this
        while (node.hasNext()) {
            node = node.next!!
        }
        node.next = SingleLinkedList(data)
    }

    fun hasNext(): Boolean {
        return next != null
    }

    fun forEach(call: (t: T) -> Unit) {
        var node = this
        call.invoke(node.data)
        while (node.hasNext()) {
            node = node.next!!
            call.invoke(node.data)
        }
    }
}


