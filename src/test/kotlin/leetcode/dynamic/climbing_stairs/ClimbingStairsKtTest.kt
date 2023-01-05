package leetcode.dynamic.climbing_stairs

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class ClimbingStairsKtTest {

    companion object {
        @JvmStatic
        fun numberOfStairsWithResult(): Stream<Arguments> = Stream.of(
            Arguments.of(-5, 0),
            Arguments.of(0, 0),
            Arguments.of(1, 1),
            Arguments.of(2, 2),
            Arguments.of(3, 3),
            Arguments.of(4, 5),
            Arguments.of(5, 8),
        )
    }

    @ParameterizedTest
    @MethodSource("numberOfStairsWithResult")
    fun shouldReturnNumberOfSteps(stairs: Int, expectedResult: Int) {
        Assertions.assertThat(climbStairs(stairs)).isEqualTo(expectedResult)
    }

}