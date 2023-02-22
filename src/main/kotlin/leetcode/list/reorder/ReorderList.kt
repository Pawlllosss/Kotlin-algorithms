package leetcode.list.reorder

import leetcode.list.ListNode

fun reorderList(head: ListNode?) {
    if (head == null) {
        return
    }

    // need to find the middle of a list

    traverse(head, head)
}

fun traverse(beginning: ListNode, currentEnd: ListNode?): ListNode {
    if(currentEnd == null) {
        return beginning
    }

    val currentBeginning = traverse(beginning, currentEnd.next)

    if (currentBeginning == currentEnd || currentBeginning.next == currentEnd) {
        currentBeginning.next = null
        return currentBeginning
    }

    val next = currentBeginning.next

    currentBeginning.next = currentEnd
    currentEnd.next = next

    return next!!
}

//fun traverse(currentBeginning: ListNode, currentEnd: ListNode): ListNode {
//    if(currentEnd.next == null) {
//        return currentEnd
//    }
//
//    val lastNode = traverse(currentBeginning, currentEnd.next)
//
//    if (currentBeginning == currentEnd || currentBeginning.next == currentEnd) {
//        currentBeginning.next = null
//        return currentBeginning
//    }
//
//    val next = currentBeginning.next
//
//    currentBeginning.next = currentEnd
//    currentEnd.next = next
//
//    return next!!
//}