package heap

import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

class Heap<T : Comparable<T>>(initialSize: Int = 0, private val comparator: Comparator<T> = Comparator.naturalOrder()) {

    private val nodes: MutableList<T> = ArrayList(initialSize)
    private var size = 0

    fun offer(element: T): Boolean {
        if (nodes.size < size + 1) {
            nodes.add(element)
        } else {
            nodes[size + 1] = element
        }
        var newElementIndex = size
        size++

        while (comparisionNotTrueForParent(newElementIndex)) {
            val parentIndex = getParentIndex(newElementIndex)
            Collections.swap(nodes, newElementIndex, parentIndex)
            newElementIndex = parentIndex
        }

        return true
    }

    fun poll(): T? {
        val root = peek() ?: return null
        delete(0)

        return root
    }

    fun peek(): T? = if (size > 0) nodes[0] else null

    fun isEmpty(): Boolean = size == 0

    private fun getParent(index: Int): T = nodes[getParentIndex(index)]

    private fun getParentIndex(index: Int): Int = (index - 1) / 2

    private fun getLeftChildren(index: Int): T? {
        val childrenIndex = getLeftChildrenIndex(index)

        return childrenIndex?.let { nodes[it] }
    }

    private fun getLeftChildrenIndex(index: Int): Int? {
        val childrenIndex = 2 * index + 1
        return if (childrenIndex >= size) {
            null
        } else {
            childrenIndex
        }
    }

    private fun getRightChildren(index: Int): T? {
        val childrenIndex = getRightChildrenIndex(index)

        return childrenIndex?.let { nodes[it] }
    }

    private fun getRightChildrenIndex(index: Int): Int? {
        val childrenIndex = 2 * index + 2
        return if (childrenIndex >= size) {
            null
        } else {
            childrenIndex
        }
    }

    private fun comparisionNotTrueForParent(index: Int): Boolean {
        if (index == 0) {
            return false
        }

        val parent = getParent(index)

        return parent > nodes[index]
    }

    private fun delete(index: Int) {
        Collections.swap(nodes, 0, size - 1)
        nodes.removeLast()
        size--

        heapify(0)
    }

    private fun heapify(index: Int) {
        var smallestIndex = index
        val leftChildrenIndex = getLeftChildrenIndex(index)
        val rightChildrenIndex = getRightChildrenIndex(index)

        if (leftChildrenIndex != null && comparator.compare(nodes[smallestIndex], nodes[leftChildrenIndex]) > 0) {
            smallestIndex = leftChildrenIndex
        }
        if (rightChildrenIndex != null && comparator.compare(nodes[smallestIndex], nodes[rightChildrenIndex]) > 0) {
            smallestIndex = rightChildrenIndex
        }

        if (smallestIndex != index) {
            Collections.swap(nodes, index, smallestIndex)
            heapify(smallestIndex)
        }
    }

}