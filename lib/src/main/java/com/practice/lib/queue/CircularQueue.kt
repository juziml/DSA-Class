package com.practice.lib.queue

// 循环队列
// 可以避免数据搬移
// 当 tail++ 后等于 size，不赋值为size
// 判断 head 是否 等于0，不等于0，则将tail 标记为0，完成循环
// 注意：tail 经历了从大于 head 到小于 head 再到 追 上head 再超过 head的 循环
// 清理引用，判断实际元素个数，扩容，都与非循环队列不同
private class CircularQueue(private val initSize: Int) {


}