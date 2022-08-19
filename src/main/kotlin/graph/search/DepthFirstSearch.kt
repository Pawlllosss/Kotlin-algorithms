package graph.search

import graph.structure.Graph
import graph.structure.Vertex

// TODO: consider making processing a functional member
open class DepthFirstSearch {

    protected val discoveredVertices: MutableSet<Vertex> = mutableSetOf()
    protected val processedVertices: MutableSet<Vertex> = mutableSetOf()
    protected val enterTimeByVertex: MutableMap<Vertex, Int> = mutableMapOf()
    protected val exitTimeByVertex: MutableMap<Vertex, Int> = mutableMapOf()
    protected val parentByVertex: MutableMap<Vertex, Vertex> = mutableMapOf()
    protected var time: Int = 0

    fun dfs(graph: Graph, root: Vertex) {
        discoveredVertices.add(root)
        time++
        enterTimeByVertex[root] = time

        preprocessVertex(root)

        for (vertex in graph.getVertexAdjacency(root)) {
            if (!discoveredVertices.contains(vertex)) {
                processEdge(vertex, root)
                parentByVertex[vertex] = root
                dfs(graph, vertex)
            }
        }

        processedVertices.add(root)
        exitTimeByVertex[root] = time
        time++

        postprocessVertex(root, graph)
        displayProcessingResults()
    }

    open fun preprocessVertex(vertex: Vertex) {
        println("Processing root: ${vertex.label}")
    }

    open fun processEdge(currentVertex: Vertex, parentVertex: Vertex) {
        println("Processing edge between ${currentVertex.label} and ${parentVertex.label}")
    }

    open fun postprocessVertex(vertex: Vertex, graph: Graph) {
        println("Postprocessing root: ${vertex.label}")
    }

    open fun displayProcessingResults() {
        println("Processed vertices: ${this.processedVertices}")
    }
}