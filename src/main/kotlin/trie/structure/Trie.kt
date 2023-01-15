package trie.structure

class Trie(private val root: Node) {

    fun getOrAddChild(value: String) {
        var currentNode = root
        for ((index, char) in value.withIndex()) {
            currentNode = currentNode.children.computeIfAbsent(char) { valToAdd ->
                Node(
                    valToAdd,
                    isLastCharacter(index, value), HashMap()
                )
            }

            // TODO: should recreate current node when it turns out it's the end not (for example). Inserts car first and the cak
        }
    }

    fun matchesPrefixes(value: String): Boolean {
        return matchesPrefixes(0, value)
    }

    private fun matchesPrefixes(beginning: Int, value: String): Boolean {
        if (beginning == value.length) {
            return true
        }
        var currentNode = root
        for (index in beginning until value.length) {
            val char = value[index]
            if (!currentNode.children.containsKey(char)) {
                return false
            }
            currentNode = currentNode.children[char]!!

            if (currentNode.isEnd && matchesPrefixes(index + 1, value)) {
                return true
            }
        }
        return false
    }

    private fun isLastCharacter(index: Int, value: String) = index == value.length - 1

    data class Node(val label: Char, val isEnd: Boolean, val children: MutableMap<Char, Node>)
}