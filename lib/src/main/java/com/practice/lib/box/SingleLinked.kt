package com.practice.lib.box


class SingleNode<T>(val element: T) {
   private var next: SingleNode<T>? = null
    private var last: SingleNode<T>? = null
    var length: Int = 0

    fun add(e: T) {
        val newNode = SingleNode(e)
        if(next == null){
            next = newNode
        }else{
            last!!.next = newNode
        }
        last = newNode
        ++length
    }

    fun hasNext(): Boolean {
        return next != null
    }

    fun remove(obj: Any) {
        var node = this

        while (node.hasNext()) {
            node = node.next!!
        }

    }

    fun remove(index: Int) {

    }


    fun forEach(call: (t: T) -> Unit) {
        var node = this
        call.invoke(node.element)
        while (node.hasNext()) {
            node = node.next!!
            call.invoke(node.element)
        }
    }
}


