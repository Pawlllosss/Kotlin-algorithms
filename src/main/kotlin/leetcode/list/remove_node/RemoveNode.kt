package leetcode.list.remove_node

import leetcode.list.ListNode

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val lastIndex = removeNthFromEndRec(head, n)
    if (lastIndex == n) {
        return head?.next
    }

    return head
}


private fun removeNthFromEndRec(head: ListNode?, indexFromEndToDelete: Int): Int {
    if (head == null) {
        return 0
    }

    val currentIndexFromEnd = removeNthFromEndRec(head.next, indexFromEndToDelete) + 1

    if (indexFromEndToDelete == currentIndexFromEnd - 1) {
        head.next = head.next?.next
        return currentIndexFromEnd + 100
    }
    return currentIndexFromEnd
}
