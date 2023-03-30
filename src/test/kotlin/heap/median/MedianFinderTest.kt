package heap.median

import org.assertj.core.api.Assertions
import org.assertj.core.data.Offset
import org.junit.jupiter.api.Test

internal class MedianFinderTest {

    companion object {
        const val resultOffset = 0.00001
    }

    @Test
    fun medianFinderTest1() {
        val medianFinder = MedianFinder()
        medianFinder.addNum(1)
        medianFinder.addNum(2)
        Assertions.assertThat(medianFinder.findMedian()).isEqualTo(1.5, Offset.offset(resultOffset))
        medianFinder.addNum(3)
        Assertions.assertThat(medianFinder.findMedian()).isEqualTo(2.0, Offset.offset(resultOffset))
    }

    @Test
    fun medianFinderTest2() {
        val medianFinder = MedianFinder()
        medianFinder.addNum(5)
        Assertions.assertThat(medianFinder.findMedian()).isEqualTo(5.0, Offset.offset(resultOffset))
        medianFinder.addNum(1)
        Assertions.assertThat(medianFinder.findMedian()).isEqualTo(3.0, Offset.offset(resultOffset))
        medianFinder.addNum(0)
        Assertions.assertThat(medianFinder.findMedian()).isEqualTo(1.0, Offset.offset(resultOffset))
        medianFinder.addNum(2)
        Assertions.assertThat(medianFinder.findMedian()).isEqualTo(1.5, Offset.offset(resultOffset))
        medianFinder.addNum(3)
        Assertions.assertThat(medianFinder.findMedian()).isEqualTo(2.0, Offset.offset(resultOffset))
    }
}