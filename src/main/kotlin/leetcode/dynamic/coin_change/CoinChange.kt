package leetcode.dynamic.coin_change

fun main() {
    println(coinChange(intArrayOf(1, 2, 5), 5))
}

fun coinChange(coins: IntArray, amount: Int): Int {
    if (amount == 0) {
        return 0
    }

    val amounts = IntArray(amount + 1) { -1 }

    for (currentAmount in amounts.indices) {
        val numberOfMoves = coins.map { coin ->
            val previousAmount = currentAmount - coin

            when {
                previousAmount < 0 -> -1
                previousAmount == 0 -> 0
                else -> amounts[previousAmount]
            }
        }
            .filter { it >= 0 }
            .minByOrNull { it } ?: -1

        if (numberOfMoves >= 0) {
            amounts[currentAmount] = numberOfMoves + 1
        }
    }

    return amounts.last()
}