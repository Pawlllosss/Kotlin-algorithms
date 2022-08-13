package binary

import sorting.QuickSort

fun main() {
    val list = listOf(6, 2, 8, 1, 4, 1, 7, 5, 1, 8, 4, 1, 6, 1) // 5 ones
    val sortedList = QuickSort().sort(list)

    val leftBoundary = boundaryBinarySearch(sortedList, 1, true)
    val rightBoundary = boundaryBinarySearch(sortedList, 1, false)

    print(rightBoundary - leftBoundary)
}

fun boundaryBinarySearch(input: List<Int>, targetValue: Int, lookToLeft: Boolean): Int {
    return boundaryBinarySearch(input, targetValue, 0, input.size - 1, lookToLeft)
}

private fun boundaryBinarySearch(input: List<Int>, targetValue: Int, low: Int, high: Int, lookToLeft: Boolean): Int {
    if (low > high) {
        return low
    }

    val middle = low + (high - low) / 2

    val compareFunction: (Int, Int) -> Boolean = if (lookToLeft) { a, b -> a > b } else { a, b -> a < b }

    return if (compareFunction(targetValue, input[middle])) {
        if (lookToLeft) {
            boundaryBinarySearch(input, targetValue, middle + 1, high, lookToLeft)
        } else {
            boundaryBinarySearch(input, targetValue, low, middle - 1, lookToLeft)
        }
    } else {
        if (lookToLeft) {
            boundaryBinarySearch(input, targetValue, low, middle - 1, lookToLeft)
        } else {
            boundaryBinarySearch(input, targetValue, middle + 1, high, lookToLeft)
        }
    }
}
