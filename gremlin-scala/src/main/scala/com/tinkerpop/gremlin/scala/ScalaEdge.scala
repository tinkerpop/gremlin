package com.tinkerpop.gremlin.scala

import com.tinkerpop.blueprints.pgm.{Vertex, Edge}

/**Adds convenience methods to [[com.tinkerpop.blueprints.pgm.Edge]]. */
class ScalaEdge(val edge: Edge) extends ScalaElement(edge) {
  def inV: GremlinScalaPipeline[Edge, Vertex] =
    new GremlinScalaPipeline[Edge, Vertex].start(edge).inV().asInstanceOf[GremlinScalaPipeline[Edge, Vertex]]

  def outV: GremlinScalaPipeline[Edge, Vertex] =
    new GremlinScalaPipeline[Edge, Vertex].start(edge).outV().asInstanceOf[GremlinScalaPipeline[Edge, Vertex]]

  def bothV: GremlinScalaPipeline[Edge, Vertex] =
    new GremlinScalaPipeline[Edge, Vertex].start(edge).bothV().asInstanceOf[GremlinScalaPipeline[Edge, Vertex]]

  def -> : GremlinScalaPipeline[Edge, Edge] =
    new GremlinScalaPipeline[Edge, Edge].start(edge).asInstanceOf[GremlinScalaPipeline[Edge, Edge]];
}

/**Implicit conversions between [[com.tinkerpop.blueprints.pgm.Edge]] and [[com.tinkerpop.gremlin.scala.ScalaEdge]]. */
object ScalaEdge {
  implicit def wrap(edge: Edge) = new ScalaEdge(edge)

  implicit def unwrap(wrapper: ScalaEdge) = wrapper.edge
}
