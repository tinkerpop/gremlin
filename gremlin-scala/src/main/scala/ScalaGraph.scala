package com.tinkerpop.gremlin.scala

import com.tinkerpop.blueprints.pgm.{Graph, Vertex, Edge}

/**Adds convenience methods to [[com.tinkerpop.blueprints.pgm.Graph]]. */
class ScalaGraph(val graph: Graph) {
  /** Returns all vertices. */
  def V: GremlinScalaPipeline[Graph, Vertex] = 
    new GremlinScalaPipeline[Graph, Vertex](graph).V().asInstanceOf[GremlinScalaPipeline[Graph, Vertex]]

  /** Returns the vertices with the specified IDs. */
  def V(ids: Any*): Iterable[Vertex] = ids.map(graph.getVertex(_))

  /** Returns the vertex with the specified ID. */
  def v(id: Any): Vertex = graph getVertex id

  /** Returns all edges. */
  def E = new GremlinScalaPipeline[Graph, Edge](graph).E()

  /** Returns the edges with the specified IDs. */
  def E(ids: Any*): Iterable[Edge] = ids map { graph getEdge _ }

  /** Returns the edge with the specified ID. */
  def e(id: Any): Edge = graph getEdge id

  //TODO def += for addVertex and addEdge?
}

/**Implicit conversions between [[com.tinkerpop.blueprints.pgm.Graph]] and [[com.tinkerpop.gremlin.scala.ScalaGraph]]. */
object ScalaGraph {
  implicit def wrap(graph: Graph) = new ScalaGraph(graph)

  implicit def unwrap(wrapper: ScalaGraph) = wrapper.graph
}
