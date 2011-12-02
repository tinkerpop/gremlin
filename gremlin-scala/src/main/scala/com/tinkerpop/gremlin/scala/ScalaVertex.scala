package com.tinkerpop.gremlin.scala

import java.util.{Map => JMap}
import com.tinkerpop.blueprints.pgm.{Vertex, Edge}

/**Adds convenience methods to [[com.tinkerpop.blueprints.pgm.Vertex]]. */
class ScalaVertex(val vertex: Vertex) extends ScalaElement(vertex) {
  def out: GremlinScalaPipeline[Vertex, Vertex] =
    new GremlinScalaPipeline[Vertex, Vertex].start(vertex).out().asInstanceOf[GremlinScalaPipeline[Vertex, Vertex]]

  def out(labels: String*): GremlinScalaPipeline[Vertex, Vertex] =
    new GremlinScalaPipeline[Vertex, Vertex].start(vertex).out(labels: _*).asInstanceOf[GremlinScalaPipeline[Vertex, Vertex]]

  def outE: GremlinScalaPipeline[Vertex, Edge] =
    new GremlinScalaPipeline[Vertex, Edge].start(vertex).outE().asInstanceOf[GremlinScalaPipeline[Vertex, Edge]]

  def outE(labels: String*): GremlinScalaPipeline[Vertex, Edge] =
    new GremlinScalaPipeline[Vertex, Edge].start(vertex).outE(labels: _*).asInstanceOf[GremlinScalaPipeline[Vertex, Edge]]

  def in: GremlinScalaPipeline[Vertex, Vertex] =
    new GremlinScalaPipeline[Vertex, Vertex].start(vertex).in().asInstanceOf[GremlinScalaPipeline[Vertex, Vertex]]

  def in(labels: String*): GremlinScalaPipeline[Vertex, Vertex] =
    new GremlinScalaPipeline[Vertex, Vertex].start(vertex).in(labels: _*).asInstanceOf[GremlinScalaPipeline[Vertex, Vertex]]

  def inE: GremlinScalaPipeline[Vertex, Edge] =
    new GremlinScalaPipeline[Vertex, Edge].start(vertex).inE().asInstanceOf[GremlinScalaPipeline[Vertex, Edge]]

  def inE(labels: String*): GremlinScalaPipeline[Vertex, Edge] =
    new GremlinScalaPipeline[Vertex, Edge].start(vertex).inE(labels: _*).asInstanceOf[GremlinScalaPipeline[Vertex, Edge]]

  def both: GremlinScalaPipeline[Vertex, Vertex] =
    new GremlinScalaPipeline[Vertex, Vertex].start(vertex).both().asInstanceOf[GremlinScalaPipeline[Vertex, Vertex]]

  def both(labels: String*): GremlinScalaPipeline[Vertex, Vertex] =
    new GremlinScalaPipeline[Vertex, Vertex].start(vertex).both(labels: _*).asInstanceOf[GremlinScalaPipeline[Vertex, Vertex]]

  def bothE: GremlinScalaPipeline[Vertex, Edge] =
    new GremlinScalaPipeline[Vertex, Edge].start(vertex).bothE().asInstanceOf[GremlinScalaPipeline[Vertex, Edge]]

  def bothE(labels: String*): GremlinScalaPipeline[Vertex, Edge] =
    new GremlinScalaPipeline[Vertex, Edge].start(vertex).bothE(labels: _*).asInstanceOf[GremlinScalaPipeline[Vertex, Edge]]

  def -> : GremlinScalaPipeline[Vertex, Vertex] =
    new GremlinScalaPipeline[Vertex, Vertex].start(vertex).asInstanceOf[GremlinScalaPipeline[Vertex, Vertex]];
}

/**Implicit conversions between [[com.tinkerpop.blueprints.pgm.Vertex]] and [[com.tinkerpop.gremlin.scala.ScalaVertex]]. */
object ScalaVertex {
  implicit def wrap(vertex: Vertex) = new ScalaVertex(vertex)

  implicit def unwrap(wrapper: ScalaVertex) = wrapper.vertex
}
