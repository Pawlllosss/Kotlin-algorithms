package leetcode.binary.counting_bits

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class CountingBitsKtTest {

    companion object {
        @JvmStatic
        fun numberOfBitsWithResult(): Stream<Arguments> = Stream.of(Arguments.of(5, arrayOf(0, 1, 1, 2, 1, 2)))
    }

    @ParameterizedTest
    @MethodSource("numberOfBitsWithResult")
    fun shouldReturnNumberOfBits(n: Int, expectedResult: Array<Int>) {
        assertThat(countBits(n)).contains(expectedResult)
    }

    @ParameterizedTest
    @MethodSource("numberOfBitsWithResult")
    fun shouldReturnNumberOfBitsWhenCountingWithShifting(n: Int, expectedResult: Array<Int>) {
        assertThat(countBitsWithBitShifting(n)).contains(expectedResult)
    }
}