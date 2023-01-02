package leetcode.binary_sum

fun main() {
    println("${getSum(2, 3)} ${getBinarySum(2, 3)}")
    println("${getSum(-2, -3)} ${getBinarySum(-2, -3)}")
}

fun getSum(a: Int, b: Int): Int {
    var d = a
    val loopPositions = if (b > 0) b else -b

    for (i in 0 until loopPositions) {
        if (b > 0) {
            d++
        } else {
            d--
        }
    }

    return d
}

fun getBinarySum(a: Int, b: Int): Int {
    var xorResult = a xor b
    var carryResult = a and b

    while (carryResult != 0) {
        val shiftedCarry = carryResult shl 1
        carryResult = shiftedCarry and xorResult
        xorResult = xorResult xor shiftedCarry
    }

    return xorResult
}
