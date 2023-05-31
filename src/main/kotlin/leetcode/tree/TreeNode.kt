package leetcode.tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return "$`val` [${left?.`val`} , ${right?.`val`}]"
    }
}