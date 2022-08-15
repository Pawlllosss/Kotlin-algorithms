package graph.search

import graph.structure.Graph
import graph.structure.Vertex

// TODO: consider making processing a functional member
class DepthFirstSearch {

    private val discoveredVertices: MutableSet<Vertex> = mutableSetOf()
    private val processedVertices: MutableSet<Vertex> = mutableSetOf()
    private val enterTimeByVertex: MutableMap<Vertex, Int> = mutableMapOf()
    private val exitTimeByVertex: MutableMap<Vertex, Int> = mutableMapOf()
    private val parentByVertex: MutableMap<Vertex, Vertex> = mutableMapOf()
    private var time: Int = 0

    fun dfs(graph: Graph, root: Vertex) {
        discoveredVertices.add(root)
        time++
        enterTimeByVertex[root] = time

        println("Processing root: ${root.label}")

        for (vertex in graph.getVertexAdjacency(root)) {
            if (!discoveredVertices.contains(vertex)) {
                println("Processing vertex: ${vertex.label}")
                parentByVertex[vertex] = root
                dfs(graph, vertex)
            }
        }

        processedVertices.add(root)
        exitTimeByVertex[root] = time
        time++
    }
}