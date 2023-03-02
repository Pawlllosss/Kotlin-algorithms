package leetcode.list.util

import leetcode.list.ListNode

object ListTestingUtils {
    fun compareLists(list1: ListNode, list2: ListNode): Boolean {
        var currentList1 = list1
        var currentList2 = list2

        while (currentList1.`val` == currentList2.`val`) {
            if (currentList1.next == null && currentList2.next == null) {
                return true
            } else if (currentList1.next == null || currentList2.next == null) {
                return false
            }

            currentList1 = currentList1.next!!
            currentList2 = currentList2.next!!
        }

        return false
    }

    fun constructList(nodes: List<ListNode>): ListNode {
        val head = nodes.first()
        var currentNode = head

        for (i in 1 until nodes.size) {
            currentNode.next = nodes[i]
            currentNode = nodes[i]
        }


        return head
    }
}
