package com.tinkerpop.gremlin

import com.tinkerpop.pipes.PipeFunction
import _root_.java.lang.{Boolean => JBoolean}

/**Implicit conversions that make Gremlin easier to use in Scala. Users can just `import com.tinkerpop.gremlin.scala._`*/
package object scala {
  /**Most generic conversion: A => B to PipeFunction[A, B]. */
  implicit def functionToPipeFunction[A, B](f: Function1[A, B]) =
    new PipeFunction[A, B] {
      def compute(a: A): B = f(a)
    }

  /**Mainly for GremlinPipeline.filter, to convert A => scala.Boolean to PipeFunction[A, java.lang.Boolean]. */
  implicit def booleanFunctionToPipeFunction[A](f: Function1[A, Boolean]) =
    new PipeFunction[A, JBoolean] {
      def compute(a: A): JBoolean = Boolean box f(a)
    }

  /**Bring the wrap implicits into scope. The compiler will check the unwrap implicits on its own. */
  implicit val wrapScalaVertex = ScalaVertex.wrap _
  implicit val wrapScalaEdge = ScalaEdge.wrap _
  implicit val wrapScalaGraph = ScalaGraph.wrap _

  implicit def wrapScalaLoopBundle[T] = ScalaLoopBundle.wrap[T] _ //must be a def because of the type parameter

  def ->[S]: GremlinScalaPipeline[S, S] = new GremlinScalaPipeline[S, S]()

}

