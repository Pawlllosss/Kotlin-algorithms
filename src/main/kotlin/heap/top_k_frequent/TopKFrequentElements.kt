package heap.top_k_frequent

import java.util.*


fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val frequencyByNumber = getFrequencyByNumber(nums)
    val numbersSortedByFrequency = PriorityQueue<Pair<Int, Int>> { pair1, pair2 -> pair2.first - pair1.first }
    frequencyByNumber.forEach { (key, value) -> numbersSortedByFrequency.add(value to key) }

    return (1..k).map { numbersSortedByFrequency.poll() }
        .map { it.second }
        .toIntArray()
}

fun topKFrequentWithMap(nums: IntArray, k: Int): IntArray {
    val frequencyByNumber = getFrequencyByNumber(nums)
    val numbersByFrequencySorted = frequencyByNumber.entries.groupBy({ it.value }, { it.key }).toSortedMap(
        compareByDescending { it })

    return numbersByFrequencySorted.entries.take(k).flatMap { it.value }.take(k).toIntArray()
}

private fun getFrequencyByNumber(nums: IntArray): MutableMap<Int, Int> {
    val frequencyByNumber = mutableMapOf<Int, Int>()

    nums.forEach {
        if (frequencyByNumber.containsKey(it)) {
            frequencyByNumber.compute(it) { _, value -> value!! + 1 }
        } else {
            frequencyByNumber[it] = 1
        }
    }
    return frequencyByNumber
}
