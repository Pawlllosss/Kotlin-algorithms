package leetcode.list.reorder

import leetcode.list.ListNode
import leetcode.list.util.ListTestingUtils.compareLists
import leetcode.list.util.ListTestingUtils.constructList
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