package graph.search

import graph.structure.Graph
import graph.structure.Vertex

fun main() {
    val graph: Graph = Graph(false)
//    https://www.youtube.com/watch?v=2kREIkF9UAs
    val vertexA = Vertex("A")
    val vertexB = Vertex("B")
    val vertexC = Vertex("C")
    val vertexD = Vertex("D")
    val vertexE = Vertex("E")
    val vertexF = Vertex("F")
    val vertexG = Vertex("G")
    val vertexH = Vertex("H")
    graph.setVertexAdjacency(vertexA, listOf(vertexB, vertexC))
    graph.setVertexAdjacency(vertexB, listOf(vertexA, vertexC))
    graph.setVertexAdjacency(vertexC, listOf(vertexA, vertexB, vertexD))
    graph.setVertexAdjacency(vertexD, listOf(vertexC,vertexE))
    graph.setVertexAdjacency(vertexE, listOf(vertexD, vertexF, vertexG))
    graph.setVertexAdjacency(vertexF, listOf(vertexE, vertexG, vertexH))
    graph.setVertexAdjacency(vertexG, listOf(vertexE, vertexF))
    graph.setVertexAdjacency(vertexH, listOf(vertexF))

    val depthFirstSearch = DepthFirstSearch()
    depthFirstSearch.dfs(graph, vertexD)
}