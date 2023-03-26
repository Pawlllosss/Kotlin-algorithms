package leetcode.list.merge_k_sorted_lists

import heap.Heap
import leetcode.list.ListNode

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val priorityQueue = Heap<Int>()
//    val priorityQueue = PriorityQueue<Int>()

    if (lists.isEmpty()) {
        return null
    }

    lists.forEach {
        var pointer = it
        while (pointer != null) {
            priorityQueue.offer(pointer.`val`)
            pointer = pointer.next
        }
    }

    var sortedList: ListNode?
    val queueSmallestElement = priorityQueue.poll() ?: return null

    sortedList = ListNode(queueSmallestElement)
    var currentSortedListNode = sortedList

    while (!priorityQueue.isEmpty()) {
        val queueSmallestElement = priorityQueue.poll()!!
        currentSortedListNode?.next = ListNode(queueSmallestElement)
        currentSortedListNode = currentSortedListNode?.next
    }
    return sortedList
}