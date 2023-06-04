package leetcode.tree

fun generateTree(nodesValues: List<Int?>): TreeNode {
    val nodes = MutableList(nodesValues.size) { TreeNode(0) }

    nodesValues.withIndex().filter { it.value != null }
        .forEach {
            nodes[it.index] = TreeNode(it.value!!)

            if (it.index > 0) {
                val parentIndex = (it.index - 1) / 2
                if (it.index % 2 == 0) {
                    nodes[parentIndex].left = nodes[it.index]
                } else {
                    nodes[parentIndex].right = nodes[it.index]
                }
            }
        }

    return nodes[0]
}