package com.tinkerpop.gremlin

import org.specs2.mutable._
import com.tinkerpop.blueprints.pgm.{Vertex, Graph}
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory.createTinkerGraph
import com.tinkerpop.gremlin.scala._
import pipes.GremlinFluentPipeline

class ScalaWrapperTest extends SpecificationWithJUnit {
  "The ScalaFluentPipeline wrapper" should {
    "be a Scala Iterator" in {
      val g = createTinkerGraph()
      val vs = g.getVertices.iterator
      val i: Iterator[Any] = new ScalaFluentPipeline(new GremlinFluentPipeline(g).V())

      i.hasNext must beTrue
      i.next() must_== vs.next
      i.hasNext must beTrue
      i.next() must_== vs.next
      i.hasNext must beTrue
      i.next() must_== vs.next
      i.hasNext must beTrue
      i.next() must_== vs.next
      i.hasNext must beTrue
      i.next() must_== vs.next
      i.hasNext must beTrue
      i.next() must_== vs.next
      i.hasNext must beFalse
    }

    "implicitly wrap a FluentPipeline" in {
      val g = createTinkerGraph()
      val sfp: ScalaFluentPipeline[_, _] = new GremlinFluentPipeline(g).V()

      //sfp must_!= null // <===== weird compiler errors on this line...
      sfp.isInstanceOf[ScalaFluentPipeline[_, _]] must beTrue
    }

    "implicitly wrap a FluentPipeline when calling an Iterable method" in {
      val g = createTinkerGraph()
      val i: Iterable[Any] = new GremlinFluentPipeline(g).V().toIterable

      i must_!= null
    }

    "unwrap ScalaFluentPipeline => FluentPipeline" in {
      val g = createTinkerGraph()
      val fp: GremlinFluentPipeline[_, _] = new GremlinFluentPipeline(g)
      val sfp: ScalaFluentPipeline[_, _] = fp
      def toString(p: GremlinFluentPipeline[_, _]) = p.toString

      toString(fp) must_== toString(sfp) //sfp must be unwrapped when passed to toString
    }
  }

  "The ScalaGraph wrapper" should {
    "return all vertices using V" in {
      val g = createTinkerGraph()
      val vs = g.V.toIterable

      vs must have size (6)
      vs must contain(g getVertex 1)
      vs must contain(g getVertex 2)
      vs must contain(g getVertex 3)
      vs must contain(g getVertex 4)
      vs must contain(g getVertex 5)
      vs must contain(g getVertex 6)
    }

    "return all edges using E" in {
      val g = createTinkerGraph()
      val es = g.E.toIterable
      
      es must have size (6)
      es must contain(g getEdge 7)
      es must contain(g getEdge 8)
      es must contain(g getEdge 9)
      es must contain(g getEdge 10)
      es must contain(g getEdge 11)
      es must contain(g getEdge 12)
    }
    
    "return vertices with specified IDs using v" in {
      val g = createTinkerGraph()
      val vs = g.v(1, 2, 3)
      
      vs must have size (3)
      vs must contain(g getVertex 1)
      vs must contain(g getVertex 2)
      vs must contain(g getVertex 3)
      
      //ensures that v(ids: Any*) works with Java types
      val j1: java.lang.Integer = 1
      val j2: java.lang.Integer = 2
      val j3: java.lang.Integer = 3
      val vs2 = g.v(j1, j2, j3)
      vs2 must have size (3)
      vs2 must contain(g getVertex 1)
      vs2 must contain(g getVertex 2)
      vs2 must contain(g getVertex 3)
    }
    
    "unwrap ScalaGraph => Graph" in {
      val g = createTinkerGraph()
      val sg: ScalaGraph = g
      def toString(graph: Graph) = graph.toString
      
      toString(g) must_== toString(sg) //sg must be unwrapped when passed to toString
    }
  }

  "The ScalaVertex wrapper" should {
    "return all out vertices using out" in {
      val g = createTinkerGraph()
      val vs = g.getVertex(1).out.toIterable

      vs must have size (3)
      vs must contain(g getVertex 2)
      vs must contain(g getVertex 3)
      vs must contain(g getVertex 4)
    }

    "return proper out vertices using out with label" in {
      val g = createTinkerGraph()
      val vs = g.getVertex(1).out("knows").toIterable

      vs must have size (2)
      vs must contain(g getVertex 2)
      vs must contain(g getVertex 4)
    }

    //TODO vertex.outE and vertex.outE()
    //TODO vertex.in and vertex.in(label)
    //TODO vertex.inE and vertex.inE(label)
    //TODO vertex.both and vertex.bothE(label)

    "get unwrapped by the implicit" in {
      val g = createTinkerGraph()
      val v1: Vertex = g getVertex 1
      val v2: ScalaVertex = v1
      def toString(v: Vertex) = v.toString

      toString(v1) must_== toString(v2) //v2 must be unwrapped when passed to toString
    }
  }

  /*"The ScalaEdge wrapper" should {
    //TODO edge.inV
    //TODO edge.outV
    //TODO edge.bothV
    //TODO unwrap ScalaEdge => Edge
  }*/
}
