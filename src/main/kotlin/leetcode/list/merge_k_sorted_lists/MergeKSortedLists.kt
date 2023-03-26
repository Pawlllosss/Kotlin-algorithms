package leetcode.list.merge_k_sorted_lists

import heap.Heap
import leetcode.list.ListNode

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val priorityQueue = Heap<Int>()

    lists.forEach {
        var pointer = it
        while (pointer != null) {
            priorityQueue.offer(pointer.`val`)
            pointer = pointer.next
        }
    }
    return null
}