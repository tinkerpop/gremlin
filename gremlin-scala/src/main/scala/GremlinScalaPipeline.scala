package com.tinkerpop.gremlin.scala

import com.tinkerpop.blueprints.pgm.{Vertex, Edge, Graph}
import com.tinkerpop.gremlin.pipes.GremlinPipeline

/**Adds convenience methods to [[com.tinkerpop.pipes.util.PipesPipeline]]. */
class GremlinScalaPipeline[A, B](a: A) extends GremlinPipeline[A, B](a) /*with Iterator[B]*/ {

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
  // => If GremlinScalaPipeline[S,E] extends Iterator[E], then it should act like Pipe in all the right Scala ways,
  //    and the hasNext & next methods can delegate to hasNext() & next() in PipesPipeline

  /*def hasNext: Boolean = pipeline.hasNext

  def next(): B = pipeline.next()*/

  def loop[T](numberedStep: Int)(whileFunction: Function1[T, Boolean]): GremlinScalaPipeline[A, B] =
    loop(numberedStep, whileFunction).asInstanceOf[GremlinScalaPipeline[A, B]]
  
  def out: GremlinScalaPipeline[A, Vertex] = super.out().asInstanceOf[GremlinScalaPipeline[A, Vertex]]
}

/**Implicit conversions between [[com.tinkerpop.pipes.util.PipesPipeline]] and [[com.tinkerpop.gremlin.scala.GremlinScalaPipeline]]. */
/*object GremlinScalaPipeline {
  implicit def wrap[A, B](fp: GremlinPipeline[A, B]) = new GremlinScalaPipeline(fp)

  implicit def unwrap[A, B](wrapper: GremlinScalaPipeline[A, B]) = wrapper.pipeline
}*/
