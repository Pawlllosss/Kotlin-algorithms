package leetcode.list.merge_two_sorted_lists

import leetcode.list.ListNode

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val head: ListNode?
    var list1ptr = list1
    var list2ptr = list2

    when {
        list1 == null -> {
            head = list2
            list2ptr = list2ptr?.next
        }
        list2 == null -> {
            head = list1
            list1ptr = list1ptr?.next
        }
        list1.`val` < list2.`val` -> {
            head = list1
            list1ptr = list1ptr?.next
        }
        else -> {
            head = list2
            list2ptr = list2ptr?.next

        }
    }

    var currentNode = head

    while (list1ptr != null && list2ptr != null) {
        if (list1ptr.`val` < list2ptr.`val`) {
            currentNode?.next = list1ptr
            list1ptr = list1ptr.next
        } else {
            currentNode?.next = list2ptr
            list2ptr = list2ptr.next
        }

        currentNode = currentNode?.next
    }

    while (list1ptr != null) {
        currentNode?.next = list1ptr
        currentNode = currentNode?.next
        list1ptr = list1ptr.next
    }

    while (list2ptr != null) {
        currentNode?.next = list2ptr
        currentNode = currentNode?.next
        list2ptr = list2ptr.next
    }

    return head
}