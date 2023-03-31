package heap.median

import java.util.*


class MedianFinder {

    private var currentSize: Int = 0
    private val smallerHalfLargest: PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())
    private val biggerHalfSmallest: PriorityQueue<Int> = PriorityQueue()

    fun addNum(num: Int) {
        if (currentSize == 0) {
            biggerHalfSmallest.add(num)
        } else if (currentSize == 1) {
            // after previous run only biggerHalfSmallest is populated
            if (num < biggerHalfSmallest.peek()) {
                smallerHalfLargest.add(num)
            } else {
                smallerHalfLargest.add(biggerHalfSmallest.poll())
                biggerHalfSmallest.add(num)
            }
        } else {

            val smallerHalfTop = smallerHalfLargest.peek()
            val biggerHalfTop = biggerHalfSmallest.peek()

            if (num < smallerHalfTop) {
                if (smallerHalfLargest.size > biggerHalfSmallest.size) {
                    biggerHalfSmallest.add(smallerHalfLargest.poll())
                }
                smallerHalfLargest.add(num)
            } else if (num > biggerHalfTop) {
                if (smallerHalfLargest.size < biggerHalfSmallest.size) {
                    smallerHalfLargest.add(biggerHalfSmallest.poll())
                }
                biggerHalfSmallest.add(num)
            } else {
                // case when item is in the middle
                if (smallerHalfLargest.size > biggerHalfSmallest.size) {
                    biggerHalfSmallest.add(num)
                } else {
                    smallerHalfLargest.add(num)
                }
            }

        }

        currentSize++
    }

    fun findMedian(): Double {
        if (currentSize == 0) {
            throw IllegalStateException("Find median called before adding any value")
        }

        return when {
            currentSize > 0 && currentSize % 2 == 0 -> (smallerHalfLargest.peek()!! + biggerHalfSmallest.peek()!!) / 2.0
            smallerHalfLargest.size > biggerHalfSmallest.size -> smallerHalfLargest.peek().toDouble()
            else -> biggerHalfSmallest.peek().toDouble()
        }
    }
}
