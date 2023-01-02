package leetcode.binary_sum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


internal class SumOfTwoIntegersKtTest {

    @ParameterizedTest
    @CsvSource("2,3,5", "-2,-3,-5", "-3,2,-1", "7,3,10")
    fun shouldReturnSumOfNumbers(a: Int, b: Int, result: Int) {
        assertEquals(getBinarySum(a,b), result)
    }
}