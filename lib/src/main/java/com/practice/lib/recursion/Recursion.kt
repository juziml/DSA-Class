package com.practice.lib.recursion
// 递归
// 从起点 先 往前去 递 达到终点
// 从终点 往后回  归，回到起点


//递归需要满足的三个条件
//1. 一个问题的解可以分解为几个子问题的解
//2.这个问题与分解之后的子问题，除了数据规模不同，求解思路完全一样
//3.存在递归终止条件

//递归优化
// 考虑 堆栈益处：控制栈最深层级，比如下面对f(n) 在19999时 溢出
// 重复计算：缓存
// 因为脏数据导致的 死循环
// 空间复杂度高
//
class Recursion {

    /* simple 1
    假如这里有 n 个台阶，每次你可以跨 1 个台阶或者 2 个台阶，
    请问走这 n 个台阶有多少种走法？如果有 7 个台阶，
    你可以 2，2，2，1 这样子上去，也可以 1，2，1，1，2 这样子上去，
    总之走法有很多，那如何用编程求得总共有多少种走法呢？

    下面的递归代码：每次都会确定走1步 还是2步，然后有两个终止点，1，2
    传递 n-1,第一步走1步
    传递 n-2 ,第一步走2步
    每一次递归 都是后续步骤的第一步
     */
    fun f(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2
        return f(n - 1) + f(n - 2)
    }

    /* simple 2
    推荐注册返佣金的这个功能我想你应该不陌生吧？现在很多 App 都有这个功能。
    这个功能中，用户 A 推荐用户 B 来注册，用户 B 又推荐了用户 C 来注册。
    我们可以说，用户 C 的“最终推荐人”为用户 A，
    用户 B 的“最终推荐人”也为用户 A，而用户 A 没有“最终推荐人”。
    表：
    actor_id:referrer_id
    B           A
    C           B
    D           null
     */
// 给定一个 用户ID，查找其最终推荐人
    fun findRealReferrer(id: Int): Int? {
        val reId = findRealReferrer(id)
        if (null == reId) return reId
        return findRealReferrer(reId)
    }
}