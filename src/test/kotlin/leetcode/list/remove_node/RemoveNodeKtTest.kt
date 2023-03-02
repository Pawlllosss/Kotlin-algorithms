package leetcode.list.remove_node

import leetcode.list.ListNode
import leetcode.list.util.ListTestingUtils
import leetcode.list.util.ListTestingUtils.constructList
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class RemoveNodeKtTest {
    companion object {
        @JvmStatic
        fun listInputWithNodeIndexAndListOutput(): Stream<Arguments> = Stream.of(
            Arguments.of(
                constructList(listOf(ListNode(1), ListNode(2), ListNode(3), ListNode(4), ListNode(5))), 2,
                constructList(listOf(ListNode(1), ListNode(2), ListNode(3), ListNode(5)))
            ),
            Arguments.of(
                constructList(listOf(ListNode(1), ListNode(2))), 1,
                constructList(listOf(ListNode(1)))
            ),
            Arguments.of(
                constructList(listOf(ListNode(1), ListNode(2))), 2,
                constructList(listOf(ListNode(2)))
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("listInputWithNodeIndexAndListOutput")
    fun listInputWithNodeIndexAndListOutput(input: ListNode, nodeIndex: Int, expectedResult: ListNode) {
        Assertions.assertThat(
            ListTestingUtils.compareLists(
                removeNthFromEnd(input, nodeIndex)!!,
                expectedResult
            )
        ).isTrue
    }

    @Test
    fun removeNthNodeShouldReturnNullIfListContainsOneElement() {
        Assertions.assertThat(removeNthFromEnd(ListNode(1), 1)).isNull()
    }
}
