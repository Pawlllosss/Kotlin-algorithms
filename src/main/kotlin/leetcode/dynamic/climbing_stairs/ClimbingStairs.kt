package leetcode.dynamic.climbing_stairs

fun main() {
    println(climbStairs(3))
    println(climbStairs(4))
    println(climbStairs(5))
}

fun climbStairs(n: Int): Int {
    var twoStepsEarlier = 1
    var oneStepEarlier = 2

    if (n < 1) {
        return 0
    } else if (n == 1) {
        return twoStepsEarlier
    } else if (n == 2) {
        return oneStepEarlier
    }

    var result = twoStepsEarlier + oneStepEarlier

    for (i in 4..n) {
        twoStepsEarlier = oneStepEarlier
        oneStepEarlier = result
        result = twoStepsEarlier + oneStepEarlier
    }

    return result
}