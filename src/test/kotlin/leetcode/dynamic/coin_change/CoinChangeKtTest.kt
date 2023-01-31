package leetcode.dynamic.coin_change

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class CoinChangeKtTest {
    companion object {
        @JvmStatic
        fun coinsWithAmountAndResult(): Stream<Arguments> = Stream.of(
            Arguments.of(intArrayOf(1, 2, 5), 11, 3),
            Arguments.of(intArrayOf(2), 3, -1),
            Arguments.of(intArrayOf(1), 0, 0),
        )
    }

    @ParameterizedTest
    @MethodSource("coinsWithAmountAndResult")
    fun shouldReturnFewestNumberOfCoinsToMakeAmount(coins: IntArray, amount: Int, result: Int) {
        Assertions.assertThat(coinChange(coins, amount)).isEqualTo(result)
    }

    @ParameterizedTest
    @MethodSource("coinsWithAmountAndResult")
    fun shouldReturnFewestNumberOfCoinsToMakeAmount_2(coins: IntArray, amount: Int, result: Int) {
        Assertions.assertThat(coinChange2(coins, amount)).isEqualTo(result)
    }
}