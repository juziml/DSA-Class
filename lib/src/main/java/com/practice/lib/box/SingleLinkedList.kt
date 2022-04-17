package com.practice.lib.box

class SingleLinkedList<T>(val data: T) {
    var next: SingleLinkedList<T>? = null

    fun putNext(data: T) {
        var arch = this
        while (arch.hasNext()) {
            arch = arch.next!!
        }
        arch.next = SingleLinkedList(data)
    }

    fun hasNext(): Boolean {
        return next != null
    }

    fun forEach(call: (t: T) -> Unit) {
        var point = this
        call.invoke(point.data)
        while (point.hasNext()) {
            point = point.next!!
            call.invoke(point.data)
        }
    }
}


