package subset.backtracking

class SubsetGenerator {

    fun generatePossibleSubsets(input: Set<Int>): List<Set<Int>> {
        val result = mutableListOf<Set<Int>>()
        val includedPositions = List(input.size) { false }.toMutableList()
        generatePossibleSubsets(input, includedPositions, result, 0)
        return result
    }

    private fun generatePossibleSubsets(
        input: Set<Int>,
        includedPositions: MutableList<Boolean>,
        subsets: MutableList<Set<Int>>,
        position: Int
    ) {
        if (position == input.size) {
            val subset = generateSolution(input, includedPositions)
            subsets.add(subset)
        } else {
            generatePossibleSubsets(input, includedPositions, subsets, position + 1)
            includedPositions[position] = !includedPositions[position]
            generatePossibleSubsets(input, includedPositions, subsets, position + 1)
            includedPositions[position] = !includedPositions[position]
        }
    }

    private fun generateSolution(input: Set<Int>, includedPositions: List<Boolean>): Set<Int> {
        return input.withIndex()
            .filter { includedPositions[it.index] }
            .map { it.value }
            .toSet()
    }
}