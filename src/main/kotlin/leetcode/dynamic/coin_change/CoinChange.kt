package leetcode.dynamic.coin_change

import java.lang.Integer.min

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

fun coinChange2(coins: IntArray, amount: Int): Int {
    val amounts = IntArray(amount + 1) { amount + 1 }

    amounts[0] = 0

    for (currentAmount in amounts.indices) {
        for (coin in coins) {
            if (coin <= currentAmount) {
                amounts[currentAmount] = min(amounts[currentAmount], amounts[currentAmount - coin] + 1)
            }
        }
    }

    return if (amounts.last() == amount + 1) -1 else amounts.last()
}