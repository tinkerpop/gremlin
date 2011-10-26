package com.tinkerpop.gremlin.scala

import com.tinkerpop.blueprints.pgm.{Vertex, Edge}

/**Adds convenience methods to [[com.tinkerpop.blueprints.pgm.Vertex]]. */
class ScalaVertex(val vertex: Vertex) {
  def out = new GremlinScalaPipeline[Vertex, Vertex](vertex).out().asInstanceOf[GremlinScalaPipeline[Vertex, Vertex]]

  def out(labels: String*) = new GremlinScalaPipeline[Vertex, Vertex](vertex).out(labels: _*)

  def outE = new GremlinScalaPipeline[Vertex, Edge](vertex).outE()

  def outE(labels: String*) = new GremlinScalaPipeline[Vertex, Edge](vertex).outE(labels: _*)

  def in = new GremlinScalaPipeline[Vertex, Vertex](vertex).in()

  def in(labels: String*) = new GremlinScalaPipeline[Vertex, Vertex](vertex).in(labels: _*)

  def inE = new GremlinScalaPipeline[Vertex, Edge](vertex).inE()

  def inE(labels: String*) = new GremlinScalaPipeline[Vertex, Edge](vertex).inE(labels: _*)

  def both = new GremlinScalaPipeline[Vertex, Vertex](vertex).both()

  def both(labels: String*) = new GremlinScalaPipeline[Vertex, Vertex](vertex).both(labels: _*)

  def bothE = new GremlinScalaPipeline[Vertex, Edge](vertex).bothE()

  def bothE(labels: String*) = new GremlinScalaPipeline[Vertex, Edge](vertex).bothE(labels: _*)

  //TODO map
  //TODO property
  //TODO apply to access a property?
}

/**Implicit conversions between [[com.tinkerpop.blueprints.pgm.Vertex]] and [[com.tinkerpop.gremlin.scala.ScalaVertex]]. */
object ScalaVertex {
  implicit def wrap(vertex: Vertex) = new ScalaVertex(vertex)

  implicit def unwrap(wrapper: ScalaVertex) = wrapper.vertex
}
