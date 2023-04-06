package heap.top_k_frequent

import java.util.*


fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val frequencyByNumber = mutableMapOf<Int, Int>()
    val numbersSortedByFrequency = PriorityQueue<Pair<Int, Int>> { pair1, pair2 -> pair2.first - pair1.first }


    nums.forEach {
        if (frequencyByNumber.containsKey(it)) {
            frequencyByNumber.compute(it) { _, value -> value!! + 1 }
        } else {
            frequencyByNumber[it] = 1
        }
    }

    frequencyByNumber.forEach { (key, value) -> numbersSortedByFrequency.add(value to key) }

    return (1..k).map { numbersSortedByFrequency.poll() }
        .map { it.second }
        .toIntArray()
}