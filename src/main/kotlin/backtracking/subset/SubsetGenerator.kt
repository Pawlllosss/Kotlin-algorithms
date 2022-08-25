package backtracking.subset

class SubsetGenerator {

    fun generatePossibleSubsets(input: List<Int>): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val includedPositions = mutableListOf(false, false, false)
        generatePossibleSubsets(input, includedPositions, result, 0)
        return result
    }

    private fun generatePossibleSubsets(input: List<Int>, includedPositions: MutableList<Boolean>, subsets: MutableList<List<Int>>, position: Int) {
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

    private fun generateSolution(input: List<Int>, includedPositions: List<Boolean>): List<Int> {
        return input.withIndex().filter { includedPositions[it.index] }.map { it.value }
    }
}