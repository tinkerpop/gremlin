package com.tinkerpop.gremlin.scala

import com.tinkerpop.blueprints.pgm.{Vertex, Edge, Graph}
import com.tinkerpop.gremlin.pipes.GremlinPipeline

/**Adds convenience methods to [[com.tinkerpop.blueprints.pgm.Vertex]]. */
class ScalaVertex(val vertex: Vertex) {
  def out = new ScalaFluentPipeline[Vertex, Vertex](vertex).out().asInstanceOf[ScalaFluentPipeline[Vertex, Vertex]]

  def out(labels: String*) = new ScalaFluentPipeline[Vertex, Vertex](vertex).out(labels: _*)

  def outE = new ScalaFluentPipeline[Vertex, Edge](vertex).outE()

  def outE(labels: String*) = new ScalaFluentPipeline[Vertex, Edge](vertex).outE(labels: _*)

  def in = new ScalaFluentPipeline[Vertex, Vertex](vertex).in()

  def in(labels: String*) = new ScalaFluentPipeline[Vertex, Vertex](vertex).in(labels: _*)

  def inE = new ScalaFluentPipeline[Vertex, Edge](vertex).inE()

  def inE(labels: String*) = new ScalaFluentPipeline[Vertex, Edge](vertex).inE(labels: _*)

  def both = new ScalaFluentPipeline[Vertex, Vertex](vertex).both()

  def both(labels: String*) = new ScalaFluentPipeline[Vertex, Vertex](vertex).both(labels: _*)

  def bothE = new ScalaFluentPipeline[Vertex, Edge](vertex).bothE()

  def bothE(labels: String*) = new ScalaFluentPipeline[Vertex, Edge](vertex).bothE(labels: _*)

  //TODO map
  //TODO property
  //TODO apply to access a property?
}

/**Implicit conversions between [[com.tinkerpop.blueprints.pgm.Vertex]] and [[com.tinkerpop.gremlin.scala.ScalaVertex]]. */
object ScalaVertex {
  implicit def wrap(vertex: Vertex) = new ScalaVertex(vertex)

  implicit def unwrap(wrapper: ScalaVertex) = wrapper.vertex
}

/**Adds convenience methods to [[com.tinkerpop.blueprints.pgm.Edge]]. */
class ScalaEdge(val edge: Edge) {
  def inV = new ScalaFluentPipeline[Edge, Vertex](edge).inV()

  def outV = new ScalaFluentPipeline[Edge, Vertex](edge).outV()

  def bothV = new ScalaFluentPipeline[Edge, Vertex](edge).bothV()
}

/**Implicit conversions between [[com.tinkerpop.blueprints.pgm.Edge]] and [[com.tinkerpop.gremlin.scala.ScalaEdge]]. */
object ScalaEdge {
  implicit def wrap(edge: Edge) = new ScalaEdge(edge)

  implicit def unwrap(wrapper: ScalaEdge) = wrapper.edge
}

/**Adds convenience methods to [[com.tinkerpop.blueprints.pgm.Graph]]. */
class ScalaGraph(val graph: Graph) {
  /** Returns all vertices. */
  def V: ScalaFluentPipeline[Graph, Vertex] = 
    new ScalaFluentPipeline[Graph, Vertex](graph).V().asInstanceOf[ScalaFluentPipeline[Graph, Vertex]]

  /** Returns the vertices with the specified IDs. */
  def V(ids: Any*): Iterable[Vertex] = ids.map(graph.getVertex(_))

  /** Returns the vertex with the specified ID. */
  def v(id: Any): Vertex = graph getVertex id

  /** Returns all edges. */
  def E = new ScalaFluentPipeline[Graph, Edge](graph).E()

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

/**Adds convenience methods to [[com.tinkerpop.pipes.util.PipesPipeline]]. */
class ScalaFluentPipeline[A, B](a: A) extends GremlinPipeline[A, B](a) /*with Iterator[B]*/ {

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
  //    and the hasNext & next methods can delegate to hasNext() & next() in PipesPipeline

  /*def hasNext: Boolean = pipeline.hasNext

  def next(): B = pipeline.next()*/

  def loop[T](numberedStep: Int)(whileFunction: Function1[T, Boolean]): ScalaFluentPipeline[A, B] =
    loop(numberedStep, whileFunction).asInstanceOf[ScalaFluentPipeline[A, B]]
  
  def out: ScalaFluentPipeline[A, Vertex] = super.out().asInstanceOf[ScalaFluentPipeline[A, Vertex]]
}

/**Implicit conversions between [[com.tinkerpop.pipes.util.PipesPipeline]] and [[com.tinkerpop.gremlin.scala.ScalaFluentPipeline]]. */
/*object ScalaFluentPipeline {
  implicit def wrap[A, B](fp: GremlinPipeline[A, B]) = new ScalaFluentPipeline(fp)

  implicit def unwrap[A, B](wrapper: ScalaFluentPipeline[A, B]) = wrapper.pipeline
}*/

