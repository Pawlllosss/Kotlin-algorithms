package leetcode.tree.max_path_sum

import leetcode.tree.TreeNode
import leetcode.tree.generateTree
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class MaxPathSumKtTest {

    companion object {
        @JvmStatic
        fun treeWithMaxPathSum(): Stream<Arguments> = Stream.of(
            Arguments.of(createTree1(), 6),
            Arguments.of(createTree2(), 42),
            Arguments.of(createTree3(), 3),
            Arguments.of(generateTree(listOf(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1)), 48),
            Arguments.of(TreeNode(-3), -3),
        )

        private fun createTree1(): TreeNode {
            val root = TreeNode(1)
            root.left = TreeNode(2)
            root.right = TreeNode(3)

            return root
        }

        private fun createTree2(): TreeNode {
            val root = TreeNode(-10)
            root.left = TreeNode(9)
            val rightChildren = TreeNode(20)
            rightChildren.left = TreeNode(15)
            rightChildren.right = TreeNode(7)
            root.right = rightChildren

            return root
        }

        private fun createTree3(): TreeNode {
            val root = TreeNode(1)
            val leftChildren = TreeNode(-2)
            val leftLeftChildren = TreeNode(1)
            leftLeftChildren.left = TreeNode(-1)
            leftChildren.left = leftLeftChildren
            leftChildren.right = TreeNode(3)
            val rightChildren = TreeNode(-3)
            rightChildren.left = TreeNode(-2)
            root.left = leftChildren
            root.right = rightChildren

            return root
        }
    }

    @ParameterizedTest
    @MethodSource("treeWithMaxPathSum")
    fun shouldReturnMaxPathSum(root: TreeNode, expectedResult: Int) {
        val solver = MaxPathSumSolver()
        Assertions.assertThat(solver.maxPathSum(root)).isEqualTo(expectedResult)
    }
}