package leetcode.norepeating

fun lengthOfLongestSubstring(s: String): Int {
    val charactersInSubstring = mutableSetOf<Char>()
    var currentLongestSubstring = 0

    for ((index, character) in s.withIndex()) {
        if (!charactersInSubstring.contains(character)) {
            charactersInSubstring.add(character)
            if (charactersInSubstring.size > currentLongestSubstring) {
                currentLongestSubstring = charactersInSubstring.size
            }
        } else {
            val firstIndexOfSubstring = index - charactersInSubstring.size
            val substringToFindDuplicate = s.substring(firstIndexOfSubstring, index)
            for (substringCharacter in substringToFindDuplicate) {
                if (substringCharacter == character) {
                    break
                }
                charactersInSubstring.remove(substringCharacter)
            }
        }
    }

    return currentLongestSubstring
}