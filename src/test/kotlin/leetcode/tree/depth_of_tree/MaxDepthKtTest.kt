package leetcode.tree.depth_of_tree

import leetcode.tree.TreeNode
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class MaxDepthKtTest {

    companion object {
        @JvmStatic
        fun treeWithMaxDepth(): Stream<Arguments> = Stream.of(
            Arguments.of(createTree1(), 3),
            Arguments.of(createTree2(), 2),
        )

        private fun createTree1(): TreeNode {
            val root = TreeNode(3)
            root.left = TreeNode(9)
            val rightToRoot = TreeNode(20)
            rightToRoot.left = TreeNode(15)
            rightToRoot.right = TreeNode(7)
            root.right = rightToRoot

            return root
        }

        private fun createTree2(): TreeNode {
            val root = TreeNode(1)
            root.right = TreeNode(2)

            return root
        }
    }

    @ParameterizedTest
    @MethodSource("treeWithMaxDepth")
    fun shouldReturnMaxDepthOfTree(root: TreeNode, expectedResult: Int) {
        Assertions.assertThat(maxDepth(root)).isEqualTo(expectedResult)
    }

    @Test
    fun shouldReturn0DepthIfNullTree() {
        Assertions.assertThat(maxDepth(null)).isEqualTo(0)
    }
}