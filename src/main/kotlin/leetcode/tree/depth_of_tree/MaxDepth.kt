package leetcode.tree.depth_of_tree

import leetcode.tree.TreeNode
import kotlin.math.max

fun maxDepth(root: TreeNode?): Int {
    return traverseTree(root, 0)
}

private fun traverseTree(node: TreeNode?, currentDepth: Int): Int {
    if (node == null) {
        return currentDepth
    }

    val leftDepth = traverseTree(node.left, currentDepth + 1)
    var rightDepth = traverseTree(node.right, currentDepth + 1)

    return max(leftDepth, rightDepth)
}
