package leetcode.list.merge_k_sorted_lists

import leetcode.list.ListNode
import leetcode.list.util.ListTestingUtils
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class MergeKSortedListsKtTest {
    companion object {
        @JvmStatic
        fun listInputAndListOutput(): Stream<Arguments> = Stream.of(
//            Arguments.of(
//                arrayOf(
//                    ListTestingUtils.constructList(listOf(ListNode(1), ListNode(1), ListNode(1))),
//                    ListTestingUtils.constructList(listOf(ListNode(1), ListNode(1), ListNode(1))),
//                    ListTestingUtils.constructList(listOf(ListNode(1), ListNode(1), ListNode(1))),
//                ),
//                ListTestingUtils.constructList(
//                    listOf(
//                        ListNode(1),
//                        ListNode(1),
//                        ListNode(1),
//                        ListNode(1),
//                        ListNode(1),
//                        ListNode(1),
//                        ListNode(1),
//                        ListNode(1),
//                        ListNode(1)
//                    )
//                ),
//            ),
            Arguments.of(
                arrayOf(
                    ListTestingUtils.constructList(listOf(ListNode(1), ListNode(4), ListNode(5))),
                    ListTestingUtils.constructList(listOf(ListNode(1), ListNode(3), ListNode(4))),
                    ListTestingUtils.constructList(listOf(ListNode(2), ListNode(6))),
                ),
                ListTestingUtils.constructList(
                    listOf(
                        ListNode(1),
                        ListNode(1),
                        ListNode(2),
                        ListNode(3),
                        ListNode(4),
                        ListNode(4),
                        ListNode(5),
                        ListNode(6),
                    )
                ),
            ),
//            Arguments.of(
//                arrayOf(
//                    ListTestingUtils.constructList(listOf(ListNode(1), ListNode(2), ListNode(5))),
//                    ListTestingUtils.constructList(listOf(ListNode(1), ListNode(3), ListNode(5))),
//                    ListTestingUtils.constructList(listOf(ListNode(1), ListNode(4), ListNode(5))),
//                ),
//                ListTestingUtils.constructList(
//                    listOf(
//                        ListNode(1),
//                        ListNode(1),
//                        ListNode(1),
//                        ListNode(2),
//                        ListNode(3),
//                        ListNode(4),
//                        ListNode(5),
//                        ListNode(5),
//                        ListNode(5)
//                    )
//                ),
//            ),
//            Arguments.of(
//                arrayOf(
//                    ListTestingUtils.constructList(listOf(ListNode(1), ListNode(2), ListNode(4))),
//                    ListTestingUtils.constructList(listOf(ListNode(2), ListNode(3), ListNode(4))),
//                    ListTestingUtils.constructList(listOf(ListNode(3), ListNode(4), ListNode(5)))
//                ),
//                ListTestingUtils.constructList(
//                    listOf(
//                        ListNode(1),
//                        ListNode(2),
//                        ListNode(2),
//                        ListNode(3),
//                        ListNode(3),
//                        ListNode(4),
//                        ListNode(4),
//                        ListNode(4),
//                        ListNode(5)
//                    )
//                ),
//            ),
//            Arguments.of(
//                arrayOf(ListTestingUtils.constructList(listOf(ListNode(1), ListNode(2)))),
//                ListTestingUtils.constructList(listOf(ListNode(1), ListNode(2))),
//            ),
        )
    }

    @ParameterizedTest
    @MethodSource("listInputAndListOutput")
    fun shouldReorderList(lists: Array<ListNode?>, expectedResult: ListNode) {
        Assertions.assertThat(
            ListTestingUtils.compareLists(
                mergeKLists(lists)!!,
                expectedResult
            )
        ).isTrue
    }

    @Test
    fun returnsNullIfListsAreEmpty() {
        Assertions.assertThat(mergeKLists(arrayOf())).isNull()
    }
}