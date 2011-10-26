package com.tinkerpop.gremlin.scala

import com.tinkerpop.blueprints.pgm.{Vertex, Edge}

/**Adds convenience methods to [[com.tinkerpop.blueprints.pgm.Edge]]. */
class ScalaEdge(val edge: Edge) {
  def inV = new GremlinScalaPipeline[Edge, Vertex](edge).inV()

  def outV = new GremlinScalaPipeline[Edge, Vertex](edge).outV()

  def bothV = new GremlinScalaPipeline[Edge, Vertex](edge).bothV()
}

/**Implicit conversions between [[com.tinkerpop.blueprints.pgm.Edge]] and [[com.tinkerpop.gremlin.scala.ScalaEdge]]. */
object ScalaEdge {
  implicit def wrap(edge: Edge) = new ScalaEdge(edge)

  implicit def unwrap(wrapper: ScalaEdge) = wrapper.edge
}
