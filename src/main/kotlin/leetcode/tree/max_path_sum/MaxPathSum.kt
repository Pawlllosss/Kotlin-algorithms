package leetcode.tree.max_path_sum

import leetcode.tree.TreeNode
import kotlin.math.max

fun maxPathSum(root: TreeNode?): Int {
    if (root == null) {
        return Int.MIN_VALUE
    }

    val leftMax = maxPathSum(root.left)
    val rightMax = maxPathSum(root.right)
    // path goes from left to right through root
    val sumLeftToRightThroughNode = leftMax + rightMax + root.`val`
    // path goes only through children
    val childrenMax = max(leftMax, rightMax)
    // path goes from root to left or right
    val sumChildrenMaxThroughNode = childrenMax + root.`val`
    val maxThroughNode = max(sumLeftToRightThroughNode, sumChildrenMaxThroughNode)
    val childrenWithOrWithoutRootMax = max(childrenMax, maxThroughNode)

    // include case when no children (Int.MIN_VALUE)
    return max(childrenWithOrWithoutRootMax, root.`val`)
}