package leetcode.list.merge_two_sorted_lists

import leetcode.list.ListNode
import leetcode.list.util.ListTestingUtils.compareLists
import leetcode.list.util.ListTestingUtils.constructList
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class MergeTwoSortedListsKtTest {
    companion object {
        @JvmStatic
        fun listInputAndListOutput(): Stream<Arguments> = Stream.of(
            Arguments.of(
                constructList(listOf(ListNode(1), ListNode(1), ListNode(1))),
                constructList(listOf(ListNode(1), ListNode(1), ListNode(1))),
                constructList(listOf(ListNode(1), ListNode(1), ListNode(1), ListNode(1), ListNode(1), ListNode(1))),

                ),
            Arguments.of(
                constructList(listOf(ListNode(1), ListNode(2), ListNode(4))),
                constructList(listOf(ListNode(1), ListNode(3), ListNode(4))),
                constructList(listOf(ListNode(1), ListNode(1), ListNode(2), ListNode(3), ListNode(4), ListNode(4))),
            ),
            Arguments.of(
                constructList(listOf(ListNode(1), ListNode(2), ListNode(4))),
                constructList(listOf(ListNode(2), ListNode(3), ListNode(4))),
                constructList(listOf(ListNode(1), ListNode(2), ListNode(2), ListNode(3), ListNode(4), ListNode(4))),
            ),
            Arguments.of(
                constructList(listOf(ListNode(1), ListNode(2))),
                null,
                constructList(listOf(ListNode(1), ListNode(2))),
            ),
            Arguments.of(
                null,
                constructList(listOf(ListNode(1), ListNode(2))),
                constructList(listOf(ListNode(1), ListNode(2))),
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("listInputAndListOutput")
    fun shouldReorderList(list1: ListNode?, list2: ListNode?, expectedResult: ListNode) {
        Assertions.assertThat(
            compareLists(
                mergeTwoLists(list1, list2)!!,
                expectedResult
            )
        ).isTrue
    }

    @Test
    fun returnsNullIfListsAreEmpty() {
        Assertions.assertThat(mergeTwoLists(null, null)).isNull()
    }
}