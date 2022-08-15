package graph.structure

class Graph(private val directed: Boolean) {

    private val adjacencyList: MutableMap<Vertex, List<Vertex>> = mutableMapOf()

    fun getVertexAdjacency(vertex: Vertex): List<Vertex> = adjacencyList[vertex] ?: emptyList()

    fun setVertexAdjacency(vertex: Vertex, adjacentVertices: List<Vertex>) {
        adjacencyList[vertex] = adjacentVertices
    }
}