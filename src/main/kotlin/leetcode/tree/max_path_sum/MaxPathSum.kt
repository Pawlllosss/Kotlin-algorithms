package leetcode.tree.max_path_sum

import leetcode.tree.TreeNode
import kotlin.math.max

fun maxPathSum(root: TreeNode?): Int {
    if (root == null) {
        throw IllegalArgumentException("Root of the tree is supposed to be present")
    }
    return maxPathSum(root, root.`val`)
//    if (root == null) {
//        return Int.MIN_VALUE
//    }
//    val currentMax = root.`val`

    // possible steps:
    // 1. abandon the current node (and path), start calculating path from left or right
    // 2. continue to left
    // 3. continue to right

}

private fun maxPathSum(root: TreeNode?, currentMax: Int): Int {
    if (root == null) {
        return currentMax
    }

    val leftMax = maxPathSum(root.left, root.`val`) // TODO: it's not supposed to be passed that way, need to figure it out after writing the rest of flow
    val rightMax = maxPathSum(root.right, root.`val`) // TODO: it's not supposed to be passed that way, need to figure it out after writing the rest of flow

    val childrenMax = max(leftMax, rightMax)

    return max(childrenMax, childrenMax + currentMax)
}