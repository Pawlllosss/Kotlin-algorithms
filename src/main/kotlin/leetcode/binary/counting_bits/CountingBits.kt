package leetcode.binary.counting_bits

fun main() {
    println(countBits(5).contentToString())
}

fun countBits(n: Int): IntArray {
    val numberOfBits = IntArray(n + 1)
    var currentPowOf2 = 0
    var nextPowOf2 = 1

    for (i in 1..n) {
        if (i == nextPowOf2) {
            numberOfBits[i] = 1
            currentPowOf2 = nextPowOf2
            nextPowOf2 *= 2
        } else {
            numberOfBits[i] = 1 + numberOfBits[i - currentPowOf2]
        }
    }

    return numberOfBits
}

fun countBitsWithBitShifting(n: Int): IntArray {
    val numberOfBits = IntArray(n + 1)

    for (i in 1..n) {
        val numberOfBitsAfterShifting = numberOfBits[i shr 1]
        val oddBit = i and 1
        numberOfBits[i] = numberOfBitsAfterShifting + oddBit
    }

    return numberOfBits
}