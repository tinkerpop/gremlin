package com.tinkerpop.gremlin.scala

import com.tinkerpop.blueprints.pgm.{Vertex, Edge}

/**Adds convenience methods to [[com.tinkerpop.blueprints.pgm.Edge]]. */
class ScalaEdge(val edge: Edge) {
  def inV: GremlinScalaPipeline[Edge, Vertex] = 
    new GremlinScalaPipeline[Edge, Vertex](edge).inV().asInstanceOf[GremlinScalaPipeline[Edge, Vertex]]

  def outV: GremlinScalaPipeline[Edge, Vertex] = 
    new GremlinScalaPipeline[Edge, Vertex](edge).outV().asInstanceOf[GremlinScalaPipeline[Edge, Vertex]]

  def bothV: GremlinScalaPipeline[Edge, Vertex] = 
    new GremlinScalaPipeline[Edge, Vertex](edge).bothV().asInstanceOf[GremlinScalaPipeline[Edge, Vertex]]
}

/**Implicit conversions between [[com.tinkerpop.blueprints.pgm.Edge]] and [[com.tinkerpop.gremlin.scala.ScalaEdge]]. */
object ScalaEdge {
  implicit def wrap(edge: Edge) = new ScalaEdge(edge)

  implicit def unwrap(wrapper: ScalaEdge) = wrapper.edge
}
