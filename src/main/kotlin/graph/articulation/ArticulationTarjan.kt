package graph.articulation

import graph.search.DepthFirstSearch
import graph.structure.Graph
import graph.structure.Vertex
import java.lang.IllegalStateException

class ArticulationTarjan : DepthFirstSearch() {

    private val numberOfChildrenByVertex: MutableMap<Vertex, Int> = mutableMapOf()
    private val lowestEnterTimeByVertex: MutableMap<Vertex, Int> = mutableMapOf()

    private var articulationVertices: MutableSet<Vertex> = mutableSetOf()

    override fun preprocessVertex(vertex: Vertex) {
        enterTimeByVertex[vertex] = time
        lowestEnterTimeByVertex[vertex] = time
        time++
        discoveredVertices.add(vertex)
    }

    override fun processEdge(currentVertex: Vertex, parentVertex: Vertex) {
        parentByVertex[currentVertex] = parentVertex
        if (!numberOfChildrenByVertex.containsKey(parentVertex)) {
            numberOfChildrenByVertex[parentVertex] = 1
        } else {
            numberOfChildrenByVertex.computeIfPresent(parentVertex) { _, value -> value + 1 }
        }
        super.processEdge(currentVertex, parentVertex)
    }

    override fun postprocessVertex(vertex: Vertex, graph: Graph) {
        val adjacentVertices = graph.getVertexAdjacency(vertex)

        if (parentByVertex[vertex] == null && numberOfChildrenByVertex[vertex]?.let { it > 1 } == true) {
            articulationVertices.add(vertex)
        } else if (compareVisitedTimeWithAdjacentVertices(vertex, adjacentVertices)) {
            articulationVertices.add(vertex)
        }

        adjacentVertices.filter { lowestEnterTimeByVertex.containsKey(it) }
            .map { lowestEnterTimeByVertex[it] }
            .minByOrNull { it!! }?.also { lowestEnterTimeByVertex[vertex] = it }

        processedVertices.add(vertex)
    }

    override fun displayProcessingResults() {
        println("Articulation vertices: ${this.articulationVertices}")
    }

    private fun compareVisitedTimeWithAdjacentVertices(vertex: Vertex, adjacentVertices: List<Vertex>): Boolean {
        val visitedTime = enterTimeByVertex[vertex]
            ?: throw IllegalStateException("Processed vertex: ${vertex.label} should have enter time")

        return adjacentVertices.filter {
            lowestEnterTimeByVertex[it]?.let { lowestEnter -> lowestEnter >= visitedTime } ?: false
        }.any()
    }
}