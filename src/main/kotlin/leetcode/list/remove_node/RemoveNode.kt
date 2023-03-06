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

fun removeNthFromEndTwoPointers(head: ListNode?, n: Int): ListNode? {
    var slowPointer = head
    var fastPointer = head

    if (isRemovingLastNode(n)) {
        if (isOneElement(head)) {
            return null
        }
        return removeLastNode(slowPointer, head)
    }

    for (i in 1..n) {
        fastPointer = fastPointer?.next
    }

    if (fastPointer == null) {
        return head?.next
    }

    while (fastPointer?.next != null) {
        fastPointer = fastPointer.next
        slowPointer = slowPointer!!.next
    }

    slowPointer?.next = slowPointer?.next?.next

    return head
}

private fun isRemovingLastNode(n: Int) = n == 1

fun isOneElement(head: ListNode?): Boolean = head?.next == null

private fun removeLastNode(
    slowPointer: ListNode?,
    head: ListNode?
): ListNode? {
    var slowPointer1 = slowPointer
    while (slowPointer1?.next?.next != null) {
        slowPointer1 = slowPointer1.next
    }
    slowPointer1?.next = null

    return head
}
