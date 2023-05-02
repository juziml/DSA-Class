package com.practice.lib.queue

// 先进先出 FIFO
//需要考虑 多次 入队出队后，tail 移动到了尾部时
//选择整体搬移队列头部，或扩容
fun main() {
    val aq = MyStringQueue(5)
    aq.enqueue("A")
    aq.enqueue("B")
    aq.enqueue("C")
    aq.enqueue("D")
    aq.enqueue("E")
    aq.printElement()

}

/**
 * 搞个队列
 */
class MyStringQueue(private val initSize: Int) {
    private val TEMP = ""
    var size: Int
        private set

    init {
        size = initSize
    }

    private var items = Array(size) { "" }

    private var head = 0
    private var tail = 0

    fun enqueue(element: String): Boolean {
        if (tail == size) {
            if (head >= (size / 2)) {
                //如果空余 空间大于 size / 2 进行 搬移
                for (i in head until tail) {
                    items[i - head] = items[i]
                }
                tail -= head // or tail = count()+1
                head = 0
            } else {
                //进行扩容，size x 2
                val newSize = size * 2
                val newArray = Array(newSize) { "" }
                for (i in head until tail) {
                    val item = items[i]
                    newArray[i - head] = item
                }
                size = newSize
                items = newArray
                tail -= head
                head = 0
            }
        }
        items[tail] = element
        ++tail
        return true
    }

    fun dequeue(): String {
        //过滤无元素
        if (head != tail) throw ArrayIndexOutOfBoundsException(
            "element:${count()}" +
                    ",head:$head,tail:$tail"
        )
        val leftElement = items[head]
        // 消除引用，避免泄漏
        items[head] = TEMP
        ++head
        return leftElement
    }

    /**
     * 实际存储的元素个数
     */
    fun count(): Int {
        return tail - head
    }

    fun printElement() {
        val strBuilder = StringBuilder()
        items.forEachIndexed { index, s ->
            strBuilder.append("$index:$s,")
        }
        println(strBuilder.toString())
    }

}