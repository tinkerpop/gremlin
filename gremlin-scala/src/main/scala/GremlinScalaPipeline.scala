package com.tinkerpop.gremlin.scala

import com.tinkerpop.blueprints.pgm.{Vertex, Edge, Graph}
import com.tinkerpop.gremlin.pipes.GremlinPipeline

/**Adds convenience methods to [[com.tinkerpop.pipes.util.PipesPipeline]]. */
class GremlinScalaPipeline[S, E](s: S) extends GremlinPipeline[S, E](s) /*with Iterator[E]*/ {
  /*def hasNext: Boolean = pipeline.hasNext

  def next(): E = pipeline.next()*/

  def loop[T](numberedStep: Int)(whileFunction: Function1[T, Boolean]): GremlinScalaPipeline[S, E] =
    loop(numberedStep, whileFunction).asInstanceOf[GremlinScalaPipeline[S, E]]
  
  def out: GremlinScalaPipeline[S, Vertex] = super.out().asInstanceOf[GremlinScalaPipeline[S, Vertex]]
}

/**Implicit conversions between [[com.tinkerpop.pipes.util.PipesPipeline]] and [[com.tinkerpop.gremlin.scala.GremlinScalaPipeline]]. */
/*object GremlinScalaPipeline {
  implicit def wrap[A, B](fp: GremlinPipeline[A, B]) = new GremlinScalaPipeline(fp)

  implicit def unwrap[A, B](wrapper: GremlinScalaPipeline[A, B]) = wrapper.pipeline
}*/
