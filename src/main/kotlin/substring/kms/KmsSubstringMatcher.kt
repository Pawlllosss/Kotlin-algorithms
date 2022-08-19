package substring.kms

import substring.kms.KmsSubstringMatcher.PrefixSuffixIndexesCreator.createPrefixSuffixIndexes
import java.lang.IllegalArgumentException

class KmsSubstringMatcher {

    fun findMatchingIndex(stringToMatch: String, substring: String): Int {
        if (substring.length > stringToMatch.length) {
            throw IllegalArgumentException("Substring is longer than stringToMatch")
        } else if (substring.isBlank()) {
            throw IllegalArgumentException("Substring should contain at least one character")
        }

        val substringPrefixSuffixIndexes: List<Int> = createPrefixSuffixIndexes(substring)

        var substringIndex = 0

        for ((toMatchIndex, toMatchCharacter) in stringToMatch.withIndex()) {
            if (toMatchCharacter == substring[substringIndex]) {
                substringIndex++

                if (substringIndex == substring.length) {
                    return toMatchIndex - substring.length + 1
                }
            } else {
                substringIndex = substringPrefixSuffixIndexes[if (substringIndex > 0) substringIndex - 1 else 0]

                while (substringIndex > 0) {
                    if (toMatchCharacter == substring[substringIndex]) {
                        substringIndex++
                        break
                    }
                    substringIndex = substringPrefixSuffixIndexes[if (substringIndex > 0) substringIndex - 1 else 0]

                    if (toMatchCharacter == substring[substringIndex]) {
                        substringIndex++
                    }
                }
            }
        }

        return -1
    }

    internal object PrefixSuffixIndexesCreator {

        internal fun createPrefixSuffixIndexes(substring: String): List<Int> {
            val prefixSuffixIndexes = ArrayList<Int>(substring.length)
            for (i in substring.indices) {
                prefixSuffixIndexes.add(0)
            }

            prefixSuffixIndexes[0] = 0

            var i = 0 // pattern beginning
            var j = 1 // pattern end

            while (j < substring.length) {
                if (substring[i] == substring[j]) {
                    prefixSuffixIndexes[j] = i + 1
                    i++
                } else {
                    prefixSuffixIndexes[j] = 0

                    i = prefixSuffixIndexes[if (i > 0) i - 1 else 0]
                    while (i > 0) {
                        if (substring[i] == substring[j]) {
                            prefixSuffixIndexes[j] = i + 1
                            break
                        }

                        i = prefixSuffixIndexes[if (i > 0) i - 1 else 0]
                    }

                    if (substring[i] == substring[j]) {
                        prefixSuffixIndexes[j] = i + 1
                    }
                }

                j++
            }

            return prefixSuffixIndexes
        }
    }
}