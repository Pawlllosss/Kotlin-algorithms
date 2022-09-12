package subset.backtracking

fun main() {
    val subsetGenerator = SubsetGenerator()
    println(subsetGenerator.generatePossibleSubsets(setOf(1, 2, 3)))
    println(subsetGenerator.generatePossibleSubsets(setOf(1, 2, 3, 4, 5)))
}