package com.tinkerpop.gremlin.scala

/*
import org.specs2.mutable._
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory
import com.tinkerpop.pipes.PipeFunction
import com.tinkerpop.gremlin.java.GremlinPipeline

class ScalaPipeFunctionTest extends SpecificationWithJUnit {
  "The scala PipeFunction implicits" should {
    "properly wrap any function literal" in {
      val f: String => Int = s => s.length
      val pf: PipeFunction[String, Int] = f

      pf.compute("abcd") must_== f("abcd")
    }

    "properly wrap a String => Boolean function literal" in {
      val graph = TinkerGraphFactory.createTinkerGraph()
      val fp = new GremlinPipeline(graph getVertex 1) out "knows" property "name" filter {
        s: String => s startsWith "j"
      }

      fp.hasNext() must_== true
      fp.next() must_== "josh"
      fp.hasNext() must_== false
    }
  }
}
*/
