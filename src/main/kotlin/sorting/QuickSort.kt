package sorting

class QuickSort {

    fun sort(input: List<Int>): List<Int> {
        val arrayToSort = ArrayList(input)
        sort(arrayToSort, 0, input.size - 1)
        return arrayToSort
    }

    private fun sort(input: MutableList<Int>, low: Int, high: Int) {
        if (high > low) {
            val partitionIndex = partition(input, low, high)
            sort(input, low, partitionIndex - 1)
            sort(input, partitionIndex + 1, high)
        }
    }

    private fun partition(input: MutableList<Int>, low: Int, high: Int): Int {
        val elementReference = input[high]
        var indexLowerThanReference = low

        for(i in low .. high) {
            val currentElement = input[i]
            
            if (currentElement < elementReference) {
                swap(input, i, indexLowerThanReference)
                indexLowerThanReference++
            }
        }

        swap(input, indexLowerThanReference, high)
        return indexLowerThanReference
    }

    private fun swap(
        input: MutableList<Int>,
        i: Int,
        j: Int,
    ) {
        val tmp = input[i]
        input[i] = input[j]
        input[j] = tmp
    }
}

fun main() {
    val listToSort = listOf(6, 4, 2, 8, 1, 13, 11)
    val sortedList = QuickSort().sort(listToSort)
    print(sortedList)
}