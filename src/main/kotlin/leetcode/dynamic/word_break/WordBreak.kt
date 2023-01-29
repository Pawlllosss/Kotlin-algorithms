package leetcode.dynamic.word_break

import trie.structure.Trie

fun main() {
    println(wordBreak("leetcode", listOf("leet", "code")))
    println(wordBreakWithTrie("leetcode", listOf("leet", "code")))
}

fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val wordBreakMatch = BooleanArray(s.length)

    for (index in s.indices) {
        for (word in wordDict) {
            if ((isFirstString(index, word) || isPreviousSubstringMatching(
                    index,
                    word,
                    wordBreakMatch
                )) && containsWordDictInSubstring(s, index, word)
            ) {
                wordBreakMatch[index] = true
                break
            }
        }
    }

    return wordBreakMatch.last()
}

fun isFirstString(index: Int, word: String): Boolean = (index - word.length) < 0

fun isPreviousSubstringMatching(index: Int, word: String, wordBreakMatch: BooleanArray): Boolean =
    wordBreakMatch[index - word.length]

fun containsWordDictInSubstring(s: String, index: Int, word: String): Boolean {
    val startIndex = index - word.length + 1
    if (startIndex < 0) {
        return false
    }

    val substring = s.substring(startIndex, index + 1)
    return substring == word
}

// time limit exceeded for some of cases
fun wordBreakWithTrie(s: String, wordDict: List<String>): Boolean {
    val prefixTree = buildPrefixTree(wordDict)

    return prefixTree.matchesPrefixes(s)
}

fun buildPrefixTree(wordDict: List<String>): Trie {
    val trie = Trie(Trie.Node(' ', true, HashMap()))
    wordDict.forEach(trie::getOrAddChild)

    return trie
}
