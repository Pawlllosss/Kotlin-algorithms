package leetcode.list.reorder

import leetcode.list.ListNode

fun reorderList(head: ListNode?) {
    if (head == null) {
        return
    }

    val middleNode = findMiddleNode(head)
    val lastNodeOf2ndHalf = reverseList(middleNode)
    middleNode.next = null
    mergeWithAlternateOrder(head, lastNodeOf2ndHalf)
}

fun findMiddleNode(head: ListNode): ListNode {
    var slowPointer = head
    var fastPointer = head

    while (fastPointer.next != null && fastPointer.next?.next != null) {
        slowPointer = slowPointer.next!!
        fastPointer = fastPointer.next?.next!!
    }
    return slowPointer
}

fun reverseList(node: ListNode): ListNode {
    if (node.next == null) {
        return node
    }
    val lastNode = reverseList(node.next!!)
    node.next!!.next = node

    return lastNode
}

fun mergeWithAlternateOrder(list1: ListNode, list2: ListNode) {
    var pointer1: ListNode? = list1
    var pointer2: ListNode? = list2

    while (pointer1 != null && pointer2 != null) {
        val tmp1 = pointer1.next
        val tmp2 = pointer2.next

        pointer1.next = pointer2
        pointer2.next = tmp1

        pointer1 = tmp1
        pointer2 = tmp2
    }
}
