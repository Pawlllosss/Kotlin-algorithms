package trie.structure

class Trie(private val root: Node) {

    fun getOrAddChild(value: String) {
        var currentNode = root

        for (char in value) {
            currentNode = currentNode.children.computeIfAbsent(char) { valToAdd ->
                Node(
                    valToAdd,
                    false, HashMap()
                )
            }
        }

        currentNode.setIsEnd(true)
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

    class Node(val label: Char, var isEnd: Boolean, val children: MutableMap<Char, Node>) {

        fun setIsEnd(isEnd: Boolean) {
            this.isEnd = isEnd
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Node

            if (label != other.label) return false
            if (isEnd != other.isEnd) return false
            if (children != other.children) return false

            return true
        }

        override fun hashCode(): Int {
            var result = label.hashCode()
            result = 31 * result + isEnd.hashCode()
            result = 31 * result + children.hashCode()
            return result
        }

        override fun toString(): String {
            return "Node(label=$label, isEnd=$isEnd, children=$children)"
        }
    }
}