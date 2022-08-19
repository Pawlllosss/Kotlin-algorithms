package substring.kms

fun main() {
    val substringMatcher = KmsSubstringMatcher()

    println(substringMatcher.findMatchingIndex("abxabcabcaby", "abcaby"))
}