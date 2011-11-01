package com.tinkerpop.gremlin

import com.tinkerpop.pipes.PipeFunction
import java.lang.{Boolean => JBoolean}
import com.tinkerpop.blueprints.pgm.Vertex

/**Implicit conversions that make PipeFunction easier to use in Scala. Users can just `import com.tinkerpop.gremlin.scala._` */
package object scala {
  /**Most generic conversion: A => B to PipeFunction[A, B]. */
  implicit def functionToPipeFunction[A, B](f: Function1[A, B]) =
    new PipeFunction[A, B] {
      def compute(a: A): B = f(a)
    }
  
  /** Converts a bunch of A => B functions into their corresponding PipeFunction[A, B]. */
  /*implicit def functionsToPipeFunctions[A, B](fs: Function1[A, B]*): Array[PipeFunction[A, B]] =
    fs.map { f => 
      val pf: PipeFunction[A, B] = f
      pf
      //f : PipeFunction[A, B]
    }.toArray*/

  /**Mainly for PipesPipeline.filter, to convert A => scala.Boolean to PipeFunction[A, java.lang.Boolean]. */
  implicit def booleanFunctionToPipeFunction[A](f: Function1[A, Boolean]) =
    new PipeFunction[A, JBoolean] {
      def compute(a: A): JBoolean = Boolean box f(a)
    }

  /**Bring the wrap implicits into scope. The compiler will check the unwrap implicits on its own. */
  implicit val wrapScalaVertex = ScalaVertex.wrap _
  implicit val wrapScalaEdge = ScalaEdge.wrap _
  implicit val wrapScalaGraph = ScalaGraph.wrap _

  //implicit def wrapScalaFluentPipeline[A, B] = ScalaFluentPipeline.wrap[A, B] _ //this implicit has type parameters so it must be a def instead of a val

  //implicit def vertexToPipeline[E](v: Vertex): GremlinScalaPipeline[Vertex, E] = new GremlinScalaPipeline[Vertex, E](v)
}

