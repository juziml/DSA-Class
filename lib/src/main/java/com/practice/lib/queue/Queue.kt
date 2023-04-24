package com.practice.lib.queue

import com.practice.lib.print


fun main() {
    val aq = ArrayQueue()
    aq.enqueue("1")
    aq.enqueue("2")
    aq.enqueue("3")
    "size:${aq.size()}".print()
    val v = aq.dequeue()
    "v:$v  size:${aq.size()}".print()

}

/**
 * 搞个队列
 */
class ArrayQueue {

    companion object {
        private const val MAC_COUNT = 10
    }

    private val items = Array(MAC_COUNT) { "" }

    private var head = 0
    private var tail = 0


    fun enqueue(e: String): Boolean {
        if (tail == MAC_COUNT) return false
        items[tail] = e
        ++tail
        return true
    }

    fun dequeue(): String {
        if (tail != 0 && head != tail) {
            val e = items[head]
            ++head
            return e
        }
        throw IndexOutOfBoundsException("dequeue fail,queue is empty")
    }

    fun size(): Int {
        return tail - head
    }

}