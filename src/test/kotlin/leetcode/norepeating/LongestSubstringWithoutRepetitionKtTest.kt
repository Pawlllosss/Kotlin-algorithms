package leetcode.norepeating

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class LongestSubstringWithoutRepetitionKtTest {

    companion object {
        @JvmStatic
        fun stringWithResult(): Stream<Arguments> = Stream.of(
            Arguments.of("", 0),
            Arguments.of("abcabcbb", 3),
            Arguments.of("bbbbbb", 1),
            Arguments.of("pwwkew", 3),
            Arguments.of("a3a32a3", 3),
            Arguments.of("aab", 2),
        )
    }

    @ParameterizedTest
    @MethodSource("stringWithResult")
    fun shouldReturnLengthOfLongestSubstringWithoutRepeatingCharacters(string: String, expectedResult: Int) {
        Assertions.assertThat(lengthOfLongestSubstring(string)).isEqualTo(expectedResult)
    }
}
