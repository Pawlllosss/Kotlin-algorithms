package permutation.recursion

class RecursivePermutation {

    fun permutate(input: Set<Int>): List<List<Int>> {
        val generatedPermutations = mutableListOf<List<Int>>()
        permutate(emptyList(), LinkedHashSet(input), generatedPermutations)

        return generatedPermutations
    }

    private fun permutate(
        currentPermutation: List<Int>,
        elementsLeftToUse: LinkedHashSet<Int>,
        generatedPermutations: MutableList<List<Int>>
    ) {
        for (element in elementsLeftToUse) {
            val newPermutation = currentPermutation + element
            val newElementsLeftToUse = getNewElementsLeftToUse(elementsLeftToUse, element)
            permutate(newPermutation, newElementsLeftToUse, generatedPermutations)
        }

        if (elementsLeftToUse.isEmpty()) {
            generatedPermutations.add(currentPermutation)
        }
    }

    private fun getNewElementsLeftToUse(
        elementsLeftToUse: LinkedHashSet<Int>,
        element: Int
    ): LinkedHashSet<Int> {
        val elements = LinkedHashSet(elementsLeftToUse)
        elements.remove(element)

        return elements
    }
}