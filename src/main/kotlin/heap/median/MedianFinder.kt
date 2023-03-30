package heap.median

import java.util.*


class MedianFinder() {

    private var currentMedian: Double? = null
    private var currentSize: Int = 0
    private val smallerHalfLargest: PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())
    private val biggerHalfSmallest: PriorityQueue<Int> = PriorityQueue()

    fun addNum(num: Int) {
        currentSize++
        when {
            currentMedian == null -> {
                currentMedian = num.toDouble()
                biggerHalfSmallest.add(num)
            }
            num < currentMedian!! -> smallerHalfLargest.add(num)
            else -> biggerHalfSmallest.add(num)
        }

        currentMedian = calculateNewMedian()
    }

    fun findMedian(): Double {
        return currentMedian ?: throw IllegalStateException("Find median called before adding any value")
    }

    private fun calculateNewMedian(): Double {
        return when {
            currentSize % 2 == 0 -> return when {
                smallerHalfLargest.isNotEmpty() && biggerHalfSmallest.isNotEmpty() -> {
                    (smallerHalfLargest.peek()!! + biggerHalfSmallest.peek()!!) / 2.0
                }
                smallerHalfLargest.isNotEmpty() -> {
                    val top1 = smallerHalfLargest.poll()
                    val top2 = smallerHalfLargest.peek()
                    smallerHalfLargest.add(top1)
                    (top1 + top2) / 2.0
                }
                else -> {
                    val top1 = biggerHalfSmallest.poll()
                    val top2 = biggerHalfSmallest.peek()
                    biggerHalfSmallest.add(top1)
                    (top1 + top2) / 2.0

                }
            }
            smallerHalfLargest.size > biggerHalfSmallest.size -> smallerHalfLargest.peek().toDouble()
            else -> biggerHalfSmallest.peek().toDouble()
        }
    }
}
