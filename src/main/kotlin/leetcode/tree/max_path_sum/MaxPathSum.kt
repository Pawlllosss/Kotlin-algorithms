package leetcode.tree.max_path_sum

import leetcode.tree.TreeNode
import kotlin.math.max

// constraint of task is -1000 <= Node.val <= 1000
const val MINIMUM_NODE_VALUE = -1001

fun maxPathSum(root: TreeNode?): Int {
    return maxPathSumAndIsGoingThroughRoot(root).first
}

private fun maxPathSumAndIsGoingThroughRoot(root: TreeNode?): Pair<Int, Boolean> {
    if (root == null) {
        return MINIMUM_NODE_VALUE to true
    }

    val leftMax = maxPathSumAndIsGoingThroughRoot(root.left)
    val rightMax = maxPathSumAndIsGoingThroughRoot(root.right)
    // path goes only through children
    val childrenMax = max(leftMax.first, rightMax.first)
    // path goes through root
    val maxThroughRoot = calculateSumThroughRoot(leftMax, rightMax, root)

    return if (maxThroughRoot > childrenMax) {
        maxThroughRoot to true
    } else {
        childrenMax to false
    }
}

private fun calculateSumThroughRoot(
    leftMax: Pair<Int, Boolean>,
    rightMax: Pair<Int, Boolean>,
    root: TreeNode
): Int {
    var sum = root.`val`
    if (leftMax.second && leftMax.first > 0) sum += leftMax.first
    if (rightMax.second && rightMax.first > 0) sum += rightMax.first

    return sum
}