package leetcode.list

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        return `val`.toString() + " -> " + next?.`val`
    }
}