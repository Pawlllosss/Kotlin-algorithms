package heap.top_k_frequent

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class TopKFrequentElementsKtTest {

    companion object {
        @JvmStatic
        fun inputArrayWithTopCountAndResult(): Stream<Arguments> = Stream.of(
            Arguments.of(intArrayOf(1, 1, 1, 2, 2, 3), 2, intArrayOf(1, 2)),
            Arguments.of(intArrayOf(1), 1, intArrayOf(1)),
            Arguments.of(intArrayOf(-1, -1), 1, intArrayOf(-1)),
        )
    }

    @ParameterizedTest
    @MethodSource("inputArrayWithTopCountAndResult")
    fun shouldReturnTopFrequentElements(nums: IntArray, k: Int, result: IntArray) {
        Assertions.assertThat(topKFrequent(nums, k)).isEqualTo(result)
    }
}