package com.tinkerpop.gremlin.scala

import com.tinkerpop.blueprints.pgm.{Vertex, Edge, Graph}
import com.tinkerpop.pipes.util.FluentPipeline

/** Adds convenience methods to [[com.tinkerpop.blueprints.pgm.Vertex]]. */
class ScalaVertex(val vertex: Vertex) {
  def out = new FluentPipeline(vertex).out()
  def out(labels: String*) = new FluentPipeline(vertex).out(labels: _*)
  
  def outE = new FluentPipeline(vertex).outE()
  def outE(labels: String*) = new FluentPipeline(vertex).outE(labels: _*)
  
  def in = new FluentPipeline(vertex).in()
  def in(labels: String*) = new FluentPipeline(vertex).in(labels: _*)
  
  def inE = new FluentPipeline(vertex).inE()
  def inE(labels: String*) = new FluentPipeline(vertex).inE(labels: _*)
  
  def both = new FluentPipeline(vertex).both()
  def both(labels: String*) = new FluentPipeline(vertex).both(labels: _*)
  
  def bothE = new FluentPipeline(vertex).bothE()
  def bothE(labels: String*) = new FluentPipeline(vertex).bothE(labels: _*)
}

/** Implicit conversions between [[com.tinkerpop.blueprints.pgm.Vertex]] and [[com.tinkerpop.gremlin.scala.ScalaVertex]]. */
object ScalaVertex {
  implicit def wrap(vertex: Vertex) = new ScalaVertex(vertex)
  implicit def unwrap(wrapper: ScalaVertex) = wrapper.vertex
}

/** Adds convenience methods to [[com.tinkerpop.blueprints.pgm.Edge]]. */
class ScalaEdge(val edge: Edge) {
  def inV = new FluentPipeline(edge).inV()
  def outV = new FluentPipeline(edge).outV()
  def bothV = new FluentPipeline(edge).bothV()
}

/** Implicit conversions between [[com.tinkerpop.blueprints.pgm.Edge]] and [[com.tinkerpop.gremlin.scala.ScalaEdge]]. */
object ScalaEdge {
  implicit def wrap(edge: Edge) = new ScalaEdge(edge)
  implicit def unwrap(wrapper: ScalaEdge) = wrapper.edge
}

/** Adds convenience methods to [[com.tinkerpop.blueprints.pgm.Graph]]. */
class ScalaGraph(val graph: Graph) {
  def V = new FluentPipeline(graph).V()
  def E = new FluentPipeline(graph).E()
  
  //in Groovy, Graph.v appears to return a vertex if called with one ID, or a list of vertices if called with multiple IDs...
  /*def v(id: Object): Vertex = graph getVertex id
  def v(id: Object, ids: Object*): Iterable[Vertex] = {
    val v1 = graph getVertex id
    val vs = ids.map(graph.getVertex(_))
    Iterable(v1, vs: _*)
  }*/
  def v(ids: Object*): Iterable[Vertex] = ids.map(graph.getVertex(_))
  
  //def += for addVertex and addEdge?
}

/** Implicit conversions between [[com.tinkerpop.blueprints.pgm.Graph]] and [[com.tinkerpop.gremlin.scala.ScalaGraph]]. */
object ScalaGraph {
  implicit def wrap(graph: Graph) = new ScalaGraph(graph)
  implicit def unwrap(wrapper: ScalaGraph) = wrapper.graph
}

/** Adds convenience methods to [[com.tinkerpop.pipes.util.FluentPipeline]]. */
class ScalaFluentPipeline[A, B](val pipeline: FluentPipeline[A, B]) extends Iterator[B] {
  //Pipe<S,E> is both:
  // - Iterator<E> = iterate over elements in collection, defines hasNext(), next() and remove() methods
  // - Iterable<E> = can be target of foreach statement, defines iterator() method
  // => so you can use Pipe<S,E> as a raw Iterator<E> or in for(E e : pipe), the key point is that you iterate over the Es
  
  //Scala's Iterator[A] trait provides much more than just hasNext, next & foreach; like map/flatMap/filter/fold/toX/etc
  // - thus an Iterator can be used in for-comprehensions
  // - scala.collection.JavaConversions.JIteratorWrapper is a Scala Iterator that wraps a Java Iterator
  
  //Scala's Iterable[A] trait provides a lot of what Iterator provides, but also the ability to create new collections of the same type
  // - Iterable is really meant to be implemented by actual collection data structures
  // - Iterator is probably better for things that just provide a way to iterate over some contained elements
  // => If ScalaFluentPipeline[S,E] extends Iterator[E], then it should act like Pipe in all the right Scala ways,
  //    and the hasNext & next methods can delegate to hasNext() & next() in FluentPipeline
  
  def hasNext: Boolean = pipeline.hasNext
  def next(): B = pipeline.next()
  
  def loop[T](numberedStep: Int)(whileFunction: Function1[T, Boolean]) = pipeline.loop(numberedStep, whileFunction)
}

/** Implicit conversions between [[com.tinkerpop.pipes.util.FluentPipeline]] and [[com.tinkerpop.gremlin.scala.ScalaFluentPipeline]]. */
object ScalaFluentPipeline {
  implicit def wrap[A, B](fp: FluentPipeline[A, B]) = new ScalaFluentPipeline(fp)
  implicit def unwrap[A, B](wrapper: ScalaFluentPipeline[A, B]) = wrapper.pipeline
}

