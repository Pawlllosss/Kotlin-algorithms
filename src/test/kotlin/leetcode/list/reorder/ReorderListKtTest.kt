package leetcode.list.reorder

import leetcode.list.ListNode
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class ReorderListKtTest {
    companion object {
        @JvmStatic
        fun listInputAndListOutput(): Stream<Arguments> = Stream.of(
            Arguments.of(
                constructList(listOf(ListNode(1), ListNode(2), ListNode(3), ListNode(4), ListNode(5))),
                constructList(listOf(ListNode(1), ListNode(5), ListNode(2), ListNode(4), ListNode(3)))
            ),
            Arguments.of(
                constructList(listOf(ListNode(1), ListNode(2), ListNode(3), ListNode(4))),
                constructList(listOf(ListNode(1), ListNode(4), ListNode(2), ListNode(3)))
            ),
            Arguments.of(
                constructList(listOf(ListNode(1), ListNode(2))),
                constructList(listOf(ListNode(1), ListNode(2)))
            ),
            Arguments.of(constructList(listOf(ListNode(1))), constructList(listOf(ListNode(1)))),
            Arguments.of(
                constructList(listOf(ListNode(1), ListNode(2), ListNode(3), ListNode(4), ListNode(5), ListNode(6))),
                constructList(listOf(ListNode(1), ListNode(6), ListNode(2), ListNode(5), ListNode(3), ListNode(4)))
            ),
        )

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

        private fun constructList(nodes: List<ListNode>): ListNode {
            val head = nodes.first()
            var currentNode = head

            for (i in 1 until nodes.size) {
                currentNode.next = nodes[i]
                currentNode = nodes[i]
            }


            return head
        }
    }

    @ParameterizedTest
    @MethodSource("listInputAndListOutput")
    fun shouldReorderList(input: ListNode, expectedResult: ListNode) {
        reorderList(input)
        Assertions.assertThat(compareLists(input, expectedResult)).isTrue
    }

    @Test
    fun shouldNotReorderListIfNull() {
        reorderList(null)
    }
}