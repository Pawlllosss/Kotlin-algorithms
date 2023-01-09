package leetcode.dynamic.word_break

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class WordBreakKtTest {
    companion object {
        @JvmStatic
        fun wordWithWordDictAndResult(): Stream<Arguments> = Stream.of(
            Arguments.of("leetcode", listOf("leet", "code"), true),
            Arguments.of("applepenapple", listOf("apple", "pen"), true),
            Arguments.of("catsandog", listOf("cats", "dog", "sand", "and", "cat"), false),
        )
    }

    @ParameterizedTest
    @MethodSource("wordWithWordDictAndResult")
    fun shouldReturnIfWordMatchesBreakWords(word: String, wordDict: List<String>, expectedResult: Boolean) {
        Assertions.assertThat(wordBreak(word, wordDict)).isEqualTo(expectedResult)
    }
}