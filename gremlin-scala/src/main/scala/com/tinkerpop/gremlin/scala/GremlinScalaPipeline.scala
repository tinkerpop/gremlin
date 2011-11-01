package com.tinkerpop.gremlin.scala

import com.tinkerpop.blueprints.pgm.{Vertex, Edge, Graph}
import com.tinkerpop.gremlin.pipes.GremlinPipeline
import java.util.{List => JList}

/**Adds convenience methods to [[com.tinkerpop.gremline.pipes.GremlinPipeline]]. */
class GremlinScalaPipeline[S, E](s: S) extends GremlinPipeline[S, E](s) /*with Iterator[E]*/ {
  /*def hasNext: Boolean = pipeline.hasNext

  def next(): E = pipeline.next()*/

  def loop(numberedStep: Int, whileFunction: Function1[Any, Boolean]): GremlinScalaPipeline[S, E] =
    loop(numberedStep, whileFunction).asInstanceOf[GremlinScalaPipeline[S, E]]
  
  def out: GremlinScalaPipeline[S, Vertex] = 
    super.out().asInstanceOf[GremlinScalaPipeline[S, Vertex]]
  
  def paths: GremlinScalaPipeline[S, JList[_]] = 
    super.path().asInstanceOf[GremlinScalaPipeline[S, JList[_]]]

}
