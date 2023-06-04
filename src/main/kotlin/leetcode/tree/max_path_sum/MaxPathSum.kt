package leetcode.tree.max_path_sum

import leetcode.tree.TreeNode
import kotlin.math.max


class MaxPathSumSolver {
    private var currentMax = Int.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int {
        this.currentMax = Int.MIN_VALUE
        maxPathSumWithTrackingCurrentMax(root)
        return this.currentMax
    }

    private fun maxPathSumWithTrackingCurrentMax(root: TreeNode?): Int {
        if (root == null) {
            return Int.MIN_VALUE
        }

        val leftMax = max(maxPathSumWithTrackingCurrentMax(root.left), 0)
        val rightMax = max(maxPathSumWithTrackingCurrentMax(root.right), 0)

        this.currentMax = max(this.currentMax, root.`val` + leftMax + rightMax)
        val childrenMax = max(leftMax, rightMax)
        return root.`val` + childrenMax
    }
}